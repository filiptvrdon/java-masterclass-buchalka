package sk.filiptvrdon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Theatre theatre = new Theatre("Olympia", 8, 12);
        printList(theatre.seats);

        if (theatre.reserveSeat("H11")){
            System.out.println("please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        if (theatre.reserveSeat("H14")){
            System.out.println("please pay");
        } else {
            System.out.println("Sorry, seat is taken");
        }

        List<Seat> reverseSeats = new ArrayList<>(theatre.getSeats());
        Collections.reverse(reverseSeats);
        printList(reverseSeats);

        List<Seat> priceOrderedSeats = new ArrayList<>(theatre.getSeats());
        priceOrderedSeats.add(new Seat("B00", 13.00));
        priceOrderedSeats.add(new Seat("A00", 13.00));
        Collections.sort(priceOrderedSeats, Theatre.PRICE_ORDER);
        printList(priceOrderedSeats);


    }
    public static void printList(List<Seat> list){
        for (Seat seat : list){
            System.out.println(" " + seat.getSeatNumber() + " >>> " + seat.getPrice());
        }
        System.out.println();
        System.out.println("=".repeat(50));
    }

    public static void sortList(List< ? extends Seat> list){
        for (int i = 0; i <list.size(); i++){
            for (int j = i+1; j < list.size(); j++ ){
                if (list.get(i).compareTo(list.get(j)) > 0){
                    Collections.swap(list, i, j);
                }
            }
        }
    }
}