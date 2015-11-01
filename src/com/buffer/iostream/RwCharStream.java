package com.buffer.iostream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class RwCharStream {

	public static void main(String[] args) {
		try {
			FileInputStream fis = new FileInputStream("text.txt");
			FileOutputStream fos = new FileOutputStream("text_new2.txt");
			InputStreamReader isr = new InputStreamReader(fis);
			OutputStreamWriter osr = new OutputStreamWriter(fos);

			char input[] = new char[100];
			int before = 0;
			while ((before = isr.read(input)) != -1) {
				// System.out.println(new String(input, 0, before));
				osr.write(input, 0, before);
			}
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
