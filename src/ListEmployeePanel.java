import RestaurantModel.Employees.Cook;
import RestaurantModel.Employees.Employee;
import RestaurantModel.Employees.Waiter;
import RestaurantModel.Restaurant;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class ListEmployeePanel extends JPanel {
    private JTable employeesTable; // For listing employees
    private JScrollPane sp;


    public ListEmployeePanel(Restaurant restaurant) {
        // Column names for listEmployees (JTable)
        String[] columnNames = {"ID", "Name", "Job"};
        DefaultTableModel tableModel = new DefaultTableModel(columnNames,0);
        employeesTable = new JTable();

        for (int i = 0; i < restaurant.getEmployees().size(); i++) {
            Employee employee = restaurant.getEmployees().get(i);

            if (employee instanceof Waiter) {
                String name = employee.getName();
                int id = employee.getId();
                String jobTitle = employee.getClass().getSimpleName();
                String strId = String.format("%s", id);

                // String array for the employee's information
                String[] str = {strId, name, jobTitle};

                // Add these information to the orderTable
                tableModel.addRow(str);
            } else if (employee instanceof Cook) {
                String name = employee.getName();
                int id = employee.getId();
                String jobTitle = employee.getClass().getSimpleName();
                String strId = String.format("%s", id);

                // String array for the employee's information
                String[] str = {strId, name, jobTitle};

                // Add these information to the orderTable
                tableModel.addRow(str);

                employeesTable.setModel(tableModel);
                sp = new JScrollPane(employeesTable);

                add(sp);
            }
        }
    }
}
