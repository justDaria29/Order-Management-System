package logic;

import model.Client;
import dao.ClientDAO;
import dto.ClientDTO;
import java.util.ArrayList;
import java.util.List;

/**
 * ClientLogic class provides methods to handle business logic operations related to clients.
 */
public class ClientLogic {

    /**
     * Creates a new client based on the provided ClientDTO object.
     *
     * @param clientDTO the DTO object containing information about the client to be created
     */
    public static void createClient(ClientDTO clientDTO){
        Client client = new Client(clientDTO.getName(), clientDTO.getAddress(), clientDTO.getEmail());
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.insert(client);
    }

    /**
     * Edits the information of an existing client with the specified name.
     *
     * @param name the name of the client to be edited
     * @param clientDTO the DTO object containing the updated information about the client
     */
    public static void editClient(String name, ClientDTO clientDTO){
        ClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.findByName(name);
        client.setName(clientDTO.getName());
        client.setEmail(clientDTO.getEmail());
        client.setAddress(clientDTO.getAddress());
        clientDAO.update(client, client.getId());
    }

    /**
     * Deletes the client with the specified name.
     *
     * @param name the name of the client to be deleted
     */
    public static void deleteClient(String name){
        ClientDAO clientDAO = new ClientDAO();
        Client client = clientDAO.findByName(name);
        clientDAO.delete(client.getId());
    }

    /**
     * Retrieves a list of all clients.
     *
     * @return a list of all clients
     */
    public static List<Client> showAllCients(){
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.findAll();
        return clients;
    }

    /**
     * Retrieves a list of names of all clients.
     *
     * @return a list of names of all clients
     */
    public static List<String> showClientsByName(){
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.findAll();
        List<String> names = new ArrayList<>();
        for(Client client : clients){
            names.add(client.getName());
        }
        return names;
    }

    /**
     * Retrieves a list of email addresses of all clients.
     *
     * @return a list of email addresses of all clients
     */
    public static List<String> showClientsByEmail(){
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.findAll();
        List<String> emails = new ArrayList<>();
        for(Client client : clients){
            emails.add(client.getEmail());
        }
        return emails;
    }

    /**
     * Searches for a client by name or email.
     *
     * @param searchText the text to search for (can be either a name or an email)
     * @return the client if found, null otherwise
     */
    public static Client searchClientByNameOrEmail(String searchText) {
        ClientDAO clientDAO = new ClientDAO();
        List<Client> clients = clientDAO.findAll();
        for (Client client : clients) {
            if (client.getName().equalsIgnoreCase(searchText) || client.getEmail().equalsIgnoreCase(searchText)) {
                return client;
            }
        }
        return null;
    }

    /**
     * Provides information about the ClientLogic class.
     *
     * @return a string containing information about the class
     */
    public static String getClassInfo() {
        return "This class contains business logic operations related to clients.";
    }

    /**
     * Prints a welcome message.
     */
    public static void printWelcomeMessage() {
        System.out.println("Welcome to the ClientLogic class!");
    }

    /**
     * Calculates the square of a number.
     *
     * @param num the number to calculate the square of
     * @return the square of the number
     */
    public static int calculateSquare(int num) {
        return num * num;
    }
}
