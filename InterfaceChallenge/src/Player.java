import java.util.ArrayList;
import java.util.List;

public class Player implements Saveable{
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    @Override
    public List<String> write() {
        List<String> values = new ArrayList<String>();
        values.add(this.getName());
        values.add("" + this.getHitPoints());
        values.add("" + this.getStrength());
        values.add(this.getWeapon());
        return values;
    }

    @Override
    public void read(List<String> list) {
        if (list == null || list.size() == 0) {
            System.out.println("Invalid input list!");
            return;
        }

        this.setName(list.get(0));
        this.setHitPoints(Integer.parseInt(list.get(1)));
        this.setStrength(Integer.parseInt(list.get(2)));
        this.setWeapon(list.get(3));
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
