
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:D:/sqlite/java-sqlite.db";

        // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS user (id integer primary key autoincrement,车牌号 varchar unique,time_in varchar,time_out varchar);";

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
    public static void main(String[] args) {
        createNewTable();
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/sqlite/java-with-sqlite.html

