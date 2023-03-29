public class Main {
    public static void main(String[] args) {
       /* String helloWorld = "Hello" + " World";
        helloWorld.concat(" and Goodbye");
        printInformation(helloWorld);
        */

        StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
        helloWorldBuilder.append(" and Goodbye");
        // printInformation(helloWorldBuilder);


        StringBuilder emptyStart = new StringBuilder();
        emptyStart.append("a".repeat(57));
        StringBuilder emptyStart32 = new StringBuilder(32);
        emptyStart32.append("a".repeat(17));

        System.out.println(emptyStart);
        System.out.println(emptyStart32);

        printInformation(emptyStart);
        printInformation(emptyStart32);



        StringBuilder builderPlus = new StringBuilder("Hello" + " World");
        builderPlus.append(" and Goodbye");
        builderPlus.deleteCharAt(16).insert(16,"g");
        System.out.println(builderPlus);

        builderPlus.replace(16,17,"G");
        System.out.println(builderPlus);

        builderPlus.reverse().setLength(7);
        System.out.println(builderPlus  );

    }


    public static void printInformation(String string) {
        System.out.println("String = " + string);
        System.out.println("Length = " + string.length());

    }

    public static void printInformation(StringBuilder builder) {
        System.out.println("String = " + builder);
        System.out.println("Length = " + builder.length());
        System.out.println("Capacity = " + builder.capacity());

    }
}
