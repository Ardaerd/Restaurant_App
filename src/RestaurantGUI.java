
import RestaurantModel.Employees.Waiter;
import RestaurantModel.Restaurant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantGUI extends JPanel {
    public static JPanel orderPanel;  //  panel which have a new order button
    private RestaurantPanel restaurantPanel;
    private JTabbedPane tabPanel;
    public static JButton newOrder;
    private Restaurant restaurant;
    public static Waiter waiter;
    public static CreateOrderPanel createOrderPanel;


    public RestaurantGUI() {
        // Initializing components
        orderPanel = new JPanel();
        tabPanel = new JTabbedPane();
        tabPanel.setPreferredSize(new Dimension(main.WIDTH-20,main.HEIGHT-50));
        restaurant = new Restaurant();
        restaurantPanel = new RestaurantPanel(restaurant);

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
                            createOrderPanel = new CreateOrderPanel(restaurant);
                            orderPanel.add(createOrderPanel);
                            orderPanel.repaint();
                            orderPanel.revalidate();
                        }
                        waiter = restaurant.assignWaiter();
                        String str = "Hi, I am " + restaurant.assignWaiter().getName() + ".\n" +
                                "What would you like to order?";
                        JOptionPane.showMessageDialog(null,str);
                    }
                });
        orderPanel.add(newOrder);

        // Add panels to the tabPanel
        tabPanel.addTab("Order",orderPanel);
        tabPanel.addTab("Restaurant",restaurantPanel);

    }
}
