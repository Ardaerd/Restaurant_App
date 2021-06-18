package RestaurantModel.Employees.Orders;

import RestaurantModel.Employees.Orders.Products.Product;

import java.util.ArrayList;

public class Order {
    private ArrayList<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void listOrder() {
        if (products.size() == 0) {
            System.out.println("You have not ordered anything yet!");
        } else {
            for (Product product : products) {
                System.out.println(product.getName() + ": " + product.getSellingPrice());
            }
        }
    }

    public double calculateTotalPrice() {
        double totalPrice = 0.0;

        for (Product product : products) {
            totalPrice += product.getSellingPrice();
        }

        return totalPrice;
    }

    public ArrayList<Product> getOrderedProducts() {
        return products;
    }
}
