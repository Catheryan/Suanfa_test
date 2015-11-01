package com.test.seversocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.swing.JOptionPane;

import com.sun.jna.Function;

/**
 * 
 * @author yzh {@link Function}获取服务器对象交互的socket
 */
public class SeverListener extends Thread {
	@Override
	public void run() {
		// 1-65535
		try {
			ServerSocket serverSocket = new ServerSocket(12355);
			while (true) {
				Socket socket = serverSocket.accept();
				//建立连接
				JOptionPane.showMessageDialog(null, "服务器建立连接12355端口");
				//将socket传递给新的线程
				ChatSocket cs=new ChatSocket(socket);
				cs.start();
				ChatManager.getChatManager().add(cs);
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
