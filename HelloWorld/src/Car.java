public class Car {

    private String make = "Ford";
    private String model = "Focus";
    private String color = "Gray";
    private int doors = 5;
    private boolean convertible = false;

    /* GETTERS and SETTERS are used to crate public-showing interface of the class.
    Coming from INFORMATION HIDING principle, instead of allowing private fields being changed directly,
    we create a set of methods that enable changing the values of private fields. These can include validation, checks, etc. */

    // GETTERS //
    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getDoors() {
        return doors;
    }

    public boolean isConvertible() {
        return convertible;
    }

    // SETTERS //
    public void setMake(String make) {
        this.make = make;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setConvertible(boolean convertible) {
        this.convertible = convertible;
    }



    public void describeCar(){
        System.out.println(doors + "-Door " +
                color + " " +
                make + " " +
                model + " " +
                (convertible ? "Convertible" : ""));
    }

}
