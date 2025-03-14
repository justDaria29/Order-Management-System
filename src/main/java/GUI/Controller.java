package GUI;

import dto.ClientDTO;
import dto.OrderDTO;
import dto.ProductDTO;
import logic.ClientLogic;
import logic.OrderLogic;
import logic.ProductLogic;
import model.Client;
import model.Product;

import java.util.List;

/**
 * Controller class acts as an intermediary between the GUI (user interface) and the logic layer.
 * It provides methods to interact with the business logic layer to perform various operations such as
 * creating clients, products, orders, retrieving data, deleting clients and products, and editing client and product information.
 */
public class Controller {

    /**
     * Creates a new client using the provided ClientDTO object.
     *
     * @param clientDTO the DTO object containing information about the client to be created
     */
    public static void createClient(ClientDTO clientDTO){
        ClientLogic.createClient(clientDTO);
    }

    /**
     * Creates a new product using the provided ProductDTO object.
     *
     * @param productDTO the DTO object containing information about the product to be created
     */
    public static void createProduct(ProductDTO productDTO){
        ProductLogic.createProduct(productDTO);
    }

    /**
     * Creates a new order using the provided OrderDTO object.
     *
     * @param orderDTO the DTO object containing information about the order to be created
     * @throws IllegalArgumentException if the order data is invalid
     */
    public static void createOrder(OrderDTO orderDTO) throws IllegalArgumentException {
        OrderLogic.createOrder(orderDTO);
    }

    /**
     * Retrieves a list of all clients from the database.
     *
     * @return a list of all clients
     */
    public static List<Client> getAllClients(){
        return ClientLogic.showAllCients();
    }

    /**
     * Retrieves a list of all products from the database.
     *
     * @return a list of all products
     */
    public static List<Product> getAllProducts(){
        return ProductLogic.showAllProducts();
    }

    /**
     * Retrieves a list of all orders from the database.
     *
     * @return a list of all orders
     */
    public static List<OrderDTO> getAllOrders(){
        return OrderLogic.showAllOrders();
    }

    /**
     * Retrieves a list of names of all clients from the database.
     *
     * @return a list of names of all clients
     */
    public static List<String> getAllClientsNames(){
        return ClientLogic.showClientsByName();
    }

    /**
     * Retrieves a list of names of all products from the database.
     *
     * @return a list of names of all products
     */
    public static List<String> getAllProductsName(){
        return ProductLogic.showAllProductsName();
    }

    /**
     * Deletes a client with the specified name from the database.
     *
     * @param name the name of the client to be deleted
     */
    public static void deleteClient(String name) {
        ClientLogic.deleteClient(name);
    }

    /**
     * Updates the information of a client with the specified name with the provided ClientDTO object.
     *
     * @param name the name of the client to be updated
     * @param clientDTO the DTO object containing the updated information about the client
     */
    public static void editClient(String name, ClientDTO clientDTO) {
        ClientLogic.editClient(name, clientDTO);
    }

    /**
     * Deletes a product with the specified name from the database.
     *
     * @param name the name of the product to be deleted
     */
    public static void deleteProduct(String name) {
        ProductLogic.deleteProduct(name);
    }

    /**
     * Updates the information of a product with the specified name with the provided ProductDTO object.
     *
     * @param name the name of the product to be updated
     * @param productDTO the DTO object containing the updated information about the product
     */
    public static void editProduct(String name, ProductDTO productDTO) {
        ProductLogic.editProduct(name, productDTO);
    }
}
