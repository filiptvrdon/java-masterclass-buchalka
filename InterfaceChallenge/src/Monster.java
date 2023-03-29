import java.util.ArrayList;
import java.util.List;

public class Monster implements Saveable{
    private String name;
    private int hitPoints;
    private int strength;

    public Monster(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(this.getName());
        values.add("" + this.getHitPoints());
        values.add("" + this.getStrength());
        return values;
    }

    @Override
    public void read(List<String> list) {
        if (list == null || list.size() == 0) {
            System.out.println("Invalid input list!");
            return;
        }
        List<String> storedList = new ArrayList<String>();
        storedList.add(list.get(0));
        storedList.add(list.get(1));
        storedList.add(list.get(2));
        storedList.add(list.get(3));
        System.out.println("STORED LIST: " + storedList);
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }
}