package sk.filiptvrdon;

public class ExtendedPassword extends Password {
    private int decryptedPassword;
    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password;
    }

//    @Override
//    public void storePassword() {
////        super.storePassword();
//        System.out.println("Saving password as " + this.decryptedPassword);
//    }
}
