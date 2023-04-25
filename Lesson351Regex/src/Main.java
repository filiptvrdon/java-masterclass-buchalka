import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

//        String string = "abcdefghijklmnopqrstuvwxyz. ABCDEFGHIKLMNOPQRSTUWVXYZ. 0123456789. Quick brown Fox jumps over the lazy Dog.s";
//        System.out.println(string);
//
//        System.out.println(string.replaceAll("[Qq]uick", "SLOW"));
//        System.out.println(string.replaceAll("[a-fA-F3-8]", "X"));
//        System.out.println(string.replaceAll("(?i)[a-fA-F3-8]", "X"));
//        System.out.println(string.replaceAll("[0-9]", "X"));
//        System.out.println(string.replaceAll("\\d", "X"));
//        System.out.println(string.replaceAll("\\D", "X"));
//        System.out.println(string.replaceAll("\\s", "X"));
//        System.out.println(string.replaceAll("\\S", "X"));
//        System.out.println(string.replaceAll("\\w", "X"));
//        System.out.println(string.replaceAll("\\W", "X"));
//
//        String string2 = "abcDeeeF12Ghhiiiijkl99z";
//        System.out.println(string2.replaceAll("^abcDeee", "YYY"));
//        System.out.println(string2.replaceAll("^abcDe{3}", "XXX"));
//        System.out.println(string2.replaceAll("^abcDe+", "+++++"));
//        System.out.println(string2.replaceAll("^abcDe*", "*****"));
//        System.out.println(string2.replaceAll("^abcDe{2,5}", "-----"));

        StringBuilder htmlText = new StringBuilder("<h1>My Heading</h1>");
        htmlText.append("<h2>Sub-heading</h2>");
        htmlText.append("<p>This is a paragraph about something.</p>");
        htmlText.append("<p>This is another paragraph about something else.</p>");
        htmlText.append("<h2>Summary</h2>");
        htmlText.append("<p>Here is the summary.</p>");

        String h2Pattern = "<h2>";
        Pattern pattern = Pattern.compile(h2Pattern);
        Matcher matcher = pattern.matcher(htmlText);

        System.out.println(matcher.matches());
        matcher.reset();

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + matcher.start() + " to " + matcher.end());
        }

        String h2GroupPattern = "(<h2>.*?</h2>)";
        Pattern groupPattern = Pattern.compile(h2GroupPattern);
        Matcher groupMatcher = groupPattern.matcher(htmlText);
        System.out.println(groupMatcher.matches());
        groupMatcher.reset();

        while (groupMatcher.find()) {
            System.out.println("Occurrence: " + groupMatcher.group(1));
        }

        String h2TextGroups = "(<h2>)(.+?)(</h2>)";
        Pattern h2TextPattern = Pattern.compile(h2TextGroups);
        Matcher h2TextMatcher = h2TextPattern.matcher(htmlText);
        while (h2TextMatcher.find()) {
            System.out.println("Occurrence: " + h2TextMatcher.group(2));
        }


        String tvTest = "tstvtkt";
//        String tNotVRegExp = "t[^v]";
        String tNotVRegExp = "t(?!v)";
        Pattern tNotVPattern = Pattern.compile(tNotVRegExp);
        Matcher tNotVMatcher = tNotVPattern.matcher(tvTest);

        count = 0;
        while (tNotVMatcher.find()) {
            count++;
            System.out.println("Occurrence " + count + " : " + tNotVMatcher.start() + " to " + tNotVMatcher.end());
        }

        String phone1 = "1234567890"; // should match
        String phone2 = "(123) 456-7890"; // should match
        String phone3 = "123 456-7890"; // should not match
        String phone4 = "(123)456-7890"; // should not match

        String phoneRegExp = "^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$";
        System.out.println(phone1.matches(phoneRegExp));
        System.out.println(phone2.matches(phoneRegExp));
        System.out.println(phone3.matches(phoneRegExp));
        System.out.println(phone4.matches(phoneRegExp));







    }
}