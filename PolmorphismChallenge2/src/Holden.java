public class Holden extends Car {

    public Holden(int cylinders, String name){
        super(cylinders, name);
    }

    @Override
    public void startEngine(){
        System.out.println(this.getClass().getSimpleName() + " " + getName() + "'is starting its Australian made engine with didjeridus playing in the background");
    }

}
