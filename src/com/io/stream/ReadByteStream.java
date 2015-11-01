package com.io.stream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

public class ReadByteStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis=new FileInputStream("text.txt");
			byte input[]=new byte[24];
			fis.read(input);
			String inputString=new String(input,"GBK");
			System.out.println(inputString);
			fis.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
