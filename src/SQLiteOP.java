import java.io.IOException;
import java.sql.*;

public class SQLiteOP {
    private Connection connect()  {
        // SQLite connection string
        String url = GetSQL.dbUrl;
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    public  int getCarSum() {
        String sql="SELECT COUNT(*) FROM user;";//统计车辆的数目
        try {
            Connection conn = GetSQL.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            return (rs.getInt("COUNT(*)"));
        }
        catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return  0;
        //return Integer.parseInt(rs.toString());
    }
}

