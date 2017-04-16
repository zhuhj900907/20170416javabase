package com.zzbj_04.blockqueue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Test {
	public static void main(String[] args) {
		BlockingQueue<String> queue = new LinkedBlockingQueue<String>(2);
		Consumer consumer = new Consumer(queue);
		Producer producer = new Producer(queue, "A");
		for (int i = 0; i < 3; i++) {
			new Thread(producer, "Producter" + (i + 1)).start();
		}
		for (int j = 0; j < 5; j++) {
			new Thread(consumer, "Consumer" + (j + 1)).start();

		}
		new Thread(producer, "Producter" + 5).start();
	}
}
