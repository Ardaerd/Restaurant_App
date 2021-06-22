
import RestaurantModel.Restaurant;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestaurantPanel extends JPanel {
    private JButton listEmployeeButton;
    private JButton addCookButton;
    private JButton addWaiterButton;
    private JButton calculateExpensesButton;
    private JPanel buttonPanel;  // only cover the buttons
    private JPanel actionPanel;  // panel which have buttons action
    private ListEmployeePanel listEmployeePanel;     // panel for listEmployee button
    private AddCookPanel addCookPanel;              // panel for adding cook
    private boolean clickedListButton;             // if list employeeButton is clicked, it is true
    private boolean clickedAddCook;               // if add cook button is clicked, it is true
    private boolean clickedAddWaiter;            // if add waiter button is clicked, it is true
    private boolean clickedCalculateExpense;    // if calculate expense button is clicked, it is true


    public RestaurantPanel(Restaurant restaurant) {
        // Initializing click statement
        clickedListButton = false;
        clickedAddCook = false;

        // Setting layout for RestaurantPanel
        setLayout(new BorderLayout());

        // Initializing the panels
        buttonPanel = new JPanel();
        actionPanel = new JPanel();

        // Initializing the buttons
        listEmployeeButton = new JButton("List Employees");
        addCookButton = new JButton("Add Cook");
        addWaiterButton = new JButton("Add Waiter");
        calculateExpensesButton = new JButton("Calculate Expenses");

        // Adding actionListener to the buttons which in the buttonPanel
        listEmployeeButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // remove panel according to which one is clicked before this button
                        if(clickedListButton)
                            actionPanel.remove(listEmployeePanel);
                        else if (clickedAddCook)
                            actionPanel.remove(addCookPanel);

                        listEmployeePanel = new ListEmployeePanel(restaurant);
                        actionPanel.add(listEmployeePanel);
                        actionPanel.repaint();
                        actionPanel.revalidate();

                        // ClickedListButton is true and others are false
                        clickedListButton = true;
                        clickedAddCook = false;
                    }
                });

        addCookButton.addActionListener(
                new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // remove panel according to which one is clicked before this button
                        if(clickedListButton)
                            actionPanel.remove(listEmployeePanel);
                        else if (clickedAddCook)
                            actionPanel.remove(addCookPanel);

                        addCookPanel = new AddCookPanel(restaurant);
                        actionPanel.add(addCookPanel);
                        actionPanel.repaint();
                        actionPanel.revalidate();

                        // ClickedAddCook is true and others are false
                        clickedListButton = false;
                        clickedAddCook = true;
                    }
                });


        // Adding these buttons to the buttonPanel
        buttonPanel.add(listEmployeeButton);
        buttonPanel.add(addCookButton);
        buttonPanel.add(addWaiterButton);
        buttonPanel.add(calculateExpensesButton);

        // Adding panels to the RestaurantPanel
        add(buttonPanel, BorderLayout.NORTH);
        add(actionPanel, BorderLayout.CENTER);
    }
}
