package com.iofs.loanmanagementsystem.utils.queue;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import java.math.BigInteger;
import java.security.SecureRandom;
import org.apache.activemq.ActiveMQConnectionFactory;

public class IofsJmsSender {

	final static String CLASS = IofsJmsSender.class.getSimpleName();
    private final Logger logger = Logger.getLogger(CLASS);
    
    private SecureRandom random = new SecureRandom();
    public void createTask(){
        String taskName = generateTaskName();
        Runnable sendTask = () -> {
            ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
            Connection connection = null;
            try {
                connection = connectionFactory.createConnection();
                connection.start();
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("IofsLoanManagementQueue");
                MessageProducer producer = session.createProducer(destination);
                producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
                String text = "Hello from: " + taskName + " : " + this.hashCode();
                TextMessage message = session.createTextMessage(text);
                logger.info("Sent message hash code: "+ message.hashCode() + " : " + taskName);
                producer.send(message);
                session.close(); 
                connection.close();
            } catch (JMSException e) {
                logger.log(Level.SEVERE, "Sender createTask method error", e);
            }
        };
        new Thread(sendTask).start();
    }
    
    private String generateTaskName() {
        return new BigInteger(20, random).toString(16);
    }
}