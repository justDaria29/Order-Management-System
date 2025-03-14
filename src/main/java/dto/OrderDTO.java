package dto;

/**
 * OrderDTO represents a Data Transfer Object (DTO) for an order entity.
 * It contains basic information about an order, such as the names of the client and product,
 * and the quantity of the product ordered.
 */
public class OrderDTO {
    private final String nameC;
    private final String nameP;
    private final int quantity;

    /**
     * Constructs an OrderDTO object with the specified client name, product name, and quantity.
     *
     * @param nameC the name of the client
     * @param nameP the name of the product
     * @param quantity the quantity of the product ordered
     */
    public OrderDTO(String nameC, String nameP, int quantity){
        super();
        this.nameC = nameC;
        this.nameP = nameP;
        this.quantity = quantity;
    }

    /**
     * Gets the name of the client associated with the order.
     *
     * @return the name of the client
     */
    public String getNameC() {
        return nameC;
    }

    /**
     * Gets the name of the product associated with the order.
     *
     * @return the name of the product
     */
    public String getNameP() {
        return nameP;
    }

    /**
     * Gets the quantity of the product ordered.
     *
     * @return the quantity of the product ordered
     */
    public int getQuantity() {
        return quantity;
    }
}
