package sk.filiptvrdon;

import java.util.List;

import static sk.filiptvrdon.Main.EOF;

public class MyConsumer implements Runnable {
    private List<String> buffer;
    private String color;

    public MyConsumer(List<String> buffer, String color) {
        this.buffer = buffer;
        this.color = color;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (buffer) {
                if (buffer.isEmpty()) {
                    continue;
                }

                if (buffer.get(0).equals(EOF)) {
                    System.out.println(color + "Exiting");
                    break;
                } else {
                    String removedString = buffer.remove(0);
                    System.out.println(color + "Removed " + removedString);
                }
            }
        }
    }
}