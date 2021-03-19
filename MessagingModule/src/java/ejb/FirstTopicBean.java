/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author root
 */
@MessageDriven(activationConfig = {
    @ActivationConfigProperty(propertyName = "clientId", propertyValue = "Client1"),
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/icttopic"),
    @ActivationConfigProperty(propertyName = "subscriptionDurability", propertyValue = "Durable"),
    @ActivationConfigProperty(propertyName = "subscriptionName", propertyValue = "jms/icttopic"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Topic")
})
public class FirstTopicBean implements MessageListener {
    String msg;
    public FirstTopicBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            
            if(message instanceof TextMessage)
            {
                 msg = ((TextMessage) message).getText().toString();
            }
           
            System.out.println("First Topic Bean got message : " + msg);
        }
        catch(Exception e)
        {
            
        }
    }
    
}
