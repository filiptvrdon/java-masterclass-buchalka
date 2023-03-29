package sk.filiptvrdon;

public class Password {

    private static final int key = 6785248;
    private final int encryptedPassword;

    public Password(int encryptedPassword) {
        this.encryptedPassword = encryptPassword(encryptedPassword);
    }

    private int encryptPassword(int password) {
        System.out.println("encrypted " + password + " to the value of " + (password ^ key));
        return password ^ key;
    }

    public final void storePassword(){
        System.out.println("Saving password as " + encryptedPassword);
    }

    public boolean login(int password) {
        if (encryptPassword(password) == this.encryptedPassword){
            System.out.println("Welcome!");
            return true;
        } else {
            System.out.println("Nope, wrong password");
            return false;
        }
    }

}
