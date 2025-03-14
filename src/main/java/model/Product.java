package model;

/**
 * The Product class represents a product entity.
 */
public class Product {
    private int id;
    private String name;
    private double price;
    private int stock;

    /**
     * Default constructor.
     */
  public Product() {}

    /**
     * Parameterized constructor.
     *
     * @param id    the ID of the product
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the stock of the product
     */
    public Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    /**
     * Get the ID of the product.
     *
     * @return the ID of the product
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the product.
     *
     * @param id the ID of the product
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the product.
     *
     * @param name the name of the product
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }

    /**
     * Set the price of the product.
     *
     * @param price the price of the product
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Get the stock of the product.
     *
     * @return the stock of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     * Set the stock of the product.
     *
     * @param stock the stock of the product
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    /**
     * Override the toString method to provide a string representation of the product object.
     *
     * @return a string representation of the product object
     */
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }

    /**
     * Constructor to create a product object with name, price, and stock.
     *
     * @param name  the name of the product
     * @param price the price of the product
     * @param stock the stock of the product
     */
    public Product(String name, double price, int stock) {
        this.name = name;
        this.price = price;
        this.stock = stock;
    }
}
