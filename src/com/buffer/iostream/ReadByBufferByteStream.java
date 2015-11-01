package com.buffer.iostream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ReadByBufferByteStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis =new FileInputStream("3.mp4");
			FileOutputStream fos =new FileOutputStream("3_new.mp4");
			BufferedInputStream bis =new BufferedInputStream(fis,100000);
			BufferedOutputStream bos=new BufferedOutputStream(fos,100000);
			
			byte input[] =new byte[1000];
			int count=0;
			while (bis.read(input)!=-1) {
				bos.write(input);
				count++;
			}
			bis.close();
			fis.close();
			bos.close();
			bis.close();
			System.out.println("∂¡»°¡À£∫"+count+"¥Œ");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
