public class Main {
    public static void main(String... args) {
        System.out.println("Hello world!");

        String[] splitStrings = "Hello Wolrd again".split(" ");
        printText(splitStrings);

        System.out.println("--------------------------------");
        printText("Hello!");

        System.out.println("--------------------------------");
        printText("Hello!", "World", "again");

        System.out.println("--------------------------------");
        printText();
    }
    private static void printText (String... textList){
        for (String t : textList){
            System.out.println(t);
        }
    }
}