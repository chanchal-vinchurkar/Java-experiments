import java.sql.*;

public class MenuItemDAO {

    public void insert(MenuItem m) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO MenuItem VALUES (?, ?, ?, ?)"
        );
        ps.setInt(1, m.id);
        ps.setString(2, m.name);
        ps.setDouble(3, m.price);
        ps.setInt(4, m.resId);
        ps.executeUpdate();
        con.close();
    }

    public ResultSet getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM MenuItem");
    }

    public ResultSet getPriceLessEqual100() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100");
    }

    public void updatePrice() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("UPDATE MenuItem SET Price=200 WHERE Price <= 100");
        con.close();
    }

    public void deleteByNameP() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        st.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");
        con.close();
    }
}