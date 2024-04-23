package sk.filiptvrdon.domain;

import java.util.Comparator;

public class Employee {
    private int employeeId;
    private String name;
    private int yearStarted;

    public Employee() {
    }

    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "%d %-8s %d".formatted(employeeId, name, yearStarted);
    }


    // Static nested class
    public static class EmployeeComparator<T extends Employee> implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
//            return o1.getName().compareTo(o2.getName());
//            return o1.name.compareTo(o2.name);
            return o1.yearStarted - o2.yearStarted;
        }
    }

}
