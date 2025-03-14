package logic;

import model.*;
import dao.*;
import dto.*;
import java.util.ArrayList;
import java.util.List;

/**
 * OrderLogic class provides methods to handle business logic operations related to orders.
 */
public class OrderLogic {

    /**
     * Creates a new order based on the provided OrderDTO object.
     *
     * @param orderDTO the DTO object containing information about the order to be created
     * @throws IllegalArgumentException if the client or product specified in the orderDTO is not found, or if there is not enough stock for the product
     */
    public static void createOrder(OrderDTO orderDTO) throws IllegalArgumentException {
        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();
        OrderDAO orderDAO = new OrderDAO();

        // Find the client by name
        Client client = clientDAO.findByName(orderDTO.getNameC());
        if (client == null) {
            throw new IllegalArgumentException("Client not found: " + orderDTO.getNameC());
        }

        // Find the product by name
        Product product = productDAO.findByName(orderDTO.getNameP());
        if (product == null) {
            throw new IllegalArgumentException("Product not found: " + orderDTO.getNameP());
        }

        // Check if there is enough stock
        if (product.getStock() < orderDTO.getQuantity()) {
            throw new IllegalArgumentException("Not enough stock for product: " + orderDTO.getNameP());
        }

        // Create the order
        Order order = new Order();
        order.setIdC(client.getId());
        order.setIdP(product.getId());
        order.setQuantity(orderDTO.getQuantity());

        // Insert the order into the database
        orderDAO.insert(order);

        // Update the product stock
        productDAO.stockReduction(product, orderDTO.getQuantity());
    }

    /**
     * Retrieves a list of all orders.
     *
     * @return a list of all orders
     */
    public static List<OrderDTO> showAllOrders() {
        OrderDAO orderDAO = new OrderDAO();
        ClientDAO clientDAO = new ClientDAO();
        ProductDAO productDAO = new ProductDAO();

        List<Order> orders = orderDAO.findAll();
        List<OrderDTO> orderDTOs = new ArrayList<>();

        for (Order order : orders) {
            Client client = clientDAO.findById(order.getIdC());
            Product product = productDAO.findById(order.getIdP());

            if (client != null && product != null) {
                OrderDTO orderDTO = new OrderDTO(client.getName(), product.getName(), order.getQuantity());
                orderDTOs.add(orderDTO);
            }
        }

        return orderDTOs;
    }

    /**
     * Provides information about the OrderLogic class.
     *
     * @return a string containing information about the class
     */
    public static String getClassInfo() {
        return "This class contains business logic operations related to orders.";
    }

    /**
     * Prints a message indicating the number of orders processed.
     *
     * @param count the number of orders processed
     */
    public static void printProcessedOrdersCount(int count) {
        System.out.println("Number of processed orders: " + count);
    }

    /**
     * Calculates the total quantity of all orders.
     *
     * @param orders the list of orders
     * @return the total quantity of all orders
     */
    public static int calculateTotalQuantity(List<OrderDTO> orders) {
        int totalQuantity = 0;
        for (OrderDTO order : orders) {
            totalQuantity += order.getQuantity();
        }
        return totalQuantity;
    }
}
