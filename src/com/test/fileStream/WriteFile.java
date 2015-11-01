package com.test.fileStream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WriteFile extends Thread {
	File file; 
	int b;
	public WriteFile(File file, int b) {
		this.file=file;
		this.b=b;
	}
	@Override
	public void run() {
		try {
			RandomAccessFile raf=new RandomAccessFile(file, "rw");
			raf.seek((b-1)*100);
			raf.writeBytes(""+b);
			raf.writeBytes("\n");
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
