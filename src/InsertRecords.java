import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertRecords {

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

//    public void insert() {
//        String chepaiText = MFrame.chepai.getText();
//        String timeinText= MFrame.timein.getText();
//        String timeoutText= MFrame.timeout.getText();
//        String sql = "INSERT INTO user(车牌号, time_in,time_out) VALUES('"+chepaiText+"','"+timeinText+"','"+timeoutText+"')";
//
//        try {
//            Connection conn = this.connect();
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//           // pstmt.setString(1, name);
//            //pstmt.setDouble(2, capacity);
//            pstmt.executeUpdate();
//        } catch (SQLException | IOException e) {
//            System.out.println(e.getMessage());
//        }
//    }

    public  void insert(String chepaiText,String timeinText,String  timeoutText)
    {
        String sql = "INSERT INTO user(车牌号, time_in,time_out) VALUES('"+chepaiText+"','"+timeinText+"','"+timeoutText+"')";
        try {
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            // pstmt.setString(1, name);
            //pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }
    public  void insert(String data)
    {
        String sql = "INSERT INTO user(车牌号, time_in,time_out) VALUES("+data+")";
        try {
            //Connection conn = this.connect();
            Connection connection=GetSQL.connection;
            PreparedStatement pstmt = connection.prepareStatement(sql);
            // pstmt.setString(1, name);
            //pstmt.setDouble(2, capacity);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }


    }


}//原文出自【易百教程】，商业转载请联系作者获得授权，非商业请保留原文链接：https://www.yiibai.com/sqlite/java-with-sqlite.html

