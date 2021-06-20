import RestaurantModel.Employees.Orders.Products.Product;
import RestaurantModel.Restaurant;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class RestaurantGUI extends JPanel {
    private static JPanel orderPanel;
    private static JPanel createOrderPanel;
    private JPanel addProductPanel;
    private JPanel currentOrderPanel;
    private JPanel restaurantPanel;
    private JTabbedPane tabPanel;
    private JButton newOrder;
    private Restaurant restaurant;
    private GridBagConstraints gbc = new GridBagConstraints();

    public RestaurantGUI(int size) {
        // Initializing components
        orderPanel = new JPanel();
        createOrderPanel = new JPanel();
        restaurantPanel = new JPanel();
        tabPanel = new JTabbedPane();
        tabPanel.setPreferredSize(new Dimension(size-20,size-40));
        restaurant = new Restaurant();

        add(tabPanel);

        // OrderPanel
        newOrder = new JButton("New Order");

        newOrder.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource() instanceof JButton) {
                            JButton button = (JButton) e.getSource();
                            orderPanel.remove(newOrder);
                            orderPanel.add(createOrderPanel);
                        }
                        String str = "Hi, I am " + restaurant.assignWaiter().getName() + ".\n" +
                                "What would you like to order?";
                        JOptionPane.showMessageDialog(null,str);
                    }
                });
        orderPanel.add(newOrder);

        // Create new Order
        createOrderPanel.setLayout(new BorderLayout());

        addProductPanel = new JPanel();
        currentOrderPanel = new JPanel();

        addProductPanel.setBorder(new TitledBorder("Add Product"));
        currentOrderPanel.setBorder(new TitledBorder("Current Orders"));

//        addProductPanel.setSize(200,200);
        addProductPanel.setPreferredSize(new Dimension(size-50,(size/2)-150));
        addProductPanel.setMaximumSize(new Dimension(size-50,(size/2)-150));
        currentOrderPanel.setPreferredSize(new Dimension(size-50,size/2 + 50));
        

        JLabel productLabel = new JLabel("Product:");
        JLabel countLabel = new JLabel("Count:");
        JLabel priceLabel = new JLabel("Price:");
        JComboBox selectProduct = new JComboBox();
        JSpinner spinner = new JSpinner(new SpinnerNumberModel(0,0,100,1));
        JButton add = new JButton("Add");

        selectProduct.setSize(50,50);

        for (Product product : restaurant.getProducts()) {
            selectProduct.addItem(product);
        }

        JLabel perProductPrice = new JLabel(String.valueOf(((Product) selectProduct.getSelectedItem()).getSellingPrice()) + " TL");

        selectProduct.addItemListener(
                new ItemListener() {

                    @Override
                    public void itemStateChanged(ItemEvent e) {
                        if (e.getStateChange() == ItemEvent.SELECTED) {
                            Product product = (Product) e.getItem();
                            perProductPrice.setText(product.getSellingPrice() + " TL");
                        }
                    }
                });

        addProductPanel.setLayout(new GridBagLayout());
//
////
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.weightx = 13.0;
        gbc.weighty = 13.0;
//        gbc.fill = GridBagConstraints.HORIZONTAL;
//

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
        gbc.ipadx = 100;
        addGB(add,1,8);


        
        createOrderPanel.add(addProductPanel, BorderLayout.NORTH);
        createOrderPanel.add(currentOrderPanel, BorderLayout.SOUTH);

        // Add panels to the tabPanel
        tabPanel.addTab("Order",orderPanel);
        tabPanel.addTab("Restaurant",restaurantPanel);

    }

    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        addProductPanel.add(comp,gbc);
    }
}
