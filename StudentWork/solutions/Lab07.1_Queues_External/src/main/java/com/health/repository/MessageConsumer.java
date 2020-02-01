package com.health.repository;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.health.core.HealthPlan;

@Component
public class MessageConsumer {
	@Autowired private HealthPlanRepository repo;	
	private static Logger logger = Logger.getLogger("MessageConsumer");	
	@JmsListener(destination = "myQueue")
    public void receiveMessage(Message msg) throws JMSException {
		ObjectMessage objMsg = (ObjectMessage) msg;
        HealthPlan plan = (HealthPlan) objMsg.getObject() ;
        logger.log(Level.INFO, "Received Message for Plan " + plan);
        HealthPlan pl = repo.save(plan);
        logger.log(Level.INFO, "Repository updated with Plan " + pl.getId());
    }
}
