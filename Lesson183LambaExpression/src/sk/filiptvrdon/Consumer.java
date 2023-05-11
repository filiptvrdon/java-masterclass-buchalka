package sk.filiptvrdon;
import java.util.Arrays;
import java.util.function.BiConsumer;

// CONSUMER CATEGORY

public class Consumer {
    public static void main(String[] args) {
        var coords = Arrays.asList(
                new double[]{47.2160, -95.2348},
                new double[]{29.1566, -89.2495},
                new double[]{35.1556, -90.0659}
        );

//        BiConsumer<Double, Double> p1 = (lat, lng) -> System.out.printf("[Lat:%.3f, Lng:%.3f]%n", lat, lng);

        coords.forEach(point -> processPoint(
                point[0],
                point[1],
                (lat, lng) -> System.out.printf("[Lat:%.3f, Lng:%.3f]%n", lat, lng)));
    }



    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer) {
        consumer.accept(t1, t2);
    }
}
