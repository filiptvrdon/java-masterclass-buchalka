import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        Player player = new Player("Filip", 100, 100);
        System.out.println(player);

        System.out.println(player.write());


        List<String> newPlayerValues = new ArrayList<String>();
        newPlayerValues.add("Filip II");
        newPlayerValues.add("150");
        newPlayerValues.add("150");
        newPlayerValues.add("Battle Axe");
        player.read(newPlayerValues);
        System.out.println(player.write());

    }
}