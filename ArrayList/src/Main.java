import java.util.ArrayList;
import java.util.Arrays;

record GroceryItem(String name, String type, int count) {
    public GroceryItem(String name){
        this(name, "DAIRY", 1);
    }

    @Override
    public String toString() {
        return String.format("%d %s in %s", count, name.toUpperCase(), type);
    }
}

public class Main {
    public static void main(String[] args) {
        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        groceryList.add(new GroceryItem("yoghurt"));
        groceryList.add(new GroceryItem("bananas", "PRODUCE", 10));
        groceryList.add(0,new GroceryItem("apples", "PRODUCE", 10));
        groceryList.set(1, new GroceryItem("butter", "DAIRY", 2));


        System.out.println(groceryList);
    }
}