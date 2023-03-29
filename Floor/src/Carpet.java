public class Carpet {
    double cost;

    public double getCost() {
        return cost;
    }

    public Carpet(double cost) {
        this.cost = cost < 0 ? 0 : cost;
    }
}
