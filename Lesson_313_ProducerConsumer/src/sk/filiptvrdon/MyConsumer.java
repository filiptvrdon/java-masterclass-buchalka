package sk.filiptvrdon;

import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

import static sk.filiptvrdon.Main.EOF;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    private ReentrantLock bufferLock;

    public MyConsumer(List<String> buffer, String color, ReentrantLock bufferLock) {
        this.buffer = buffer;
        this.color = color;
        this.bufferLock = bufferLock;
    }

    @Override
    public void run() {
        int counter = 0;
        while (true) {
            if (bufferLock.tryLock()) {
                try {
                    if (buffer.isEmpty()) {
                        continue;
                    }
                    System.out.println(color + "The counter = " + counter);
                    counter = 0;

                    if (buffer.get(0).equals(EOF)) {
                        System.out.println(color + "Exiting");
                        break;
                    } else {
                        String removedString = buffer.remove(0);
                        System.out.println(color + "Removed " + removedString);
                    }
                } finally {
                    bufferLock.unlock();
                }
            } else {
                counter++;
            }
        }
    }
}