public class Ford extends Car {

    public Ford(int cylinders, String name){
        super(cylinders, name);
    }

    @Override
    public void startEngine(){
        System.out.println(this.getClass().getSimpleName() + " " + getName() + " is starting engine with bagpipes blowing energetically.");
    }
}
