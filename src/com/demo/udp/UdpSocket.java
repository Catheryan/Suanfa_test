package com.demo.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

/**
 * 
 * @author yzh 
 * 		   1.UDP协议简介
 *         UDP是一个无连接，不可靠的协议。即：数据的发送方只负责将数据发送出去，数据的接收方值负责接收数据。
 *         发送方和接收方不会相互确认数据的传输是否成功。 
 *         存在的意义：效率高，在实时性较强的场合适用。 
 *         示例：发短信
 * 
 *         2.UDP编程 java.net.DatagramSocket（想象成传真机）
 *         java.net.DatagramPacket（想象成传真机上的纸）
 * 
 *         3.UDP编程的核心思路 
 *         a) 服务器端 DatagramSocket socket = newDatagramSocket(9000); 
 *         b) 客户端 DatagramSocket socket = newDatagramSocket(); 
 *         客户端不用端口号 端口号和协议相关 本机TCP和UDP可以使用相同的端口号
 * 
 *         4. DatagramPacket DatagramPacket(byte[] buf, int offset,int length);
 *         DatagramPacket(byte[] buf, int offset,int length,SocketAddress);
 *         SocketAddress：接口 使用时用它的实现类 InetSocketAddress
 *         getAddress()/getSoketAddress()/getPort()/getLength()
 *         setAddress()/setSoketAddress()/setPort()/setLength()
 *
 */
public class UdpSocket {

	public UdpSocket() {

	}

	public static void main(String[] args) throws Exception {

		new UdpSocket().UdpReadServet();
		new UdpSocket().UdpReadKehuduan();
	}

	/**
	 * 
	 * @Author: yzh
	 * @FullName: UdpSocket.java
	 * @Description: UDP 服务器端 完成读写
	 * @Create Date: 2015-8-20
	 */
	private void UdpReadServet() {
		try {
			DatagramSocket socket;
			socket = new DatagramSocket(9011);
			byte[] buf = new byte[100];
			DatagramPacket paper = new DatagramPacket(buf, 0, buf.length);
			socket.receive(paper);
			String str = new String(buf, 0, paper.getLength());
			System.out.println(str);

			byte[] data = "hello client".getBytes();
			DatagramPacket packet = new DatagramPacket(data, 0, data.length,
					paper.getSocketAddress());
			socket.send(packet);
			socket.close();
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	/**
	 * 
	 * @Author: yzh
	 * @FullName: UdpSocket.java
	 * @Description: UDP 客户端 完成读写
	 * @Create Date: 2015-8-20
	 */
	private void UdpReadKehuduan() throws IOException {
		DatagramSocket socket = new DatagramSocket();
		String str = "hello server";
		byte[] data = str.getBytes();
		DatagramPacket packet = new DatagramPacket(data, 0, data.length,
				new InetSocketAddress("127.0.0.1", 9000));
		socket.send(packet);

		byte[] buf = new byte[100];
		DatagramPacket paper = new DatagramPacket(buf, 0, buf.length);
		socket.receive(paper);
		String msg = new String(buf, 0, paper.getLength());
		System.out.println(msg);
		socket.close();
	}
}
