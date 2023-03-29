package sk.filliptvrdon;

public class ScopeCheck {
    public int publicVar = 0;
    private int var1 = 1;

    public ScopeCheck(){
        System.out.println("Scope Check ---> publicVar: " + publicVar + ", privateVar: " + var1);
    }

    public int getVar1(){
        return var1;
    }

    public void timesTwo(){
        int var2 = 2;
        for (int i=0; i<10; i++){
            System.out.println(i + " x 2 = " + (i*var2)+this.var1);
        }
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass(3);
        System.out.println("var3 from outer class is: " + innerClass.var3);
    }

    public class InnerClass{
        private int var3 = 3;

        public InnerClass(int var3) {
            this.var3 = var3;
            System.out.println("Inner Classcreated, var3 is " + var3);
        }
        public void timesTwo(){
            System.out.println("var1 still has the value of " + var1);
            for (int i=0; i<10; i++){
                System.out.println(i + " x 2 = " + (i* var3));
            }
        }

    }

}
