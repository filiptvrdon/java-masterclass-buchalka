public class Calculator {
    private Carpet carpet;
    private Floor floor;

    public Calculator(Floor floor, Carpet carpet) {
        this.carpet = carpet;
        this.floor = floor;
    }

    public double getTotalCost(){
        return floor.getArea() * carpet.getCost();
    }
}
