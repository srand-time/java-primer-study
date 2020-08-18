package main;
import java.io.IOException;
import java.sql.ResultSet;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/test")
public class test {
	boolean flag_complete_user=false;
	String user_name;
	String user_code;
	
	@OnMessage
    public void onMessage(String message, Session session) 
        throws Exception {
		if(message.substring(0,8).equals("username"))
		{
			user_name=message.substring(8);
			flag_complete_user=false;
		}
		
		else if(message.substring(0,8).equals("usercode"))
		{
			user_code=message.substring(8);
			flag_complete_user=true;
		}
		
		if(flag_complete_user)
		{
			System.out.println("username"+user_name+"usercode"+user_code);
			//使用前创建连接
			sql_va.DataBase_Driver();
			
			
			ResultSet rs = sql_va.stmt.executeQuery("SELECT code FROM user_prop where id="
			+"'"+user_name+"';");
			
			if(!rs.next())//就是说查询到了空集，没有这个用户名
				session.getBasicRemote().sendText("no this user");
				
			else if(user_code.equals(rs.getString(1)))
				{
					System.out.println("successful connect");
					ResultSet rs2 = sql_va.stmt.executeQuery("SELECT * FROM user_prop");
					rs2.next();
					String []data=new String[5];
					for(int i=0;i<5;i++)
						data[i]=rs2.getString(i+1);
					session.getBasicRemote().sendText("acc_prop"+data[2]);
					session.getBasicRemote().sendText("re_prop"+data[3]);
					session.getBasicRemote().sendText("cash"+data[4]);
				}
			else if(!user_code.equals(rs.getString(1)))
				{
					System.out.println("fail to connect");
					session.getBasicRemote().sendText("fail to connect");
				}
			//查询完之后关闭连接
			sql_va.conn.close();
		}
    }
	
	@OnClose
	public void OnClose(Session session) 
	{
		if (session != null) {
				try {
					session.close();
					System.out.println("closed");
				} catch (IOException e) {
					System.out.println("failed");
					e.printStackTrace();
				}
			}
	}
}