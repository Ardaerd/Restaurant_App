package RestaurantModel.Employees;

import RestaurantModel.Employees.Orders.Order;

import java.util.ArrayList;

public class Waiter extends Employee {
    private double orderRate;
    private ArrayList<Order> ordersReceived;

    public Waiter(int id, String name) {
        super(id, name);
        ordersReceived = new ArrayList<Order>();
        orderRate = 0.10;
    }

    public void createOrder(Order order) {
        ordersReceived.add(order);
    }

    @Override
    public double calculateExpense() {
        double expense = 0.0;

        for (Order order : ordersReceived) {
            expense += (order.calculateTotalPrice() * 0.1);
        }

        return expense;
    }

    public ArrayList<Order> getOrdersReceived() {
        return ordersReceived;
    }
}
