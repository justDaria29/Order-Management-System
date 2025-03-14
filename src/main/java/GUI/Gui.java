//package GUI;
////import dto.*;
////import javax.swing.*;
////import javax.swing.table.DefaultTableModel;
////import java.awt.*;
////import java.lang.reflect.Field;
////import java.util.Arrays;
////import java.util.Objects;
////import java.util.List;
////public class View extends JFrame{
////
////    JLabel panel1 = new JLabel();
////    public JLabel titleLabel = new JLabel("Orders Management System");
////    public JLabel clientsLabel = new JLabel("Clients:");
////    public JLabel ordersLabel = new JLabel("Orders:");
////    public JLabel productsLabel = new JLabel("Products:");
////    public JLabel logsLabel = new JLabel("Logs:");
////    private JButton viewClients = new JButton("View");
////    private JButton addClients = new JButton("Add");
////    private JButton editClients = new JButton("Edit");
////    private JButton deleteClients = new JButton("Delete");
////    private JButton viewOrders = new JButton("View");
////    private JButton addOrders = new JButton("Add");
////    private JButton viewProduct = new JButton("View");
////    private JButton addProduct = new JButton("Add");
////    private JButton editProduct = new JButton("Edit");
////    private JButton deleteProduct = new JButton("Delete");
////    private JButton viewLogs = new JButton("View");
////    JFrame frame=new JFrame();
////    public View(){
////        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
////        frame.setSize(600, 300);
////
////        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
////        titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
////        titleLabel.setBounds(100, 15, 350, 40);
////
////        clientsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
////        clientsLabel.setBounds(10, 70, 150, 25);
////
////        ordersLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
////        ordersLabel.setBounds(10, 110, 150, 25);
////
////        productsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
////        productsLabel.setBounds(10, 150, 150, 25);
////
////        logsLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
////        logsLabel.setBounds(10, 190, 150, 25);
////
////        viewClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        viewClients.setBounds(80, 70, 70, 20);
////
////        addClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        addClients.setBounds(180, 70, 70, 20);
////
////        editClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        editClients.setBounds(280, 70, 70, 20);
////
////        deleteClients.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        deleteClients.setBounds(380, 70, 90, 20);
////
////        viewOrders.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        viewOrders.setBounds(80, 110, 70, 20);
////
////        addOrders.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        addOrders.setBounds(180, 110, 70, 20);
////
////        viewProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        viewProduct.setBounds(80, 150, 70, 20);
////
////        addProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        addProduct.setBounds(180, 150, 70, 20);
////
////        editProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        editProduct.setBounds(280, 150, 70, 20);
////
////        deleteProduct.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        deleteProduct.setBounds(380, 150, 90, 20);
////
////        viewLogs.setFont(new Font("Tahoma", Font.PLAIN, 15));
////        viewLogs.setBounds(80, 190, 70, 20);
////
////        panel1.add(titleLabel);
////        panel1.add(clientsLabel);
////        panel1.add(ordersLabel);
////        panel1.add(productsLabel);
////        panel1.add(logsLabel);
////        panel1.add(viewClients);
////        panel1.add(addClients);
////        panel1.add(editClients);
////        panel1.add(deleteClients);
////        panel1.add(viewOrders);
////        panel1.add(addOrders);
////        panel1.add(viewProduct);
////        panel1.add(addProduct);
////        panel1.add(editProduct);
////        panel1.add(deleteProduct);
////        panel1.add(viewLogs);
////
////        frame.setContentPane(panel1);
////    }
////    public void setVisibility(boolean isVisible) {
////        frame.setVisible(isVisible);
////    }
////}
//
//package GUI;
//
//import dto.ProductDTO;
//import model.Client;
//import model.Order;
//import model.Product;
//import start.Reflection;
//
//import java.awt.*;
//import java.util.Comparator;
//import java.util.List;
//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.table.JTableHeader;
//import javax.swing.table.TableRowSorter;
//
//public class View {
//
//    JFrame frameP = new JFrame("Product");
//    JFrame frameC = new JFrame("Client");
//    JFrame frameO = new JFrame("Order");
//    //-------------------------------------------------
//    // PRODUCT
//    //-------------------------------------------------
//    JLabel labelSearchTextP = new JLabel("Find: ");
//    JTextField textFieldSearchTextP = new JTextField();
//    JButton searchButtonP = new JButton("Search");
//
//    //-------------------------------------------------
//    // ADD
//    //-------------------------------------------------
//
//    JLabel labelAddNameP = new JLabel("Name: ");
//    JTextField textFieldAddNameP = new JTextField();
//    JLabel labelAddStockP = new JLabel("Stock:");
//    JTextField textFieldAddStockP = new JTextField();
//    JLabel labelAddPriceP = new JLabel("Price:");
//    JTextField textFieldAddPriceP = new JTextField();
//    JButton addButtonP = new JButton("Add");
//
//    //-------------------------------------------------
//    // DELETE
//    //-------------------------------------------------
//    JLabel labelDeleteIdP = new JLabel("Id: ");
//    JTextField textFieldDeleteIdP = new JTextField();
//    JButton deleteButtonP = new JButton("Delete");
//
//    //-------------------------------------------------
//    // UPDATE
//    //-------------------------------------------------
//    JLabel labelIdP = new JLabel("Id: ");
//    JLabel labelId1P = new JLabel();
//    JLabel labelUpdateNameP = new JLabel("Name: ");
//    JTextField textFieldUpdateNameP = new JTextField();
//    JLabel labelUpdateStockP = new JLabel("Stock: ");
//    JTextField textFieldUpdateStockP = new JTextField();
//    JLabel labelUpdatePriceP = new JLabel("Price: ");
//    JTextField textFieldUpdatePriceP = new JTextField();
//    JButton updateButtonP = new JButton("Update");
//    JTable tableP = new JTable();
//    JScrollPane scrollPaneP = new JScrollPane(tableP);
//
//    //-------------------------------------------------
//    // CLIENT
//    //-------------------------------------------------
//
//    JLabel labelSearchTextC = new JLabel("Find: ");
//    JTextField textFieldSearchTextC = new JTextField();
//    JButton searchButtonC = new JButton("Search");
//
//    //-------------------------------------------------
//    // ADD
//    //-------------------------------------------------
//
//    JLabel labelAddNameC = new JLabel("Name: ");
//    JTextField textFieldAddNameC = new JTextField();
//    JLabel labelAddAddressC = new JLabel("Address:");
//    JTextField textFieldAddAddressC = new JTextField();
//    JLabel labelAddAgeC = new JLabel("Age:");
//    JTextField textFieldAddAgeC = new JTextField();
//    JLabel labelAddEmailC = new JLabel("Email:");
//    JTextField textFieldAddEmailC = new JTextField();
//    JButton addButtonC = new JButton("Add");
//
//    //-------------------------------------------------
//    // DELETE
//    //-------------------------------------------------
//    JLabel labelDeleteIdC = new JLabel("Id: ");
//    JTextField textFieldDeleteIdC = new JTextField();
//    JButton deleteButtonC = new JButton("Delete");
//
//    //-------------------------------------------------
//    // UPDATE
//    //-------------------------------------------------
//    JLabel labelIdC = new JLabel("Id: ");
//    JLabel labelId1C = new JLabel();
//    JLabel labelUpdateNameC = new JLabel("Name: ");
//    JTextField textFieldUpdateNameC = new JTextField();
//    JLabel labelUpdateAddressC = new JLabel("Address: ");
//    JTextField textFieldUpdateAddressC = new JTextField();
//    JLabel labelUpdateAgeC = new JLabel("Age: ");
//    JTextField textFieldUpdateAgeC = new JTextField();
//    JLabel labelUpdateEmailC = new JLabel("Email: ");
//    JTextField textFieldUpdateEmailC = new JTextField();
//    JButton updateButtonC = new JButton("Update");
//    JTable tableC = new JTable();
//    JScrollPane scrollPaneC = new JScrollPane(tableC);
//
//    //-------------------------------------------------
//    // ORDER
//    //-------------------------------------------------
//
//    JLabel labelClientO = new JLabel("Client:");
//    JLabel labelClientIdO = new JLabel("");
//    JLabel labelClientNameO = new JLabel("");
//    JLabel labelProductO = new JLabel("Product: ");
//    JLabel labelProductIdO = new JLabel("");
//    JLabel labelProductNameO = new JLabel("");
//
//    JLabel labelAmountO = new JLabel("Amount:");
//    JTextField textFieldAmountO = new JTextField();
//
//    JButton placeOrderButtonC = new JButton("Place Order");
//    JTable tableO = new JTable();
//    JScrollPane scrollPaneO = new JScrollPane(tableO);
//
//
//    public View(Controller controller) {
//
//        frameP.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameP.setBounds(50, 50, 500, 400);
//        frameP.getContentPane().setLayout(null);
//
//        frameC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameC.setBounds(650, 50, 500, 450);
//        frameC.getContentPane().setLayout(null);
//
//        frameO.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frameO.setBounds(50, 455, 500, 300);
//        frameO.getContentPane().setLayout(null);
//
//        Color myGrey =new Color(43,45,48);
//
//        frameP.setBackground(myGrey);
//        frameC.setBackground(myGrey);
//        frameO.setBackground(myGrey);
//
//        //-------------------------------------------------
//        // PRODUCT
//        //-------------------------------------------------
//        labelSearchTextP.setForeground(Color.WHITE);
//        labelAddNameP.setForeground(Color.WHITE);
//        labelAddStockP.setForeground(Color.WHITE);
//        labelAddPriceP.setForeground(Color.WHITE);
//        labelUpdateNameP.setForeground(Color.WHITE);
//        labelUpdateStockP.setForeground(Color.WHITE);
//        labelUpdatePriceP.setForeground(Color.WHITE);
//        labelIdP.setForeground(Color.WHITE);
//        labelDeleteIdP.setForeground(Color.WHITE);
//        labelId1P.setForeground(Color.WHITE);
//
//        //searchButtonP.addActionListener(e -> controller.searchButtonClickedP());
//        //-------------------------------------------------
//        // ADD
//        //-------------------------------------------------
//        addButtonP.addActionListener(e -> controller.createProduct(new ProductDTO(getAddNameP(),getAddPriceP(),getAddStockP())));
//        //-------------------------------------------------
//        // DELETE
//        //-------------------------------------------------
//        deleteButtonP.addActionListener(e -> controller.deleteProduct(getDeleteIdP()));
//        //-------------------------------------------------
//        // UPDATE
//        //-------------------------------------------------
//        tableP.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                DefaultTableModel model = (DefaultTableModel) tableP.getModel();
//                Integer id = (Integer) model.getValueAt(tableP.getSelectedRow(), 0);
//                String name = (String) model.getValueAt(tableP.getSelectedRow(), 1);
//                Integer stock = (Integer) model.getValueAt(tableP.getSelectedRow(), 2);
//                Integer price = (Integer) model.getValueAt(tableP.getSelectedRow(), 3);
//                labelId1P.setText(String.valueOf(id));
//                textFieldUpdateNameP.setText(name);
//                labelProductIdO.setText(String.valueOf(id));
//                labelProductNameO.setText(name);
//                textFieldUpdateStockP.setText(String.valueOf(stock));
//                textFieldUpdatePriceP.setText(String.valueOf(price));
//            }
//        });
//
//        updateButtonP.addActionListener(e -> controller.editProduct(getUpdateNameP(),new ProductDTO(getUpdateNameP(),Double.parseDouble(getUpdatePriceP()),Integer.parseInt(getUpdateStockP()))));
//
//        labelSearchTextP.setBounds(320, 10, 100, 20);
//        textFieldSearchTextP.setBounds(370, 10, 100, 20);
//        searchButtonP.setBounds(370, 35, 100, 20);
//
//        labelAddNameP.setBounds(320, 65, 100, 20);
//        textFieldAddNameP.setBounds(370, 65, 100, 20);
//        labelAddStockP.setBounds(320, 90, 100, 20);
//        textFieldAddStockP.setBounds(370, 90, 100, 20);
//        labelAddPriceP.setBounds(320, 115, 100, 20);
//        textFieldAddPriceP.setBounds(370, 115, 100, 20);
//        addButtonP.setBounds(370, 140, 100, 20);
//
//        labelDeleteIdP.setBounds(320, 170, 100, 20);
//        textFieldDeleteIdP.setBounds(370, 170, 100, 20);
//        deleteButtonP.setBounds(370, 195, 100, 20);
//
//        labelIdP.setBounds(320, 225, 100, 20);
//        labelId1P.setBounds(370, 225, 100, 20);
//        labelId1P.setBackground(Color.WHITE);
//        labelUpdateNameP.setBounds(320, 250, 100, 20);
//        textFieldUpdateNameP.setBounds(370, 250, 100, 20);
//        labelUpdateStockP.setBounds(320, 275, 100, 20);
//        textFieldUpdateStockP.setBounds(370, 275, 100, 20);
//        labelUpdatePriceP.setBounds(320, 300, 100, 20);
//        textFieldUpdatePriceP.setBounds(370, 300, 100, 20);
//
//        updateButtonP.setBounds(370, 325, 100, 20);
//
//        scrollPaneP.setBounds(10, 10, 300, 335);
//
//        JLabel labelPaneP = new JLabel();
//        labelPaneP.setBounds(0, 0, 300, 300);
//        labelPaneP.add(scrollPaneP);
//        labelPaneP.add(labelSearchTextP);
//        labelPaneP.add(textFieldSearchTextP);
//        labelPaneP.add(searchButtonP);
//        labelPaneP.add(labelAddNameP);
//        labelPaneP.add(textFieldAddNameP);
//        labelPaneP.add(labelAddStockP);
//        labelPaneP.add(textFieldAddStockP);
//        labelPaneP.add(labelAddPriceP);
//        labelPaneP.add(textFieldAddPriceP);
//        labelPaneP.add(addButtonP);
//        labelPaneP.add(labelDeleteIdP);
//        labelPaneP.add(textFieldDeleteIdP);
//        labelPaneP.add(deleteButtonP);
//        labelPaneP.add(labelIdP);
//        labelPaneP.add(labelId1P);
//        labelPaneP.add(labelUpdateNameP);
//        labelPaneP.add(textFieldUpdateNameP);
//        labelPaneP.add(labelUpdateStockP);
//        labelPaneP.add(textFieldUpdateStockP);
//        labelPaneP.add(labelUpdatePriceP);
//        labelPaneP.add(textFieldUpdatePriceP);
//        labelPaneP.add(updateButtonP);
//
//        //-------------------------------------------------
//        // CLIENT
//        //-------------------------------------------------
//
//        labelSearchTextC.setForeground(Color.WHITE);
//        labelAddNameC.setForeground(Color.WHITE);
//        labelAddAddressC.setForeground(Color.WHITE);
//        labelAddAgeC.setForeground(Color.WHITE);
//        labelAddEmailC.setForeground(Color.WHITE);
//        labelUpdateNameC.setForeground(Color.WHITE);
//        labelUpdateAddressC.setForeground(Color.WHITE);
//        labelUpdateAgeC.setForeground(Color.WHITE);
//        labelUpdateEmailC.setForeground(Color.WHITE);
//        labelIdC.setForeground(Color.WHITE);
//        labelDeleteIdC.setForeground(Color.WHITE);
//        labelId1C.setForeground(Color.WHITE);
//
//        searchButtonC.addActionListener(e -> controller.searchButtonClickedC());
//        //-------------------------------------------------
//        // ADD
//        //-------------------------------------------------
//        addButtonC.addActionListener(e -> controller.addButtonClickedC());
//        //-------------------------------------------------
//        // DELETE
//        //-------------------------------------------------
//        deleteButtonC.addActionListener(e -> controller.deleteButtonClickedC());
//        //-------------------------------------------------
//        // UPDATE
//        //-------------------------------------------------
//        tableC.addMouseListener(new java.awt.event.MouseAdapter() {
//            @Override
//            public void mouseClicked(java.awt.event.MouseEvent evt) {
//                DefaultTableModel model = (DefaultTableModel) tableC.getModel();
//                Integer id = (Integer) model.getValueAt(tableC.getSelectedRow(), 0);
//                String name = (String) model.getValueAt(tableC.getSelectedRow(), 1);
//                String address = (String) model.getValueAt(tableC.getSelectedRow(), 2);
//                Integer age = (Integer) model.getValueAt(tableC.getSelectedRow(), 3);
//                String email = (String) model.getValueAt(tableC.getSelectedRow(), 4);
//                labelId1C.setText(String.valueOf(id));
//                textFieldUpdateNameC.setText(name);
//                labelClientIdO.setText(String.valueOf(id));
//                labelClientNameO.setText(name);
//                textFieldUpdateAddressC.setText(address);
//                textFieldUpdateAgeC.setText(String.valueOf(age));
//                textFieldUpdateEmailC.setText(email);
//            }
//        });
//
//        updateButtonC.addActionListener(e -> controller.updateButtonClickedC());
//
//        labelSearchTextC.setBounds(320, 10, 100, 20);
//        textFieldSearchTextC.setBounds(370, 10, 100, 20);
//        searchButtonC.setBounds(370, 35, 100, 20);
//
//        labelAddNameC.setBounds(320, 65, 100, 20);
//        textFieldAddNameC.setBounds(370, 65, 100, 20);
//        labelAddAddressC.setBounds(320, 90, 100, 20);
//        textFieldAddAddressC.setBounds(370, 90, 100, 20);
//        labelAddAgeC.setBounds(320, 115, 100, 20);
//        textFieldAddAgeC.setBounds(370, 115, 100, 20);
//        labelAddEmailC.setBounds(320, 140, 100, 20);
//        textFieldAddEmailC.setBounds(370, 140, 100, 20);
//        addButtonC.setBounds(370, 165, 100, 20);
//
//        labelDeleteIdC.setBounds(320, 195, 100, 20);
//        textFieldDeleteIdC.setBounds(370, 195, 100, 20);
//        deleteButtonC.setBounds(370, 220, 100, 20);
//
//        labelIdC.setBounds(320, 250, 100, 20);
//        labelId1C.setBounds(370, 250, 100, 20);
//        labelId1C.setBackground(Color.WHITE);
//        labelUpdateNameC.setBounds(320, 275, 100, 20);
//        textFieldUpdateNameC.setBounds(370, 275, 100, 20);
//        labelUpdateAddressC.setBounds(320, 300, 100, 20);
//        textFieldUpdateAddressC.setBounds(370, 300, 100, 20);
//        labelUpdateAgeC.setBounds(320, 325, 100, 20);
//        textFieldUpdateAgeC.setBounds(370, 325, 100, 20);
//        labelUpdateEmailC.setBounds(320, 350, 100, 20);
//        textFieldUpdateEmailC.setBounds(370, 350, 100, 20);
//        updateButtonC.setBounds(370, 375, 100, 20);
//
//        scrollPaneC.setBounds(10, 10, 300, 335);
//
//        JLabel labelPaneC = new JLabel();
//        labelPaneC.add(scrollPaneC);
//        labelPaneC.add(labelSearchTextC);
//        labelPaneC.add(textFieldSearchTextC);
//        labelPaneC.add(searchButtonC);
//        labelPaneC.add(labelAddNameC);
//        labelPaneC.add(textFieldAddNameC);
//        labelPaneC.add(labelAddAddressC);
//        labelPaneC.add(textFieldAddAddressC);
//        labelPaneC.add(labelAddAgeC);
//        labelPaneC.add(textFieldAddAgeC);
//        labelPaneC.add(labelAddEmailC);
//        labelPaneC.add(textFieldAddEmailC);
//        labelPaneC.add(addButtonC);
//        labelPaneC.add(labelDeleteIdC);
//        labelPaneC.add(textFieldDeleteIdC);
//        labelPaneC.add(deleteButtonC);
//        labelPaneC.add(labelIdC);
//        labelPaneC.add(labelId1C);
//        labelPaneC.add(labelUpdateNameC);
//        labelPaneC.add(textFieldUpdateNameC);
//        labelPaneC.add(labelUpdateAddressC);
//        labelPaneC.add(textFieldUpdateAddressC);
//        labelPaneC.add(labelUpdateAgeC);
//        labelPaneC.add(textFieldUpdateAgeC);
//        labelPaneC.add(labelUpdateEmailC);
//        labelPaneC.add(textFieldUpdateEmailC);
//        labelPaneC.add(updateButtonC);
//
//        //-------------------------------------------------
//        // ORDER
//        //-------------------------------------------------
//
//        labelClientO.setForeground(Color.WHITE);
//        labelClientIdO.setForeground(Color.WHITE);
//        labelClientNameO.setForeground(Color.WHITE);
//        labelProductO.setForeground(Color.WHITE);
//        labelProductIdO.setForeground(Color.WHITE);
//        labelProductNameO.setForeground(Color.WHITE);
//        labelAmountO.setForeground(Color.WHITE);
//
//        placeOrderButtonC.addActionListener(e -> controller.placeOrderButtonClickedO());
//
//        labelClientO.setBounds(10, 10, 100, 20);
//        labelClientIdO.setBounds(60, 10, 100, 20);
//        labelClientNameO.setBounds(140, 10, 100, 20);
//
//        labelProductO.setBounds(10, 40, 100, 20);
//        labelProductIdO.setBounds(60, 40, 100, 20);
//        labelProductNameO.setBounds(140, 40, 100, 20);
//
//        labelAmountO.setBounds(10, 70, 100, 20);
//        textFieldAmountO.setBounds(60, 70, 100, 20);
//
//        placeOrderButtonC.setBounds(10, 100, 150, 20);
//
//        scrollPaneO.setBounds(10, 130, 300, 100);
//
//        JLabel labelPaneO = new JLabel();
//        labelPaneO.add(scrollPaneO);
//        labelPaneO.add(labelProductO);
//        labelPaneO.add(labelProductIdO);
//        labelPaneO.add(labelProductNameO);
//        labelPaneO.add(labelClientO);
//        labelPaneO.add(labelClientIdO);
//        labelPaneO.add(labelClientNameO);
//        labelPaneO.add(labelAmountO);
//        labelPaneO.add(textFieldAmountO);
//        labelPaneO.add(placeOrderButtonC);
//
//        frameP.setContentPane(labelPaneP);
//        frameC.setContentPane(labelPaneC);
//        frameO.setContentPane(labelPaneO);
//
//    }
//
//
//    public String getSearchTextP() {
//        return textFieldSearchTextP.getText();
//    }
//    public String getAddNameP() {
//        return textFieldAddNameP.getText();
//    }
//    public double getAddPriceP() {
//        return Double.parseDouble(textFieldAddPriceP.getText());
//    }
//    public int getAddStockP() {
//        return Integer.parseInt(textFieldAddStockP.getText());
//    }
//    public String getDeleteIdP() {
//        return textFieldDeleteIdP.getText();
//    }
//    public String getIdP() { return labelId1P.getText(); }
//    public String getUpdateNameP() { return textFieldUpdateNameP.getText(); }
//    public String getUpdateStockP() { return textFieldUpdateStockP.getText(); }
//    public String getUpdatePriceP() { return textFieldUpdatePriceP.getText(); }
//    public String getUpdateIdP() { return labelId1P.getText(); }
//    public void setVisibility(boolean isVisible) { frameC.setVisible(isVisible); frameP.setVisible(isVisible); frameO.setVisible(isVisible);}
//    public void showMessage(String message, int option) {
//        if (option == 0) {
//            JOptionPane.showMessageDialog(frameC, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
//        }
//        if (option == 1) {
//            JOptionPane.showMessageDialog(frameC, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
//        }
//    }
//
//    public String getSearchTextC() {
//        return textFieldSearchTextC.getText();
//    }
//    public String getAddNameC() {
//        return textFieldAddNameC.getText();
//    }
//    public String getAddAddressC() {
//        return textFieldAddAddressC.getText();
//    }
//    public String getAddAgeC() {
//        return textFieldAddAgeC.getText();
//    }
//    public String getAddEmailC() { return textFieldAddEmailC.getText(); }
//    public String getDeleteIdC() {
//        return textFieldDeleteIdC.getText();
//    }
//    public String getUpdateNameC() { return textFieldUpdateNameC.getText(); }
//    public String getUpdateAddressC() { return textFieldUpdateAddressC.getText(); }
//    public String getUpdateAgeC() { return textFieldUpdateAgeC.getText(); }
//    public String getUpdateEmailC() { return textFieldUpdateEmailC.getText(); }
//    public String getUpdateIdC() { return labelId1C.getText(); }
//
//    public String getProductIdO() {
//        return labelProductIdO.getText();
//    }
//    public String getClientIdO() {
//        return labelClientIdO.getText();
//    }
//    public String getAmountO() {
//        return textFieldAmountO.getText();
//    }
//
//    public void displayDataOBJ(List<Object> objects, String searchText) {
//        String[] coll = Reflection.retrieveFieldNames(objects.getFirst());
//
//        DefaultTableModel model = new DefaultTableModel(coll, 0);
//        for (Object object: objects) {
//            Object[] row = Reflection.retrieveFieldValues(object);
//            model.addRow(row);
//        }
//        if(objects.getFirst().getClass().getName().equals("model.Order")) {
//            tableO.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            sorter.setRowFilter(new Product.MyRowFilter(searchText));
//            tableO.setModel(model);
//            tableO.setRowSorter(sorter);
//        }
//        else if(objects.getFirst().getClass().getName().equals("model.Product")){
//            tableP.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            sorter.setRowFilter(new Product.MyRowFilter(searchText));
//            tableP.setModel(model);
//            tableP.setRowSorter(sorter);
//        }
//        else{
//            tableC.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            sorter.setRowFilter(new Product.MyRowFilter(searchText));
//            tableC.setModel(model);
//            tableC.setRowSorter(sorter);
//        }
//    }
//    public void displayDataOBJ(List<Object> objects) {
//        String[] coll = Reflection.retrieveFieldNames(objects.getFirst());
//
//        DefaultTableModel model = new DefaultTableModel(coll, 0);
//        for (Object object: objects) {
//            Object[] row = Reflection.retrieveFieldValues(object);
//            model.addRow(row);
//        }
//        if(objects.getFirst().getClass().getName().equals("model.Order")) {
//            tableO.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            tableO.setModel(model);
//            tableO.setRowSorter(sorter);
//        }
//        else if(objects.getFirst().getClass().getName().equals("model.Product")){
//            tableP.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            tableP.setModel(model);
//            tableP.setRowSorter(sorter);
//        }
//        else{
//            tableC.setModel(model);
//            TableRowSorter sorter = new TableRowSorter(model);
//            sorter.setComparator(0, Comparator.comparingInt((Integer id) -> id).reversed());
//            tableC.setModel(model);
//            tableC.setRowSorter(sorter);
//        }
//
//    }
//
//    public void emptyUpdateFieldsP() {
//        labelId1P.setText("");
//        textFieldUpdateNameP.setText("");
//        textFieldUpdateStockP.setText("");
//        textFieldUpdatePriceP.setText("");
//    }
//    public void emptyUpdateFieldsC() {
//        labelId1C.setText("");
//        textFieldUpdateNameC.setText("");
//        textFieldUpdateAddressC.setText("");
//        textFieldUpdateAgeC.setText("");
//        textFieldUpdateEmailC.setText("");
//    }
//    public void emptyOrderFieldsO() {
//        labelClientIdO.setText("");
//        labelClientNameO.setText("");
//        labelProductIdO.setText("");
//        labelProductNameO.setText("");
//        textFieldAmountO.setText("");
//    }
//}