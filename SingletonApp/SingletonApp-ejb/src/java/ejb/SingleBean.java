/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import java.util.concurrent.TimeUnit;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.ejb.AccessTimeout;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.DependsOn;
import javax.ejb.Singleton;
import javax.ejb.LocalBean;
import javax.ejb.Lock;
import javax.ejb.LockType;
import javax.ejb.Startup;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.transaction.UserTransaction;

/**
 *
 * @author root
 */
@TransactionManagement(TransactionManagementType.BEAN)
@ConcurrencyManagement(ConcurrencyManagementType.BEAN)
@AccessTimeout(value = 30, unit = TimeUnit.SECONDS)
@Singleton
@LocalBean
@Startup
@DependsOn({"FirstBean", "SecondBean"})
public class SingleBean {
    
    @Resource UserTransaction utx;

    String firstName;
    String lastName;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
@PostConstruct
public void initialize()
{
    this.firstName= "MSc";
    this.lastName= "ICT";
    System.out.println("Hello from Single Bean !!");
}
    @Lock(LockType.READ)
    public String getFirstName() {
        return firstName;
    }
    
    @Lock(LockType.WRITE)
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Lock(LockType.READ)
    public String getLastName() {
        return lastName;
    }
    @Lock(LockType.WRITE)
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public String joinNames()
    {
        String fullName="";
        try{
            utx.begin();
        fullName = firstName + "  "+ lastName;
        utx.commit();
        }
        catch(Exception e)
        {
            try{
            utx.rollback();
            }
            catch(Exception transact)
            {
                transact.printStackTrace();
            }
        }
       
        return  fullName;
    }


}
