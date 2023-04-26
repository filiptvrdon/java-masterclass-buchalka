import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        String challenge1 = "I want a bike.";
        String challenge2 = "I want a bike.";

        String regexp = "\\w\\s\\w{4}\\s\\w\\s\\w{4}\\.";
        System.out.println(challenge1.matches(regexp));
        System.out.println(challenge2.matches(regexp));

        Pattern pattern = Pattern.compile(regexp);

        Matcher matcher = pattern.matcher(challenge1);
        System.out.println(matcher.matches());

        matcher = pattern.matcher(challenge2);
        System.out.println(matcher.matches());


        String challenge3 = "Replace all blanks with underscores.";
        System.out.println(challenge3.replaceAll("\\s", "_"));

        String challenge4 = "aaabccccccccdddefffg";
        System.out.println(challenge4.matches("[a-g]+"));
        System.out.println(challenge4.matches("^a{3}bc{8}d{3}ef{3}g$"));

        String challenge5 = "abcd.135";
        System.out.println(challenge5.matches("^[A-z][a-z]+\\.\\d+$"));
        System.out.println("kjil.22".matches("^[A-z][a-z]+\\.\\d+$"));
        System.out.println("kji222.22aaa".matches("^[A-z][a-z]+\\.\\d+$"));

        String challenge6 = "abcd.135uvqz.7tzik.999";
        Pattern challenge6Pattern = Pattern.compile("[A-z]+\\.(\\d+)");
        Matcher challenge6Matcher = challenge6Pattern.matcher(challenge6);

        while (challenge6Matcher.find()) {
            System.out.println("Occurrence: " + challenge6Matcher.group(1));
        }

        String challenge7 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern challenge7Pattern = Pattern.compile("[A-z]+\\.(\\d+)\\s");
        Matcher challenge7Matcher = challenge7Pattern.matcher(challenge7);

        while (challenge7Matcher.find()) {
            System.out.println("Occurrence: " + challenge7Matcher.group(0));
        }

        String challenge8 = "abcd.135\tuvqz.7\ttzik.999\n";
        Pattern challenge8Pattern = Pattern.compile("[A-z]+\\.(\\d+)\\s");
        Matcher challenge8Matcher = challenge8Pattern.matcher(challenge8);

        while (challenge8Matcher.find()) {
            System.out.println("Occurrence: start = " + challenge8Matcher.start(1) + " end = " + (challenge8Matcher.end(1) - 1));
        }

        String challenge9 = "{0, 2}, {0, 5}, {1, 3}, {2, 4}";
        Pattern challenge9Pattern = Pattern.compile("\\{(\\d+, \\d+)\\}");
        Matcher challenge9Matcher = challenge9Pattern.matcher(challenge9);

        while (challenge9Matcher.find()) {
            System.out.println("Occurrence: " + challenge9Matcher.group(1));
        }





    }
}