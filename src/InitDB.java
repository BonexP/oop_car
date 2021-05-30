//import java.io.IOException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InitDB {

    public static void connect(String  url) {
        Connection conn = null;
        try {
//            InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
//            // 创建并加载配置文件
//            Properties pro = new Properties();
//            pro.load(in);
//            // 获取配置文件定义的值
//            String url = pro.getProperty("DB");
            // db parameters
            //String url = GetSQL.dbUrl;
            // create a connection to the database
            conn = DriverManager.getConnection(url);

            System.out.println("Connection to SQLite has been established.");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public static void createNewTable(String url)  {
        // SQLite connection string
        //String url = GetSQL.dbUrl;

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS user (id integer primary key autoincrement,车牌号 varchar unique,time_in varchar,time_out varchar,status varchar );";

        try {
            Connection conn = DriverManager.getConnection(url);
            Statement stmt = conn.createStatement();
            stmt.execute(sql);
            System.out.println("Create table finished.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args)  {
        InputStream in = Main.class.getClassLoader().getResourceAsStream("application.properties");
        // 创建并加载配置文件
        Properties pro = new Properties();
        try {
            pro.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 获取配置文件定义的值
        String url = pro.getProperty("DB");
        connect(url);
        createNewTable(url);
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/sqlite/java-with-sqlite.html

