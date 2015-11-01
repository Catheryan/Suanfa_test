package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyIoStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("tupian.jpg");
			FileOutputStream fos =new FileOutputStream("tupian_new.jpg");
			byte input[] =new byte[50];
			while (fis.read(input)!=-1) {
				fos.write(input);
			}
			fis.close();
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
