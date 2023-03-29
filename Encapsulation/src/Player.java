public class Player {
    private String name;
    private int healthPercentage;
    private String weapon;

    public Player(String name) {
        this(name, 100, "Sword");
    }

    public Player(String name, int healthPercentage, String weapon) {
        this.healthPercentage = (healthPercentage <= 0) ? 0 : Math.min(healthPercentage, 100);
        this.name = name;
        this.weapon = weapon;
    }

    public void loseHealth (int damage){
        healthPercentage -= damage;
        if (healthPercentage <= 0){
            System.out.println("Player knocked out of game.");
        }
    }

    public int healthRemaining(){
        return healthPercentage;
    }

    public void restoreHealth(int extraHealth) {
        healthPercentage += extraHealth;
        if (healthPercentage > 100){
            healthPercentage = 100;
            System.out.println("Player restored to 100%");
        }
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", health=" + healthPercentage +
                ", weapon='" + weapon + '\'' +
                '}';
    }
}
