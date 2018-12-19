package com.iofs.loanmanagementsystem.utils.queue;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.Connection;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;

public class IofsNormalJmsConsumer implements IofsJmsConsumer {

	final static String CLASS = IofsNormalJmsConsumer.class.getSimpleName();
	
    protected MessageConsumer messageConsumer;

    @Override
    public Message receiveMessage(Session session, Queue queue) throws JMSException {
    	final String METHOD = "receiveMessage";
    	Logger logger = Logger.getLogger(CLASS);
    	logger.entering(CLASS, METHOD);
    	
    	logger.exiting(CLASS, METHOD);    	
    	return getConsumer(session, queue).receiveNoWait();
    }

    private MessageConsumer getConsumer(
    							Session session, 
    							Queue queue) throws JMSException {
    	final String METHOD = "getConsumer";
    	Logger logger = Logger.getLogger(CLASS);
    	logger.entering(CLASS, METHOD);
    	
    	if (messageConsumer == null) {
            messageConsumer = session.createConsumer(queue);
        }
    	logger.exiting(CLASS, METHOD);
        return messageConsumer;
    }

    @Override
    public void close() {
    	final String METHOD = "close";
    	Logger logger = Logger.getLogger(CLASS);
    	logger.entering(CLASS, METHOD);
        if (messageConsumer != null) {
            try {
                messageConsumer.close();
            } catch (JMSException e) {
                logger.log(Level.WARNING, "Error closing consumer: " + e.getMessage());
            } catch (Throwable te) {
                logger.log(Level.SEVERE, "Unexpected error closing consumer: " + te.getMessage(), te);
            } finally {
                messageConsumer = null;
            }
        }
    }

	@Override
	public void onException(JMSException arg0) {
		// TODO Auto-generated method stub
		
	}
	
    public void createRecieveTask() {
        Logger logger = Logger.getLogger(CLASS);
        Runnable recTask = () -> {
            try {
                ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory("tcp://localhost:61616");
                Connection connection = connectionFactory.createConnection();
                connection.start();
                connection.setExceptionListener(this);
                Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
                Destination destination = session.createQueue("IofsLoanManagementQueue");
                MessageConsumer consumer = session.createConsumer(destination);
                Message message = consumer.receive(4000);
                if (message instanceof TextMessage) {
                    TextMessage textMessage = (TextMessage) message;
                    String text = textMessage.getText();
                   logger.info("Received TextMessage object: " + text);
                } else {
                    logger.info("Received other object type with message: " + message);
                }
                consumer.close();
                session.close();
                connection.close();
            } catch (JMSException e) {
                logger.log(Level.SEVERE,"Reciver createRecieveTask method error", e);
            }
        };
        new Thread(recTask).start();
    }
}
