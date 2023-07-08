import java.util.TreeSet;

public class Theatre {
    
    private final char[] rows = new char[]{
        'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M'};

    private TreeSet<Seat> seats;

    public Theatre(String theatreName) {
        this.seats = initializeSeats();
    }

    private TreeSet<Seat> initializeSeats() {
        TreeSet<Seat> seats = new TreeSet<>();

        for (char row : rows) {
            int seatsPerRow = 12;
            for (int seatNumber = 1; seatNumber <= seatsPerRow; seatNumber++) {
                seats.add(new Seat(String.valueOf(row), seatNumber));
            }
        }



        return seats;

    }

    class Seat implements Comparable<Seat> {
        private final String seatNumber;
        private boolean reserved = false;

        public Seat(String seatNumber) {
            this.seatNumber = seatNumber;
        }

        public Seat  (String row, int seatNumber) {
            this.seatNumber = String.format(row + "%03d", seatNumber).toUpperCase();
        }

        private String getSeatNumber() {
            return this.seatNumber;
        }

        @Override
        public int compareTo(Seat o) {
            return this.seatNumber.compareTo(o.getSeatNumber());
        }

    }
}
