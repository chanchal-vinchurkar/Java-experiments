import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws Exception {
        String url = "jdbc:mysql://localhost:3306/RestaurantDB";
        String user = "root";
        String pass = "Ch@n0806";
        return DriverManager.getConnection(url, user, pass);
    }
}