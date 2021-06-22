package RestaurantModel.Employees;

import RestaurantModel.Expense;

public abstract class Employee implements Expense {
    private int id;
    private String name;

    public Employee(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\n" +
                "ID: " + id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
