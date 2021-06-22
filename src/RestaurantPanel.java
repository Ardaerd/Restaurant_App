import RestaurantModel.Employees.Cook;
import RestaurantModel.Employees.Employee;
import RestaurantModel.Employees.Waiter;
import RestaurantModel.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
    private ListEmployeePanel listEmployeePanel;  // panel for listEmployee button
    private boolean listEmployeeClicked;          // if list employeeButton is clicked, it is true


    public RestaurantPanel(Restaurant restaurant) {
        // Initializing click statement
        listEmployeeClicked = false;

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
                        if(listEmployeeClicked) {
                            actionPanel.remove(listEmployeePanel);
                        }
                        listEmployeePanel = new ListEmployeePanel(restaurant);
                        actionPanel.add(listEmployeePanel);
                        actionPanel.repaint();
                        actionPanel.revalidate();
                        listEmployeeClicked = true;
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
