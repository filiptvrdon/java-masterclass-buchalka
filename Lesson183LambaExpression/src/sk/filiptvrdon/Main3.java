package sk.filiptvrdon;

public class Main3 {
    public static void main(String[] args) {
        var result = calculator((a, b) -> a + b, 5, 10);
        result = calculator((a, b) -> a * b, 5, 10);
        result = calculator((a, b) -> a / b, 5, 10);
        var result2 = calculator((a, b) -> a - b, 58.50, 10.2);
        var result3 = calculator((a, b) -> a + " " + b, "Hello", "World");

    }

    public static <T> T calculator (Operation<T> function, T value1, T value2){
        T result = function.operate(value1, value2);
        System.out.println("Result of operation: " + result);
        return result;
    };
}
