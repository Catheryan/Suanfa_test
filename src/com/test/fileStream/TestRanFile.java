package com.test.fileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TestRanFile {
	static File file = new File("text.txt");

	public static void main(String[] args) {
		
		//多线程下载
		if (file.exists()) {
			file.delete();

		}
		new WriteFile(file, 1).start();
		new WriteFile(file, 2).start();
		new WriteFile(file, 3).start();
		new WriteFile(file, 3).start();
		new WriteFile(file, 4).start();
	
		try {
			RandomAccessFile raf =new RandomAccessFile(file, "r");
			raf.seek(200);
			byte str[]=new byte[20];
			raf.read(str);
			String in=new String(str);
			System.out.println(in);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
