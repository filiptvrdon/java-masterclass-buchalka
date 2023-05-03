package sk.filiptvrdon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Echoer extends Thread{
    private Socket socket;

    public Echoer(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run(){
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream(), true);

            while (true) {
                String echoString = input.readLine();
                System.out.println("Received client input: " + echoString);

                if (echoString.equals("exit")) {
                    break;
                }

                try {
                    Thread.sleep(6000);
                } catch (InterruptedException e) {
                    System.out.println("Thread interrupted");
                }

                output.println("Echo from server: " + echoString);
            }
        } catch (Exception e) {
            System.out.println("Server exception " + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
                System.out.println("Exception: " + e.getMessage());
            }
        }

    }

}
