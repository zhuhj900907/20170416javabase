package com.zzbj_07.activemq;

import java.util.Random;

import javax.jms.JMSException;

public class ProducerTest {
	public static void main(String[] args) throws InterruptedException, JMSException {
		ProducerTool producer  = new ProducerTool();
		Random random = new Random();
		for(int i=0; i<20 ;i++)
		{
			Thread.sleep(random.nextInt(10) * 1000);
			producer.produceMsg("Hello,world!>>"+i);
			producer.close();
		}
	}
}
