package shalgueva.sophia;

import javafx.scene.control.TextArea;
import org.sqlite.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DbHandler {
    private static final String CON_STR = "jdbc:sqlite:D:/data.db";

    private static DbHandler instance = null;

    public static synchronized DbHandler getInstance() throws SQLException {
        if (instance == null)
            instance = new DbHandler();
        return instance;
    }

    private Connection connection;

    private DbHandler() throws SQLException {
        DriverManager.registerDriver(new JDBC());
        this.connection = DriverManager.getConnection(CON_STR);
    }

    public void addProduct(Product product) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO Products(`id`,`good`, `price`) " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, product.id);
            statement.setObject(2, product.good);
            statement.setObject(3, product.price);
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEverything() {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "DELETE FROM Products;")) {
            //"CREATE TABLE Products (id, good, price);")) {
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public String getByName(String name) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "SELECT * FROM Products WHERE good = ?;")) {
            statement.setObject(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.isClosed()) {
                return resultSet.getString("good") + " " + resultSet.getString("price");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "Empty :(";
    }

    public List<Product> getAllProducts() {
        try (Statement statement = this.connection.createStatement()) {
            List<Product> products = new ArrayList<>();
            ResultSet resultSet = statement.executeQuery("SELECT id, good, price FROM products");
            int i = 0;
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("good"),
                        resultSet.getDouble("price")));
                System.out.println(products.get(i));
                i++;
            }
            return products;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }

    public void changePrice(String name, double newPrice) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "UPDATE Products SET price = ? WHERE good = ?;")) {
            statement.setObject(1, newPrice);
            statement.setObject(2, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Product> filterBase(Double Price, TextArea text) {
        try (PreparedStatement statement = this.connection.prepareStatement(
                "SELECT id, good, price FROM products WHERE price < ?;")) {
            statement.setObject(1, Price);
            ResultSet resultSet = statement.executeQuery();
            List<Product> products = new ArrayList<>();
            int i = 0;
            while (resultSet.next()) {
                products.add(new Product(resultSet.getInt("id"),
                        resultSet.getString("good"),
                        resultSet.getDouble("price")));
                text.appendText(products.get(i).toString() + "\n");
                i++;
            }
            return products;

        } catch (SQLException e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
}
