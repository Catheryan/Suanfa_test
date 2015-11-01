package com.test.seversocket;

import java.util.Vector;

public class ChatManager {
	private ChatManager() {
	}

	private volatile static ChatManager cm = null;

	public static ChatManager getChatManager() {
		if (cm == null) {
			synchronized (ChatManager.class) {
				if (cm == null) {
					cm = new ChatManager();
				}
			}
		}
		return cm;
	}

	Vector<ChatSocket> vector = new Vector<ChatSocket>();

	public void add(ChatSocket cs) {
		vector.add(cs);
	}

	public void publish(ChatSocket cs, String out) {

		for (int i = 0; i < vector.size(); i++) {
			ChatSocket csChatSocket = vector.get(i);
			if (!cs.equals(csChatSocket)) {
				csChatSocket.out(out);
			}
		}
	}
}
