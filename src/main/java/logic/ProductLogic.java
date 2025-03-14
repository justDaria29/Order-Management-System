package logic;

import model.Product;
import dao.ProductDAO;
import dto.ProductDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * ProductLogic class provides methods to handle business logic operations related to products.
 */
public class ProductLogic {

    /**
     * Creates a new product based on the provided ProductDTO object.
     *
     * @param productDTO the DTO object containing information about the product to be created
     */
    public static void createProduct(ProductDTO productDTO) {
        Product product = new Product(productDTO.getName(), productDTO.getPrice(), productDTO.getStock());
        ProductDAO productDAO = new ProductDAO();
        productDAO.insert(product);
    }

    /**
     * Edits the information of an existing product with the specified name.
     *
     * @param name       the name of the product to be edited
     * @param productDTO the DTO object containing the updated information about the product
     */
    public static void editProduct(String name, ProductDTO productDTO) {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findByName(name);
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setStock(productDTO.getStock());
        productDAO.update(product, product.getId());
    }

    /**
     * Deletes the product with the specified name.
     *
     * @param name the name of the product to be deleted
     */
    public static void deleteProduct(String name) {
        ProductDAO productDAO = new ProductDAO();
        Product product = productDAO.findByName(name);
        productDAO.delete(product.getId());
    }

    /**
     * Retrieves a list of all products.
     *
     * @return a list of all products
     */
    public static List<Product> showAllProducts() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.findAll();
        return products;
    }

    /**
     * Retrieves a list of names of all products.
     *
     * @return a list of names of all products
     */
    public static List<String> showAllProductsName() {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.findAll();
        List<String> productNames = new ArrayList<>();
        for (Product product : products) {
            productNames.add(product.getName());
        }
        return productNames;
    }

    /**
     * Searches for a product by name.
     *
     * @param searchText the text to search for (product name)
     * @return the product if found, null otherwise
     */
    public static Product searchProductByName(String searchText) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> products = productDAO.findAll();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(searchText)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Generates a random product ID.
     *
     * @return a random product ID
     */
    public static int generateRandomProductID() {
        return (int) (Math.random() * 1000);
    }

    /**
     * Sorts the list of products by name in ascending order.
     *
     * @param products the list of products to be sorted
     */
    public static void sortProductsByName(List<Product> products) {
        products.sort((p1, p2) -> p1.getName().compareToIgnoreCase(p2.getName()));
    }

    /**
     * Checks if a product is available in stock.
     *
     * @param product the product to check
     * @return true if the product is in stock, false otherwise
     */
    public static boolean isProductAvailable(Product product) {
        return product.getStock() > 0;
    }
}
