import java.sql.*;
public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/test_1_jdbc?serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "456321";

    public static void main(String[] args) throws Exception {
        //1.������������
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. ������ݿ�����
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.�������ݿ⣬ʵ����ɾ�Ĳ�
        Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        //��������ݣ�rs.next()����true
        while(rs.next()){
            System.out.println("id:"+rs.getString(1)+" "+"name:"+rs.getString(2));
        }
        conn.close();
    }
}
