package dto;

/**
 * ProductDTO represents a Data Transfer Object (DTO) for a product entity.
 * It contains basic information about a product, such as name, stock, and price.
 */
public class ProductDTO {
    private final String name;
    private final int stock;
    private final double price;

    /**
     * Constructs a ProductDTO object with the specified name, price, and stock.
     *
     * @param name the name of the product
     * @param price the price of the product
     * @param stock the stock quantity of the product
     */
    public ProductDTO(String name, double price, int stock){
        this.name = name;
        this.stock = stock;
        this.price = price;
    }

    /**
     * Gets the name of the product.
     *
     * @return the name of the product
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the stock quantity of the product.
     *
     * @return the stock quantity of the product
     */
    public int getStock() {
        return stock;
    }

    /**
     * Gets the price of the product.
     *
     * @return the price of the product
     */
    public double getPrice() {
        return price;
    }
}
