package RestaurantModel.Employees.Orders.Products;

import java.util.ArrayList;
import java.util.function.Predicate;

public class MenuProduct extends Product {
    private ArrayList<Product> products;

    public MenuProduct(String name, ArrayList<Product> products) {
        super(name);
        this.products = products;
        setSellingPrice(calculateSellingPrice());
    }

    @Override
    public double calculateExpense() {
        double expenses = 0.0;
        
        for (Product product : products) {
            expenses += product.calculateExpense();
        }

        return expenses;
    }

    // Calculates the sum of individual products with discount prices
    private double calculateSellingPrice() {
        double sellingPrice = 0.0;

        for (Product product : products) {
            if (product instanceof Beverage) 
                sellingPrice += product.getSellingPrice() * 0.5;
            else if (product instanceof Dessert)
                sellingPrice += product.getSellingPrice() * 0.8;
            else if (product instanceof MainDish)
                sellingPrice += product.getSellingPrice() * 0.9;
        }
        
        return sellingPrice;
    }
}
