import java.sql.*;

public class RestaurantDAO {

    public void insert(Restaurant r) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO Restaurant VALUES (?, ?, ?)"
        );
        ps.setInt(1, r.id);
        ps.setString(2, r.name);
        ps.setString(3, r.address);
        ps.executeUpdate();
        con.close();
    }

    public ResultSet getAll() throws Exception {
        Connection con = DBConnection.getConnection();
        Statement st = con.createStatement();
        return st.executeQuery("SELECT * FROM Restaurant");
    }

    public void updateName(int id, String name) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE Restaurant SET Name=? WHERE Id=?"
        );
        ps.setString(1, name);
        ps.setInt(2, id);
        ps.executeUpdate();
        con.close();
    }

    public void delete(int id) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "DELETE FROM Restaurant WHERE Id=?"
        );
        ps.setInt(1, id);
        ps.executeUpdate();
        con.close();
    }
}