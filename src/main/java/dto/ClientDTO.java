package dto;

/**
 * ClientDTO represents a Data Transfer Object (DTO) for a client entity.
 * It contains basic information about a client, such as name, email, and address.
 */
public class ClientDTO {
    private final String name;
    private final String email;
    private final String address;

    /**
     * Constructs a ClientDTO object with the specified name, address, and email.
     *
     * @param name the name of the client
     * @param address the address of the client
     * @param email the email address of the client
     */
    public ClientDTO(String name, String address, String email){
        this.name = name;
        this.address = address;
        this.email = email;
    }

    /**
     * Gets the name of the client.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the email address of the client.
     *
     * @return the email address of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets the address of the client.
     *
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }
}
