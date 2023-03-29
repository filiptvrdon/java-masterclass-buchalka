public class StringMethods {
    public static void main(String[] args) {
        String birthDate = "25/11/1982";
        int startingIndex = birthDate.indexOf("1982");
        System.out.println("Starting index = " + startingIndex);
        System.out.println("Birth year = " + birthDate.substring(startingIndex));
        System.out.println("Birth month = " + birthDate.substring(3,5));



        String newDate = String.join("/", "25", "11", "1982");
        System.out.println(newDate);

        System.out.println(newDate.replace("/", "-"));
        System.out.println(newDate.replace("2", "000"));

        System.out.println("abc\n".repeat(3));
        System.out.println("-".repeat(20));

        System.out.println("abc\n".repeat(3).indent(8));
        System.out.println("-".repeat(20));

        System.out.println("    abc\n".repeat(3).indent(-2));
        System.out.println("-".repeat(20));
    }
}
