public class Customer {
    String name;
    String email;
    double creditLimit;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public Customer(String name, String email, double creditLimit) {
        this.name = name;
        this.email = email;
        this.creditLimit = creditLimit;
    }

    public Customer(String name, String email) {
        this(name, email, 1000.00);
    }

    public Customer() {
        this("nobody", "nobody@nowhere.com");
    }
}