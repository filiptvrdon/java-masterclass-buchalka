package dev.makay;

public class Main {
    public static void main(String[] args) {
        Telephone myPhone = new MobilePhone(1234567);
//        myPhone.powerOn();
        myPhone.callPhone(1234567);
        myPhone.answer();

    }
}