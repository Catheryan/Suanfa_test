package com.demo.httpget;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class get {
	public static void main(String[] args) {
		new ReadBByGet().start();
	}
}
class ReadBByGet extends Thread{
	@Override
	public void run() {
		
		try {
			
			
			
			URL url =new URL("http://fanyi.youdao.com/openapi.do?keyfrom=testjavads&key=1926183613&type=data&doctype=xml&version=1.1&q=潘明晖");
			URLConnection connection =url.openConnection();
			InputStream is=connection.getInputStream();
			InputStreamReader isr=new InputStreamReader(is,"utf-8");
			BufferedReader br=new BufferedReader(isr);
			String line;
			StringBuilder builder=new StringBuilder();
			while ((line=br.readLine())!=null) {
				builder.append(line);
			}
			br.close();
			isr.close();
			is.close();
			System.out.println(builder.toString());
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
