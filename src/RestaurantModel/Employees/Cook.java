package RestaurantModel.Employees;

import RestaurantModel.Employees.Employee;

public class Cook extends Employee {
    private double salary;
    private double taxRate;

    public Cook(int id, String name, double salary) {
        super(id, name);
        this.salary = salary;
        taxRate = 0.18;
    }

    @Override
    public double calculateExpense() {
        return salary + (salary*taxRate);
    }

    public double getSalary() {
        return salary;
    }

    public double getTaxRate() {
        return taxRate;
    }
}
