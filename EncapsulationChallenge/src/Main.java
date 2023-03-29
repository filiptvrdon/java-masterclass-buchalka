public class Main {
    public static void main(String[] args) {

        Printer printer1 = new Printer();
        System.out.println("------------------ PRINTER 1 ------------------");
        printer1.addToner(95);
        printer1.printPages(100);


        Printer printer2 = new Printer(0,0,true);
        System.out.println("------------------ PRINTER 2 ------------------");
        printer2.addToner(100);
        printer2.printPages(    11);

    }
}
