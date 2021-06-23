import RestaurantModel.Restaurant;

import javax.swing.*;
import java.awt.*;

public class CalculateExpensesPanel extends JPanel {
    private JLabel expensesLabel;
    private JLabel expenses;
    private JLabel revenueLabel;
    private JLabel revenue;
    private JLabel profitLabel;
    private JLabel profit;
    private GridBagConstraints gbc;

    public CalculateExpensesPanel(Restaurant restaurant) {
        // Initializing the components of the calculate expenses panel
        expensesLabel = new JLabel("Expenses: ");
        expenses = new JLabel();
        revenueLabel = new JLabel("Revenue: ");
        revenue = new JLabel();
        profitLabel = new JLabel("Profit: ");
        profit = new JLabel();
        gbc = new GridBagConstraints();

        // Getting data from restaurant class
        double valueOfExpenses = restaurant.calculateExpenses();
        double valueOfRevenue = restaurant.calculateRevenue();
        double valueOfProfit = valueOfRevenue-valueOfExpenses;

        // Converting data to the string
        String strExpenses = String.valueOf(valueOfExpenses) + " TL";
        String strRevenue = String.valueOf(valueOfRevenue) + " TL";
        String strProfit = String.valueOf(valueOfProfit) + " TL";

        // Setting labels' text
        expenses.setText(strExpenses);
        revenue.setText(strRevenue);
        profit.setText(strProfit);

        // Color of text according to the profit
        if (valueOfProfit > 0)
            profit.setForeground(new Color(51, 128, 3, 255));
        else
            profit.setForeground(Color.RED);

        // Setting layout
        setLayout(new GridBagLayout());

        // Setting place for the components of the addProductPanel
        gbc.gridheight = 1;
        gbc.gridwidth = 1;

        gbc.weightx = 13.0;
        gbc.weighty = 13.0;

        gbc.insets = new Insets(5,125,5,125);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(expensesLabel,0,0);

        gbc.anchor = gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(expenses,1,0);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(revenueLabel,0,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(revenue,1,1);

        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        addGB(profitLabel,0,2);

        gbc.anchor = GridBagConstraints.FIRST_LINE_END;
        addGB(profit,1,2);
    }

    // Creating method to using GridBagLayout easily
    public void addGB(Component comp, int x, int y) {
        gbc.gridx = x;
        gbc.gridy = y;
        add(comp,gbc);
    }
}
