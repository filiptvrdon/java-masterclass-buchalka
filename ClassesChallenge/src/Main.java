public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Customer customer = new Customer("Filip", "tvrdon.filip@gmail.com", 1000.00);
        System.out.println(customer.getName());
        System.out.println(customer.getEmail());
        System.out.println(customer.getCreditLimit());

        Customer secondCustomer = new Customer("Filip", "tvrdon.filip@gmail.com");
        System.out.println(secondCustomer.getName());
        System.out.println(secondCustomer.getEmail());
        System.out.println(secondCustomer.getCreditLimit());

        Customer thirdCustomer = new Customer();
        System.out.println(thirdCustomer.getName());
        System.out.println(thirdCustomer.getEmail());
        System.out.println(thirdCustomer.getCreditLimit());

    }
}
