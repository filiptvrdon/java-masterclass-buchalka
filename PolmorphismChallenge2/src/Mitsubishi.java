public class Mitsubishi extends Car {

    public Mitsubishi(int cylinders, String name){
        super(cylinders, name);
    }

    @Override
    public void startEngine(){
        System.out.println(this.getClass().getSimpleName() + " " + getName() + "'s Japanese engine is starting with a zooming sound");
    }

}
