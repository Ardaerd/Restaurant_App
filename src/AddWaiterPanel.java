import RestaurantModel.Restaurant;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddWaiterPanel extends JPanel {
    private JLabel name;
    private JTextField enterName;
    private JButton addButton;
    private GridBagConstraints gbc;

    public AddWaiterPanel(Restaurant restaurant) {
        // Initializing the components of the add waiter panel
        name = new JLabel("Name: ");
        enterName = new JTextField();
        addButton = new JButton("Add");
        gbc = new GridBagConstraints();

        // Setting layout fot this panel
        setLayout(new GridBagLayout());

        // Setting place for the components of AddWaiterPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.weightx = 13.0;
        gbc.weighty = 13.0;

        gbc.insets = new Insets(3,115,3,115);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(name,0,0);

        gbc.ipadx = 190;
        gbc.ipady = 5;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(enterName,1,0);

        gbc.ipadx = 50;
        gbc.ipady = 2;
        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(addButton,1,2);

        addButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        restaurant.addWaiter(enterName.getText());
                        JOptionPane.showMessageDialog(null,"Waiter is added successfully");
                    }
                });
    }

    // Creating function to using GridBagLayout easily
    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp,gbc);
    }
}
