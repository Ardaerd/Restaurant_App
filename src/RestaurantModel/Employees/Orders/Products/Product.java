package RestaurantModel.Employees.Orders.Products;

import RestaurantModel.Expense;

public abstract class Product implements Expense {
    private String name;
    private double purchasePrice;
    private double sellingPrice;
    private double utilityCost;

    public Product(String name, double purchasePrice, double sellingPrice, double utilityCost) {
        this.name = name;
        this.purchasePrice = purchasePrice;
        this.sellingPrice = sellingPrice;
        this.utilityCost = utilityCost;
    }

    public Product(String name) {
        this(name,0.0,0.0,0.0);
    }

    @Override
    public String toString() {
        return "Name:'" + name + "\n" +
                "Purchase Price: " + purchasePrice + "\n" +
                "Selling Price: " + sellingPrice + "\n" +
                "Utility Cost: " + utilityCost + "\n";
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public void setSellingPrice(double sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public void setUtilityCost(double utilityCost) {
        this.utilityCost = utilityCost;
    }

    public String getName() {
        return name;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public double getSellingPrice() {
        return sellingPrice;
    }

    public double getUtilityCost() {
        return utilityCost;
    }
}
