package com.test.fileStream;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class TestFileReader {
	public static void main(String[] args) {
		try {
			FileReader fr=new FileReader("text.txt");
			BufferedReader br =new BufferedReader(fr);
			
			FileWriter fw= new FileWriter("text_2.txt");
			BufferedWriter bw =new BufferedWriter(fw);
			
			String line;
			while((line=br.readLine()) != null){
				bw.write(line+"\n");
				
			}
			bw.flush();
			bw.close();
			fw.close();
			fr.close();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
