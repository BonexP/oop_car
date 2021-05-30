import java.sql.*;

public class SelectRecords {

    private Connection connect() {
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

    public void selectAll() {
        String sql = "SELECT * FROM user";

        try {
            Connection conn = GetSQL.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") + "\t" + rs.getString("车牌号") + "\t" + rs.getDouble("time_in") + "\t" + rs.getDouble("time_out") + "\t" + rs.getString("status"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public String selectAll(int a){
        String sql = "SELECT * FROM user";
        StringBuilder all= new StringBuilder();
        try {
            Connection conn = GetSQL.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                all.append(rs.getInt("id")).append("\t").append(rs.getString("车牌号")).append("\t").append(rs.getDouble("time_in")).append("\t").append(rs.getDouble("time_out")).append("\t").append(rs.getString("status")).append('\n');
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return all.toString();
    }

}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/sqlite/java-with-sqlite.html

