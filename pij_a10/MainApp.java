import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.ResultSet;

public class MainApp extends Application {

    RestaurantDAO rdao = new RestaurantDAO();
    MenuItemDAO mdao = new MenuItemDAO();
    TextArea output = new TextArea();

    @Override
    public void start(Stage stage) {

        Button b1 = new Button("Insert Restaurant");
        Button b2 = new Button("Show Restaurants");
        Button b3 = new Button("Insert MenuItem");
        Button b4 = new Button("Show MenuItems");
        Button b5 = new Button("Price <= 100");
        Button b6 = new Button("Update Price <=100 → 200");
        Button b7 = new Button("Delete Name starts with P");

        b1.setOnAction(e -> {
            try {
                rdao.insert(new Restaurant(11, "Test Cafe", "Pune"));
                output.setText("Restaurant Inserted!");
            } catch (Exception ex) { output.setText(ex.getMessage()); }
        });

        b2.setOnAction(e -> showRestaurants());

        b3.setOnAction(e -> {
            try {
                mdao.insert(new MenuItem(11, "Burger", 90, 11));
                output.setText("MenuItem Inserted!");
            } catch (Exception ex) { output.setText(ex.getMessage()); }
        });

        b4.setOnAction(e -> showMenuItems());

        b5.setOnAction(e -> showPriceLess100());

        b6.setOnAction(e -> {
            try {
                mdao.updatePrice();
                output.setText("Prices Updated!");
            } catch (Exception ex) { output.setText(ex.getMessage()); }
        });

        b7.setOnAction(e -> {
            try {
                mdao.deleteByNameP();
                output.setText("Deleted items starting with P");
            } catch (Exception ex) { output.setText(ex.getMessage()); }
        });

        VBox root = new VBox(10,
                b1, b2, b3, b4, b5, b6, b7, output);

        stage.setScene(new Scene(root, 500, 500));
        stage.setTitle("Restaurant Menu CRUD App");
        stage.show();
    }

    void showRestaurants() {
        try {
            ResultSet rs = rdao.getAll();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt(1)).append(" ")
                  .append(rs.getString(2)).append(" ")
                  .append(rs.getString(3)).append("\n");
            }
            output.setText(sb.toString());
        } catch (Exception e) { output.setText(e.getMessage()); }
    }

    void showMenuItems() {
        try {
            ResultSet rs = mdao.getAll();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt(1)).append(" ")
                  .append(rs.getString(2)).append(" ")
                  .append(rs.getDouble(3)).append(" ")
                  .append(rs.getInt(4)).append("\n");
            }
            output.setText(sb.toString());
        } catch (Exception e) { output.setText(e.getMessage()); }
    }

    void showPriceLess100() {
        try {
            ResultSet rs = mdao.getPriceLessEqual100();
            StringBuilder sb = new StringBuilder();
            while (rs.next()) {
                sb.append(rs.getInt(1)).append(" ")
                  .append(rs.getString(2)).append(" ")
                  .append(rs.getDouble(3)).append("\n");
            }
            output.setText(sb.toString());
        } catch (Exception e) { output.setText(e.getMessage()); }
    }

    public static void main(String[] args) {
        launch(args);
    }
}