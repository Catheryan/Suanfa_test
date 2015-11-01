package com.test.seversocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.Socket;

public class ChatSocket extends Thread {
	Socket socket;

	public ChatSocket(Socket socket) {

		this.socket = socket;

	}
	public void out(String out){
			try {
				socket.getOutputStream().write(out.getBytes("utf-8"));
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	@Override
	public void run() {
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream(),"utf-8"));
			
			String line;
			while((line=br.readLine())!=null){
				ChatManager.getChatManager().publish(this, line);
			}
			br.close();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
