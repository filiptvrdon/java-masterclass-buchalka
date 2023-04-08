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


            // read the integers from the file in reverse order
            RandomAccessFile ra = new RandomAccessFile("data.dat", "rwd");
            FileChannel channel = ra.getChannel();
            ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
            channel.position(int3Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int3 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int2Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int2 = " + readBuffer.getInt());
            readBuffer.flip();
            channel.position(int1Pos);
            channel.read(readBuffer);
            readBuffer.flip();
            System.out.println("int1 = " + readBuffer.getInt());

            // write the integers into the file in the same positions as before using random access
//            ByteBuffer writeBuffer = ByteBuffer.allocate(Integer.BYTES);
//            writeBuffer.putInt(245);
//            writeBuffer.flip();
//            channel.write(writeBuffer, int1Pos);
//            writeBuffer.flip();
//            writeBuffer.putInt(-98765);
//            writeBuffer.flip();
//            channel.write(writeBuffer, int2Pos);
//            writeBuffer.flip();
//            writeBuffer.putInt(1000);
//            writeBuffer.flip();
//            channel.write(writeBuffer, int3Pos);

            byte[] outputString = "Hello, World!".getBytes();
            long str1Pos = 0;
            long newInt1Pos = outputString.length;
            long newInt2Pos = newInt1Pos + Integer.BYTES;
            byte[] outputString2 = "Nice to meet you".getBytes();
            long str2Pos = newInt2Pos + Integer.BYTES;
            long newInt3Pos = str2Pos + outputString2.length;

            ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
            intBuffer.putInt(245);
            intBuffer.flip();
            binChannel.position(newInt1Pos);
            binChannel.write(intBuffer);
            intBuffer.flip();

            intBuffer.putInt(-98765);
            intBuffer.flip();
            binChannel.position(newInt2Pos);
            binChannel.write(intBuffer);
            intBuffer.flip();

            intBuffer.putInt(1000);
            intBuffer.flip();
            binChannel.position(newInt3Pos);
            binChannel.write(intBuffer);

            binChannel.position(str1Pos);
            binChannel.write(ByteBuffer.wrap(outputString));
            binChannel.position(str2Pos);
            binChannel.write(ByteBuffer.wrap(outputString2));

        } catch (IOException e) {
            e.printStackTrace();
        }




    }
}