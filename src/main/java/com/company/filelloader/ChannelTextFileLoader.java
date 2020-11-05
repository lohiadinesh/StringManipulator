/**
 * 
 */
package com.company.filelloader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * Java Program to read and write on RandomAccessFile in Java
 * using FileChannle and ByteBuffer.
 */
public class ChannelTextFileLoader {

    public static void main(String args[]) {

        Tablet ipad = new Tablet("Apple", true, 1000);
        System.out.println("Writing into RandomAcessFile : " + ipad);
        write("tablet.store", ipad);

        Tablet fromStore = new Tablet();
        read("tablet.store", fromStore);
        System.out.println("Object read from RandomAcessFile : "
                                    + fromStore);

    }

    /*
     * Method to write data into File using FileChannel and ByteBuffeer
     */
    public static void write(String filename, Persistable object) {
        try {
            // Creating RandomAccessFile for writing
            RandomAccessFile store = new RandomAccessFile("ChannelIO", "rw");

            // getting FileChannel from file
            FileChannel channel = store.getChannel();

            // creating and initializing ByteBuffer for reading/writing data
            ByteBuffer buffer = ByteBuffer.allocate(2048);

            // an instance of Persistable writing into ByteBuffer
            object.persist(buffer);

            // flip the buffer for writing into file
            buffer.flip();
            int numOfBytesWritten = channel.write(buffer); 
            // writing into File
            System.out.println("number of bytes written : " 
                                      + numOfBytesWritten);
            channel.close(); // closing file channel
            store.close(); // closing RandomAccess file

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*
     * Method to read data from File using FileChannel and ByteBuffeer
     */
    public static void read(String filename, Persistable object) {
        try {
            // Opening RandomAccessFile for reading data
            RandomAccessFile store = new RandomAccessFile("ChannelIO", "rw");

            // getting file channel
            FileChannel channel = store.getChannel();

            // preparing buffer to read data from file
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            // reading data from file channel into buffer
            int numOfBytesRead = channel.read(buffer);
            System.out.println("number of bytes read : " + numOfBytesRead);

            // You need to filp the byte buffer before reading
            buffer.flip();

            // Recovering object
            object.recover(buffer);

            channel.close();
            store.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}