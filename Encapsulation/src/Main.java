public class Main {
    public static void main(String[] args) {
        Player player = new Player("Tim", 200, "Axe");
        System.out.println("Initial health is " + player.healthRemaining());
        System.out.println(player);

    }
}
