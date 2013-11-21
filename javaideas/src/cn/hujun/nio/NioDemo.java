package cn.hujun.nio;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readByLine();
	}
	
	private static void readByLine()
	{
		try {
			FileChannel fc = new RandomAccessFile("d:\\umslog.txt", "rw").getChannel();
			ByteBuffer bb = ByteBuffer.allocate(1024);
			byte[] temp = new byte[1024]; 
			int n = 0;
			StringBuffer sb = new StringBuffer();
			while((n = fc.read(bb)) != -1)
			{
				bb.rewind();
				bb.get(temp);
				bb.clear();
				sb.append(new String(temp,0,n,"utf-8"));
			}
			System.out.println(sb.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
