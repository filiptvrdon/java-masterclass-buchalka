public abstract class Employee extends Worker {
    private long employeeId;
    private String hireDate = new String();

    private static int employeeNo = 1;

    public Employee(String name, String birthDate, String endDate) {
        super(name, birthDate, endDate);
        this.employeeId = Employee.employeeNo++;
        this.hireDate = hireDate;
    }
}
