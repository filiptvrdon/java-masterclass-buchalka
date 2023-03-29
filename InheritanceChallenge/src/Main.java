import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        SalariedEmployee joe = new SalariedEmployee("Joe", "11/11/1990", "03/03/2020", 35000, false);
        System.out.println(joe);
        System.out.println("Joe's Paycheck = $ " + joe.collectPay());

        joe.retire();
        System.out.println("Joe's Paycheck = $ " + joe.collectPay());

        HourlyEmployee mary = new HourlyEmployee("Mary", "05/05/1970" , "03/03/2021", 15);

        System.out.println(mary);
        System.out.println("Mary's Paycheck is $ " + mary.collectPay());
        System.out.println("Mary's holiday Pay is $ " + mary.getDoublePay());
    }



}