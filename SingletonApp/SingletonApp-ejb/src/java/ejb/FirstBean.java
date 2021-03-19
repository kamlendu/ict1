/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;

/**
 *
 * @author root
 */
@Singleton
@LocalBean
public class FirstBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PostConstruct
public void initialize()
{
  
    System.out.println("Hello from First Bean !!");
}

}
