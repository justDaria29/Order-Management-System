package model;

/**
 * The Order class represents an order entity.
 */
public class Order {
    private int id;
    private int idC;
    private int idP;
    private int quantity;

    /**
     * Default constructor.
     */
    public Order() {}

    /**
     * Parameterized constructor.
     *
     * @param id       the ID of the order
     * @param idC      the ID of the client associated with the order
     * @param idP      the ID of the product associated with the order
     * @param quantity the quantity of the product in the order
     */
    public Order(int id, int idC, int idP, int quantity) {
        this.id = id;
        this.idC = idC;
        this.idP = idP;
        this.quantity = quantity;
    }

    /**
     * Get the ID of the order.
     *
     * @return the ID of the order
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the order.
     *
     * @param id the ID of the order
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the ID of the client associated with the order.
     *
     * @return the ID of the client associated with the order
     */
    public int getIdC() {
        return idC;
    }

    /**
     * Set the ID of the client associated with the order.
     *
     * @param idC the ID of the client associated with the order
     */
    public void setIdC(int idC) {
        this.idC = idC;
    }

    /**
     * Get the ID of the product associated with the order.
     *
     * @return the ID of the product associated with the order
     */
    public int getIdP() {
        return idP;
    }

    /**
     * Set the ID of the product associated with the order.
     *
     * @param idP the ID of the product associated with the order
     */
    public void setIdP(int idP) {
        this.idP = idP;
    }

    /**
     * Get the quantity of the product in the order.
     *
     * @return the quantity of the product in the order
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Set the quantity of the product in the order.
     *
     * @param quantity the quantity of the product in the order
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Override the toString method to provide a string representation of the order object.
     *
     * @return a string representation of the order object
     */
    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", client's id=" + idC +
                ", product's id=" + idP +
                ", quantity=" + quantity +
                '}';
    }
}
