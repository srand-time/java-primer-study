import java.sql.*;
public class DbUtil {

    public static final String URL = "jdbc:mysql://localhost:3306/test_1_jdbc?serverTimezone=GMT%2B8";
    public static final String USER = "root";
    public static final String PASSWORD = "456321";

    public static void main(String[] args) throws Exception {
        //1.加载驱动程序
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2. 获得数据库连接
        Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
        //3.操作数据库，实现增删改查
        Statement stmt = conn.createStatement();
       ResultSet rs = stmt.executeQuery("SELECT * FROM students");
        //如果有数据，rs.next()返回true
        while(rs.next()){
            System.out.println("id:"+rs.getString(1)+" "+"name:"+rs.getString(2));
        }
        conn.close();
    }
}
