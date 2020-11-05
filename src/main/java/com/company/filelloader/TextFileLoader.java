/**
 * 
 */
package com.company.filelloader;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author HP
 *
 */
public class TextFileLoader {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TextFileLoader loader = new TextFileLoader();
		loader.load();
	}

	public void load() {
		try {
			final RandomAccessFile file = new RandomAccessFile("IO.txt", "rw");
			final int numberOfThread = 1;
			ExecutorService pool = Executors.newFixedThreadPool(numberOfThread);
			StringBuilder string = new StringBuilder();
			for (int i = 0; i < 999999; i++) {
				string.append(i + " Line has been written into the system, Please verify as soon as poosible.\r\n");
			}
			final byte[] yourText = string.toString().getBytes();
			pool.submit(new Runnable() {
				@Override
				public void run() {
					byte[] chunkData = new byte[yourText.length];
					System.arraycopy(yourText, 0, chunkData, 0, yourText.length);
					try {
						final Long stime =  System.currentTimeMillis();
						file.write(chunkData);
						System.out.println("Time Taken for 999999 Lines :"+(System.currentTimeMillis() - stime));
					} catch (IOException e) {
						System.out.println(e);
					} catch (Exception e) {
						System.out.println(e);
					} finally {
						try {
							file.close();
						} catch (IOException e1) {
							System.out.println(e1);
						}
					}

				}
			});
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
