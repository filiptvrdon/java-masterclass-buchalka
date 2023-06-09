package sk.filiptvrdon;

import java.util.Random;

public class Writer implements Runnable {
    private Message message;

    public Writer(Message message) {
        this.message = message;
    }

    @Override
    public void run() {
        String[] messages ={
            "Humpty Dumpty sat on a wall,",
                    "Humpty Dumpty had a great fall.",
                    "All the king's horses and all the kings's men",
                    "Couldn't put Humpty together again."
        };

        Random random = new Random();

        for (int i = 0; i < messages.length; i++) {
            message.write(messages[i]);
            try {
                Thread.sleep(random.nextInt(2000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message.write("Finished");
    }
}
