
import RestaurantModel.Employees.Waiter;
import RestaurantModel.Restaurant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantGUI extends JPanel {
    public static JPanel orderPanel;
    private JPanel restaurantPanel;
    private JTabbedPane tabPanel;
    public static JButton newOrder;
    private Restaurant restaurant;
    public static Waiter waiter;
    public static CreateOrderPanel createOrderPanel;


    public RestaurantGUI() {
        // Initializing components
        orderPanel = new JPanel();
        restaurantPanel = new JPanel();
        tabPanel = new JTabbedPane();
        tabPanel.setPreferredSize(new Dimension(main.SIZE-20,main.SIZE-40));
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
