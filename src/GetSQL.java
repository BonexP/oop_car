

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class GetSQL  {
    public static String dbUrl;
    public static Connection connection;

//    public Connection connect() throws IOException {
//        // 将配置文件加载到流中
//        InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
//        // 创建并加载配置文件
//        Properties pro = new Properties();
//        pro.load(in);
//        // 获取配置文件定义的值
//        this.dbUrl = pro.getProperty("DB");
//        // SQLite connection string
//        String url = dbUrl ;
//        Connection conn = null;
//        try {
//            connection = DriverManager.getConnection(url);
//        } catch (SQLException e) {
//            System.out.println(e.getMessage());
//        }
//        return connection;
//    }
    public GetSQL() throws IOException {
        // 将配置文件加载到流中
        InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
        // 创建并加载配置文件
        Properties pro = new Properties();
        pro.load(in);
        // 获取配置文件定义的值
        dbUrl = pro.getProperty("DB");
        // SQLite connection string
        String url = dbUrl ;
        try {
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
