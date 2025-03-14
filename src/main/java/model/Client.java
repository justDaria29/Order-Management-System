package model;

/**
 * The Client class represents a client entity.
 */
public class Client {
    private int id;
    private String name;
    private String email;
    private String address;

    /**
     * Default constructor.
     */
  public Client() {}

    /**
     * Parameterized constructor.
     *
     * @param id      the ID of the client
     * @param name    the name of the client
     * @param address the address of the client
     * @param email   the email of the client
     */
    public Client(int id, String name, String address, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.address = address;
    }

    /**
     * Get the ID of the client.
     *
     * @return the ID of the client
     */
    public int getId() {
        return id;
    }

    /**
     * Set the ID of the client.
     *
     * @param id the ID of the client
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Get the name of the client.
     *
     * @return the name of the client
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the client.
     *
     * @param name the name of the client
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Get the email of the client.
     *
     * @return the email of the client
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the email of the client.
     *
     * @param email the email of the client
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Get the address of the client.
     *
     * @return the address of the client
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address of the client.
     *
     * @param address the address of the client
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * Override the toString method to provide a string representation of the client object.
     *
     * @return a string representation of the client object
     */
    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    /**
     * Parameterized constructor.
     *
     * @param name    the name of the client
     * @param address the address of the client
     * @param email   the email of the client
     */
    public Client(String name, String address, String email) {
        this.name = name;
        this.address = address;
        this.email = email;
    }
}
