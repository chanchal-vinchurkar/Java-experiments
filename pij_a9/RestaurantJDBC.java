import java.sql.*;

public class RestaurantJDBC {

    static final String URL = "jdbc:mysql://localhost:3306/RestaurantDB";
    static final String USER = "root";
    static final String PASS = "Ch@n0806";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(URL, USER, PASS)) {

            Statement stmt = conn.createStatement();

            stmt.executeUpdate("INSERT INTO Restaurant VALUES " +
                    "(1,'Cafe Java','Pune')," +
                    "(2,'Food Corner','Mumbai')," +
                    "(3,'Spice Hub','Delhi')," +
                    "(4,'Tasty Treat','Pune')," +
                    "(5,'Burger House','Bangalore')," +
                    "(6,'Pizza Point','Chennai')," +
                    "(7,'Green Bowl','Pune')," +
                    "(8,'Snack Shack','Hyderabad')," +
                    "(9,'Ocean Cafe','Goa')," +
                    "(10,'Urban Eatery','Nagpur')");

            stmt.executeUpdate("INSERT INTO MenuItem VALUES " +
                    "(1,'Pasta',120,1)," +
                    "(2,'Pizza',250,1)," +
                    "(3,'Burger',80,2)," +
                    "(4,'Paneer Tikka',150,3)," +
                    "(5,'Pancake',90,4)," +
                    "(6,'Sandwich',60,5)," +
                    "(7,'Salad',70,1)," +
                    "(8,'Pav Bhaji',95,2)," +
                    "(9,'Fries',50,6)," +
                    "(10,'Noodles',110,1)");

            System.out.println("\n=== ALL MENU ITEMS ===");
            printResultSet(stmt.executeQuery("SELECT * FROM MenuItem"));

            System.out.println("\n=== MENU ITEMS WITH PRICE <= 100 ===");
            printResultSet(stmt.executeQuery("SELECT * FROM MenuItem WHERE Price <= 100"));

            System.out.println("\n=== MENU ITEMS IN 'Cafe Java' ===");
            printResultSet(stmt.executeQuery(
                    "SELECT m.* FROM MenuItem m " +
                    "JOIN Restaurant r ON m.ResId = r.Id " +
                    "WHERE r.Name = 'Cafe Java'"
            ));

            stmt.executeUpdate("UPDATE MenuItem SET Price = 200 WHERE Price <= 100");

            System.out.println("\n=== AFTER UPDATE (PRICE <= 100 SET TO 200) ===");
            printResultSet(stmt.executeQuery("SELECT * FROM MenuItem"));

            
            stmt.executeUpdate("DELETE FROM MenuItem WHERE Name LIKE 'P%'");

            System.out.println("\n=== AFTER DELETING ITEMS STARTING WITH 'P' ===");
            printResultSet(stmt.executeQuery("SELECT * FROM MenuItem"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    static void printResultSet(ResultSet rs) throws SQLException {

        ResultSetMetaData rsmd = rs.getMetaData();
        int cols = rsmd.getColumnCount();

        // Print column headers
        for (int i = 1; i <= cols; i++) {
            System.out.print(rsmd.getColumnName(i) + "\t\t");
        }
        System.out.println();

        // Print rows
        while (rs.next()) {
            for (int i = 1; i <= cols; i++) {
                System.out.print(rs.getString(i) + "\t\t");
            }
            System.out.println();
        }
    }
}