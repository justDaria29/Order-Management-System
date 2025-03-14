package dao;

import model.Product;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * ProductDAO is a data access object class that extends AbstractDAO for performing database
 * operations specifically for the Product entity.
 */
public class ProductDAO extends AbstractDAO<Product> {

    /**
     * Constructs a ProductDAO object.
     */
    public ProductDAO() {}

    /**
     * Reduces the stock of the specified product by the given quantity.
     *
     * @param product the product whose stock is to be reduced
     * @param quantity the quantity to reduce the stock by
     */
    public void stockReduction(Product product, int quantity) {
        // This query updates the stock of the product by reducing it by the specified quantity where the product's id matches.
        String sql = "UPDATE products SET stock = stock - ? WHERE id = ?";

        try (Connection connection = ConnectionFactory.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            // Set the values for the placeholders in the SQL query
            statement.setInt(1, quantity);
            statement.setInt(2, product.getId());

            // Executes the update query and returns the number of rows affected
            int rowsAffected = statement.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Stock updated successfully for product id: " + product.getId());
            } else {
                System.out.println("No product found with id: " + product.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error updating stock for product id: " + product.getId());
        }
    }
}
