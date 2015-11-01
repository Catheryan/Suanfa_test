package com.demo.httpget;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class httppost {

	public static void main(String[] args) {
		new post().start();
	}

}

class post extends Thread {
	@Override
	public void run() {

		try {

			URL url = new URL("http://fanyi.youdao.com/openapi.do");
			HttpURLConnection connect = (HttpURLConnection) url
					.openConnection();
			connect.addRequestProperty("encoding", "utf-8");
			connect.setDoOutput(true);
			connect.setDoInput(true);
			connect.setRequestMethod("POST");

			OutputStream os = connect.getOutputStream();
			OutputStreamWriter osr = new OutputStreamWriter(os);
			BufferedWriter bw = new BufferedWriter(osr);

			bw.write("keyfrom=testjavads&key=1926183613&type=data&doctype=xml&version=1.1&q=潘明晖");
			bw.flush();

			InputStream is = connect.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);

			
			String line;
			StringBuilder builder = new StringBuilder();
			while ((line = br.readLine()) != null) {
				builder.append(line);
			}
			
			br.close();
			isr.close();
			is.close();
			
			
			bw.close();
			osr.close();
			os.close();
			System.out.println(builder.toString());

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
