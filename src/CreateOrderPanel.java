import RestaurantModel.Employees.Orders.Order;
import RestaurantModel.Employees.Orders.Products.Product;
import RestaurantModel.Restaurant;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class CreateOrderPanel extends JPanel {
    private JPanel addProductPanel;
    private JPanel currentOrderPanel;
    private JLabel productLabel;
    private JLabel countLabel;
    private JLabel priceLabel;
    private JComboBox<Product> selectProduct;
    private JSpinner spinner;
    private JButton addButton;
    private JLabel perProductPrice;
    private GridBagConstraints gbc = new GridBagConstraints();
    private JTable orderTable;
    private Order order;
    private JScrollPane sp;

    public CreateOrderPanel(Restaurant restaurant) {
        // set Layout for this main panel
        setLayout(new BorderLayout());

        // Initializing the sub panels of the CreateOrderPanel
        addProductPanel = new JPanel();
        currentOrderPanel = new JPanel();

        // Setting titledBorder for sub panels
        addProductPanel.setBorder(new TitledBorder("Add Product"));
        currentOrderPanel.setBorder(new TitledBorder("Current Orders"));

        // Setting size of sub-Panels
        addProductPanel.setPreferredSize(new Dimension(main.WIDTH-50,(main.HEIGHT/2)-120));
        currentOrderPanel.setPreferredSize(new Dimension(main.WIDTH-50,(main.HEIGHT/2)));

        // Adding components to the Product Panel
        productLabel = new JLabel("Product:");
        countLabel = new JLabel("Count:");
        priceLabel = new JLabel("Price:");
        selectProduct = new JComboBox<>();
        spinner = new JSpinner(new SpinnerNumberModel(1,1,100,1));
        perProductPrice = new JLabel();
        addButton = new JButton("Add");

        // Adding products to the selectProduct (JComboBox)
        for (Product product : restaurant.getProducts()) {
            selectProduct.addItem(product);
        }

        // Converting selected price to the String format
        String strPrice = String.format("%s TL",((Product) selectProduct.getSelectedItem()).getSellingPrice());
        perProductPrice.setText(strPrice);

        // Adding itemListener to setText for perProductPrice
        selectProduct.addItemListener(
                new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            Product product = (Product) e.getItem();
                            perProductPrice.setText(product.getSellingPrice() + " TL");
                        }
                    }
                }
        );

        // Setting product panel layout
        addProductPanel.setLayout(new GridBagLayout());

        // Setting place for the components of the addProductPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.weightx = 13.0;
        gbc.weighty = 13.0;

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(productLabel,0,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.ipadx = 90;
        addGB(selectProduct,1,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(countLabel,0,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.ipady = 7;
        gbc.ipadx = 30;
        addGB(spinner,1,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(priceLabel,0,2);

        gbc.ipadx = 0;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(perProductPrice,1,2);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.ipadx = 180;
        gbc.ipady =3;
        addGB(addButton,1,8);

        // Setting currentOrderPanel's layout
        currentOrderPanel.setLayout(new BorderLayout());

        // Column names for JTable
        String[] columnNames = {"Product Name", "Count", "Price"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);

        orderTable = new JTable();

        // Creating initial order
        order = new Order();

        // ActionListener for the add button
        addButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String productName = ((Product) selectProduct.getSelectedItem()).getName();
                        int count = (Integer) spinner.getValue();
                        double price = ((Product) selectProduct.getSelectedItem()).getSellingPrice()*count;
                        String strPrice = String.format("%s",price);
                        String strCount = String.format("%s",count);

                        // String array for the product's information
                        String[] str = {productName,strCount,strPrice};

                        // Add these information to the orderTable
                        tableModel.addRow(str);

                        // When you click add button, product is added to the order
                        for (int i = 0; i < count; i++)
                            order.addProduct((Product) selectProduct.getSelectedItem());
                    }
                });

        // set the orderTable model by using tableModel
        orderTable.setModel(tableModel);

        // add orderTable to the sp (JScrollPane)
        sp = new JScrollPane(orderTable);

        // add sp to the center of the currentOrderPanel
        currentOrderPanel.add(sp,BorderLayout.CENTER);

        // Creating finalize button
        JButton finalize = new JButton("Finalize");

        // For resize the finalize button
        JPanel finalizePanel = new JPanel();

        // setLayout for the finalize panel
        finalizePanel.setLayout(new GridBagLayout());

        gbc.insets = new Insets(7,0,0,0);
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        gbc.ipadx = 20;
        gbc.ipady = 1;
        finalizePanel.add(finalize,gbc);

        // Adding actionListener to create an order when you clicked finalize button
        // And return the orderPanel
        finalize.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        RestaurantGUI.waiter.createOrder(order);
                        String str = "Your order is completed.\n" +
                                "Total price is " + order.calculateTotalPrice() + " TL";
                        JOptionPane.showMessageDialog(null,str);
                        RestaurantGUI.orderPanel.remove(RestaurantGUI.createOrderPanel);
                        RestaurantGUI.orderPanel.add(RestaurantGUI.newOrder);
                        RestaurantGUI.orderPanel.repaint();
                        RestaurantGUI.orderPanel.revalidate();                    }
                });

        // Add panels to the this panel
        add(addProductPanel, BorderLayout.NORTH);
        add(currentOrderPanel, BorderLayout.CENTER);
        add(finalizePanel, BorderLayout.SOUTH);
    }

    // Creating method to using GridBagLayout easily
    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        addProductPanel.add(comp,gbc);
    }
}
