package com.buffer.iostream;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class RwByBufferStream {
	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			FileOutputStream fos = new FileOutputStream("text_new2.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			OutputStreamWriter osr = new OutputStreamWriter(fos);
			
			
			BufferedReader br =new BufferedReader(isr);
			//BufferedWriter bw=new BufferedWriter(osr);
			PrintWriter pwr=new PrintWriter(fos,true);
			
			String input =null;
			while ((input=br.readLine()) != null) {
				//bw.write(input);
				pwr.println(input);
			}
			br.close();
			isr.close();
			fis.close();
			osr.close();
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
