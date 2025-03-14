package main;

import GUI.Controller;
import GUI.View;

/**
 * The main entry point for the Orders Management application.
 */
public class Main {

    /**
     * The main method which sets up and displays the application view.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        View view = new View("Orders Management");
        view.setVisible(true);
    }
}
