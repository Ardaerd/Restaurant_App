import RestaurantModel.Restaurant;

import javax.swing.*;

public class AddWaiterPanel extends JPanel {
    private JLabel name;
    private JTextField enterName;
    private JButton addButton;

    public AddWaiterPanel(Restaurant restaurant) {
        // Initializing the components of the add waiter panel
        name = new JLabel("Name");
        enterName = new JTextField();
        addButton = new JButton("Add");
    }
}
