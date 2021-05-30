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
        String sql="SELECT COUNT(*) FROM user where status = 0;";//统计没有出库车辆的数目
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
    public  void carIn(String chepaiText,String timeIn)
    {
        String sql="INSERT INTO user(车牌号, time_in,status) VALUES('"+chepaiText+"','"+timeIn+"','0');";
        try{
            Connection conn=GetSQL.connection;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void carOut(String chepaiText,String timeout)
    {
        String sql="UPDATE user set time_out="+timeout+", status=1 where 车牌号='"+chepaiText+"';";
        System.out.println(sql);
        try{
            Connection conn=GetSQL.connection;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
    public  void refresh()
    {
        String sql="delete from user where status = 1;";
        System.out.println(sql);
        try{
            Connection conn=GetSQL.connection;
            PreparedStatement pstmt=conn.prepareStatement(sql);
            pstmt.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}

