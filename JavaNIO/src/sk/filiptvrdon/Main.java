package sk.filiptvrdon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        try (FileOutputStream binFile = new FileOutputStream("data.dat");
             FileChannel binChannel = binFile.getChannel()) {

            ByteBuffer buffer = ByteBuffer.allocate(100);
            //byte[] outputBytes = "Hello World!".getBytes();
            // byte[] outputBytes2 = "Nice to meet you".getBytes();

            // put method returns the buffer so we can chain the methods
//            buffer.put(outputBytes)
//                  .putInt(245)
//                  .putInt(-98765)
//                  .put(outputBytes2)
//                  .putInt(1000);
//            buffer.flip(); // flip method sets the position to 0 so that when buffer is written to the file, it starts from the beginning


            byte[] outputBytes = "Hello World!".getBytes();
            buffer.put(outputBytes);

            long int1Pos = outputBytes.length;
            buffer.putInt(245);

            long int2Pos = int1Pos + Integer.BYTES;
            buffer.putInt(-98765);

            byte[] outputBytes2 = "Nice to meet you".getBytes();
            buffer.put(outputBytes2);

            long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
            buffer.putInt(1000);

            buffer.flip(); // sets the position to 0 so that when buffer is written to the file, it starts from the beginning
            binChannel.write(buffer);

            // print out the int positions in the file
            System.out.println("int1Pos = " + int1Pos);
            System.out.println("int2Pos = " + int2Pos);
            System.out.println("int3Pos = " + int3Pos);


            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(100);
            channel.read(readBuffer);
            readBuffer.flip();
            byte[] inputString = new byte[outputBytes.length];
            readBuffer.get(inputString);
            System.out.println("inputString = " + new String(inputString));
            System.out.println("int1 = " + readBuffer.getInt());
            System.out.println("int2 = " + readBuffer.getInt());
            byte[] inputString2 = new byte[outputBytes2.length];
            readBuffer.get(inputString2);
            System.out.println("inputString2 = " + new String(inputString2));
            System.out.println("int3 = " + readBuffer.getInt());







        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}