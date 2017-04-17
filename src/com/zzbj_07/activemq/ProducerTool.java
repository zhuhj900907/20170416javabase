package com.zzbj_07.activemq;

import javax.jms.Connection;  
import javax.jms.ConnectionFactory;  
import javax.jms.DeliveryMode;
import javax.jms.Destination;  
import javax.jms.JMSException;  
import javax.jms.MessageProducer;  
import javax.jms.Session;  
import javax.jms.TextMessage;  
  
import org.apache.activemq.ActiveMQConnection;  
import org.apache.activemq.ActiveMQConnectionFactory;

/***
 * 生产者
 * 
 * @author huijun
 * 
 */
public class ProducerTool {
	private String user = ActiveMQConnection.DEFAULT_USER;
	private String password = ActiveMQConnection.DEFAULT_PASSWORD;
	private String url="tcp://192.168.187.201:61616";
	//private String url = ActiveMQConnection.DEFAULT_BROKER_URL;
	private String subject = "mytopic";
	private Destination destination = null;
	private Connection connection = null;
	private Session session = null;
	private MessageProducer producer = null;

	/***
	 * 初始化连接
	 * 
	 * @throws JMSException
	 */
	private void init() throws JMSException {
		System.out.println(url);
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(user, password, url);
		connection = connectionFactory.createConnection();
		session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
		destination = session.createTopic(subject);
		producer = session.createProducer(destination);
		producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
	}

	/***
	 * 发送消息
	 * 
	 * @param msgstr
	 * @throws JMSException
	 */
	public void produceMsg(String msgstr) throws JMSException {
		init();
		TextMessage msg = session.createTextMessage(msgstr);
		connection.start();
		System.out.println("Procedure:->Send Message----" + msg);
		producer.send(msg);
		System.out.println("Procedure:-> Message send completed!");
	}

	/***
	 * 关闭
	 * 
	 * @throws JMSException
	 */
	public void close() throws JMSException {
		System.out.println("Producer:->close connection!");
		if (producer != null) {
			producer.close();
		}
		if (session != null) {
			session.close();
		}
		if (connection != null) {
			connection.close();
		}
	}
}
