package sk.filiptvrdon;

import java.util.*;

public class Theatre {
    private final String theatreName;
    public List<Seat> seats = new ArrayList<>();

    static final Comparator<Seat> PRICE_ORDER = (seat1, seat2) -> {
        if (seat1.getPrice() < seat2.getPrice()){
            return -1;
        } else if (seat1.getPrice() > seat2.getPrice()){
            return 2;
        } else {
            return 0;
        }

    };

    public Theatre(String theatreName,int numRows, int seatsPerRow) {
        this.theatreName = theatreName;

        int lastRow = 'A' + (numRows - 1);
        for (char row = 'A'; row <= lastRow; row++) {
            for (int seatNum = 1; seatNum <= seatsPerRow; seatNum++) {
                double price = 12.00;
                if ((row < 'D') && (seatNum >= 4 && seatNum <= 9)){
                    price = 14.00;
                } else if ((row > 'F') || ((seatNum < 4) ||seatNum > 9)){
                    price = 7.00;
                }
                Seat seat = new Seat(row + String.format("%02d", seatNum), price);
                seats.add(seat);
            }
        }
    }

    public String getTheatreName() {
        return theatreName;
    }

    public boolean reserveSeat (String seatNumber){
        Seat requestedSeat = new Seat(seatNumber, 0.00);
        int foundSeat = Collections.binarySearch(seats,requestedSeat, null);
        if (foundSeat >= 0){
            return seats.get(foundSeat).reserve();
        } else {
            System.out.println("Requested seat " + seatNumber + " doesn't exist!");
            return false;
        }

    }

    public Collection<Seat> getSeats(){
        return seats;
    }
}
