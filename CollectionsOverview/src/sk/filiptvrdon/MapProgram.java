package sk.filiptvrdon;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String,String> languages = new HashMap<String,String>();
        languages.put("Java", "compiled high level, object orientated, platform independent language");
        languages.put("Python", "an interpreted object orientated high level programming language with dynamic semantics");
        languages.put("Algol", "an algorithmic language");
        languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code");
        languages.put("Lisp", "Therein lies madness");

        System.out.println(languages.get("Java"));

        if (languages.containsKey("Java")){
            System.out.println("Java is alredy there!");
        } else {
            languages.put("Java", "This course is about Java!");
            System.out.println("Java: " + languages.get("Java"));
        }

        languages.remove("Algol", "aaa");

        languages.replace("Lisp", "a functional programming language with imperative features");
        languages.replace("Scala", "this will not be added");

        languages.replace


        System.out.println("=".repeat(100));
        for (String key : languages.keySet()) {
            System.out.println(key + ": " + languages.get(key));
        }



    }
}
