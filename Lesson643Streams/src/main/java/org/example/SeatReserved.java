package org.example;

import java.util.Random;

public record SeatReserved (char row, int number, boolean reserved) {
    public SeatReserved(char row, int number) {
        this(row, number, new Random().nextBoolean());
    }

}
