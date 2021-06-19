package RestaurantModel;

import RestaurantModel.Employees.Cook;
import RestaurantModel.Employees.Employee;
import RestaurantModel.Employees.Orders.Products.*;
import RestaurantModel.Employees.Waiter;

import java.util.ArrayList;

public class Restaurant {
    private ArrayList<Employee> employees = new ArrayList<>();
    private ArrayList<Product> products = new ArrayList<>();

    public Restaurant() {
        initEmployees();
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
}
