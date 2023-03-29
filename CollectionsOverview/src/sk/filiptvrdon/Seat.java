package sk.filiptvrdon;

public class Seat implements Comparable<Seat> {

    private final String seatNumber;
    private boolean reserved;
    private double price;

    Seat(String seatNumber, double price) {
        this.seatNumber = seatNumber;
        this.price = price;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public int compareTo(Seat seat) {
        return this.seatNumber.compareTo(seat.getSeatNumber());
    }

    public boolean reserve() {
        if (!this.reserved){
            this.reserved = true;
            System.out.println("Seat " + seatNumber + " has been reserved.");
            return true;
        } else {
            return false;
        }
    }


    public boolean cancelReservation(){
        if (this.reserved){
            this.reserved = false;
            System.out.println("Reservation for seat " + seatNumber + " has been canceled");
            return true;
        } else {
            return false;
        }
    }
}
