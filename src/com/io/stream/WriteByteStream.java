package com.io.stream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteByteStream {
	
	public static void main(String[] args) {
		try {
			FileOutputStream fos= new FileOutputStream("textw.txt");
			
			String outString ="write 51661สนตร";
			byte output[]=outString.getBytes();
			fos.write(output);
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
