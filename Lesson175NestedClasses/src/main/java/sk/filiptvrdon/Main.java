package sk.filiptvrdon;

import sk.filiptvrdon.domain.Employee;
import sk.filiptvrdon.domain.StoreEmployee;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1001, "Ralph", 2015));
        employees.add(new Employee(1002, "Carole", 2021));
        employees.add(new Employee(1003, "Jane", 2013));
        employees.add(new Employee(1004, "Laure", 2020));
        employees.add(new Employee(1005, "Jim", 2018));


        employees.forEach(System.out::println);
        System.out.println("------------------------------------------------");


//        var comparator = new EmployeeComparator<>();
//        employees.sort(comparator);

        employees.sort(new Employee.EmployeeComparator<>());


        employees.forEach(System.out::println);
        System.out.println("------------------------------------------------");

        System.out.println("Print Store Employees");
        System.out.println("------------------------------------------------");

        List<StoreEmployee> storeEmployees = new ArrayList<>();
        storeEmployees.add(new StoreEmployee(1006, "Meg", 2019, "Target"));
        storeEmployees.add(new StoreEmployee(1007, "Joe", 2021, "Walmart"));
        storeEmployees.add(new StoreEmployee(1008, "Tom", 2020, "Macy's"));
        storeEmployees.add(new StoreEmployee(1009, "Marty", 2018, "Walmart"));
        storeEmployees.add(new StoreEmployee(1010, "Bud", 2016, "Target"));

        storeEmployees.forEach(System.out::println);
        System.out.println("------------------------------------------------");


        StoreEmployee genericEmployee = new StoreEmployee();
        var comparator = genericEmployee.new StoreComparator<>();
        storeEmployees.sort(comparator);
        
        storeEmployees.forEach(System.out::println);
        System.out.println("------------------------------------------------");

    }
}