/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class HelloBean implements HelloBeanLocal {

    @Override
    public String sayHello(String name) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
      return "Hello World of EJB from "+ name +" !";
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
