package com.iofs.loanmanagementsystem.utils.queue;

import javax.jms.ExceptionListener;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Queue;
import javax.jms.Session;

public interface IofsJmsConsumer extends ExceptionListener{
    Message receiveMessage(Session session, Queue queue) throws JMSException;
    void close();
}