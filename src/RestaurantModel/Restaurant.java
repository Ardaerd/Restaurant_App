package RestaurantModel;

import RestaurantModel.Employees.Cook;
import RestaurantModel.Employees.Employee;
import RestaurantModel.Employees.Orders.Products.Product;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public Restaurant() {

    }

    public void addCook(String name, double salary) {
        employees.add(new Cook(employees.size()+1, name, salary));
    }

    public void initEmployees() {

    }
}
