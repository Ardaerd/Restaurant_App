package RestaurantModel;

import RestaurantModel.Employees.Cook;
import RestaurantModel.Employees.Employee;
import RestaurantModel.Employees.Orders.Order;
import RestaurantModel.Employees.Orders.Products.*;
import RestaurantModel.Employees.Waiter;

import java.util.ArrayList;
import java.util.Random;

public class Restaurant {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public Restaurant() {
        initEmployees();
        initProducts();
    }

    public double calculateRevenue() {
        double revenue = 0;

        for (Employee employee : employees) {
            if (employee instanceof Waiter) {
                for(Order order : ((Waiter) employee).getOrdersReceived()) {
                    revenue += order.calculateTotalPrice();
                }
            }
        }

        return revenue;
    }

    public double calculateExpenses() {
        double employeeExpenses = 0;
        double orderExpenses = 0;

        for (Employee employee : employees) {
            employeeExpenses += employee.calculateExpense();

            if (employee instanceof Waiter) {
                for (Order order : ((Waiter) employee).getOrdersReceived()) {
                    for (Product product : order.getOrderedProducts()) {
                        orderExpenses += product.calculateExpense();
                    }
                }
            }
        }

        System.out.println("Employee Expenses: " + employeeExpenses);
        System.out.println("Order Expenses: " + orderExpenses);

        return employeeExpenses + orderExpenses;
    }

    public Waiter assignWaiter() {
        Random random = new Random();

        while (true) {
            Employee employee = employees.get(random.nextInt(employees.size()));
            if (employee instanceof Waiter)
                return (Waiter) employee;
        }
    }

    public void listEmployees() {
        for (Employee employee : employees) {
            System.out.println("Employee " + employee.getId() + ": " + employee.getName());
        }
    }

    public void addWaiter(String name) {
        employees.add(new Waiter(employees.size()+1, name));
    }

    public void addCook(String name, double salary) {
        employees.add(new Cook(employees.size()+1, name, salary));
    }

    public void initEmployees() {
        addCook("Monica",100);

        addWaiter("Ross");
        addWaiter("Phobe");
        addWaiter("Rachel");
    }

    public void initProducts() {
        // Parameters for Product Constructor:
        // Product Name, Selling Price, Purchase Price and Utility Cost
        products.add(new MainDish("Pizza",2,6,2));
        products.add(new MainDish("Burger",1.5,5,2));

        products.add(new Beverage("Coke",0.5,2));
        products.add(new Beverage("Lemonade",0.3,2));

        products.add(new Dessert("Tiramusu",1,4,1));
        products.add(new Dessert("Cake",0.5,3,1));
        products.add(new Dessert("Ice Cream",0.5,3,0.5));

        ArrayList<Product> HgProducts = new ArrayList<>();
        HgProducts.add(new MainDish("Pizza",2,6,2));
        HgProducts.add(new Beverage("Coke",0.5,2));
        HgProducts.add(new Dessert("Tiramusu",1,4,1));
        products.add(new MenuProduct("Hunger Games Menu",HgProducts));

        ArrayList<Product> KidsProducts = new ArrayList<>();
        KidsProducts.add(new MainDish("Burger",1.5,5,2));
        KidsProducts.add(new Beverage("Lemonade",0.3,2));
        KidsProducts.add(new Dessert("Ice Cream",0.5,3,0.5));
        products.add(new MenuProduct("Kids Menu",KidsProducts));
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }
}
