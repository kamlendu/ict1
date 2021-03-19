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
    @ActivationConfigProperty(propertyName = "destinationLookup", propertyValue = "jms/ictqueue"),
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class FirstQueueBean implements MessageListener {
    String msg;
    public FirstQueueBean() {
    }
    
    @Override
    public void onMessage(Message message) {
        try{
            
            if(message instanceof TextMessage)
            {
                 msg = ((TextMessage) message).getText().toString();
            }
           
            System.out.println("First Queue Bean got message : " + msg);
        }
        catch(Exception e)
        {
            
        }
        
    }
    
}
