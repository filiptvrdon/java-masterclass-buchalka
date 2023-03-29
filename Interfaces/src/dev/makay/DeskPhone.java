package dev.makay;

public class DeskPhone implements Telephone{
    private int myNumber;
    private boolean isRinging;

    public DeskPhone(int myNumber) {
        this.myNumber = myNumber;
        this.isRinging = false;
    }

    @Override
    public void powerOn() {
        System.out.println("No action, desk phone does not have a power button");
    }

    @Override
    public void dial(int phoneNumber) {
        System.out.println(("Dialing " + phoneNumber));
    }

    @Override
    public void answer() {
        System.out.println("Answering the desk phone!");
    }

    @Override
    public boolean callPhone(int phoneNumber) {
        if (phoneNumber == myNumber){
            isRinging = true;
            System.out.println("Ring Ring!");
        } else {
            isRinging = false;
        }
        return isRinging;
    }

    @Override
    public boolean isRinging() {
        return isRinging;
    }
}
