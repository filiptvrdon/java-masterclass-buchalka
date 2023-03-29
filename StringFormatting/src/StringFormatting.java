public class StringFormatting {

    public static void main(String[] args){
        String bulletIt = "Print a bulleted List:\n" +
                "\t\u2022 First point\n" +
                "\t\t\u2022 Sub point";
        System.out.println(bulletIt);

        String textBlock = """
                Print a bulleted List:
                \u2022 First Point
                    \u2022 Sub Point
                
                """;
        System.out.println(textBlock);

        int age = 35;
        System.out.printf("Your age is %d%n", age);

        int yearOfBirth = 2023 - age;
        System.out.printf("Age = %d, Birth year = %d%n", age, yearOfBirth);

        for (int i = 1; i <= 10000; i*=10){
            System.out.printf("Printing %6d %n",i);
        }

        String formattedString = String.format("Your age is %d", age);
        System.out.println(formattedString);

        formattedString = "Your age is %d".formatted(age);
        System.out.println(formattedString);

        printInformation("Hello World!");
        printInformation("");
        printInformation("\t \n");

        String helloWorld = "Hello World";
        System.out.printf("index of r = %d %n", helloWorld.indexOf("r"));
        System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));
        System.out.printf("index of l = %d %n", helloWorld.indexOf("l"));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf("l"));
        System.out.printf("index of l = %d %n", helloWorld.indexOf("l",3));
        System.out.printf("index of l = %d %n", helloWorld.lastIndexOf("l",8));



        String helloWorldLower = helloWorld.toLowerCase();
        if (helloWorld.equals(helloWorldLower)){
            System.out.println("values match exactly");
        }

        if (helloWorld.equalsIgnoreCase(helloWorldLower)){
            System.out.println("values match ignoring case");
        }

        if (helloWorld.startsWith("Hello")){
            System.out.println("string starts with 'Hello'");
        }

        if (helloWorld.endsWith("World")){
            System.out.println("string ends with 'World'");
        }

        if (helloWorld.contains("Hello")){
            System.out.println("string contains 'Hello'");
        }

        if (helloWorld.contentEquals("Hello World")){
            System.out.println("values' contents match exactly");
        }

        if (helloWorld.contentEquals("hello world")){
            System.out.println("values match ignoring case");
        }


    }




    public static void printInformation (String string){
        if (string.isEmpty()){
            System.out.println("String is empty");
            return;
        }

        if (string.isBlank()){
            System.out.println("String is blank");
        }


        int length = string.length();

        System.out.printf("Length = %d %n", length);
        System.out.printf("First char = %c %n", string.charAt(0));
        System.out.printf("Last char = %c %n", string.charAt(length - 1));



    }
}


