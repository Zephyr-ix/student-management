import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//这个类是用来连接数据库的工具类
public class DBUtil {
    //数据库student_db
    private static final String URL = "jdbc:mysql://localhost:3306/student_db?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //建立连接并返回
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            //如果出错，打印错误信息
            e.printStackTrace();
            return null;
        }
    }

    //关闭数据库连接
    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}