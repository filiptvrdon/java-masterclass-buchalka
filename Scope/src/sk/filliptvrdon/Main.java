package sk.filliptvrdon;

public class Main {
    public static void main(String[] args) {
        String privateVar = "this is a private string in Main";

        ScopeCheck scopeCheck = new ScopeCheck();
        System.out.println("ScopeCheck privateVar is: " + scopeCheck.getVar1());
        System.out.println(privateVar);


        scopeCheck.timesTwo();

        ScopeCheck.InnerClass innerClass = scopeCheck.new InnerClass(3);
        innerClass.timesTwo();


        scopeCheck.useInner();

    }
}