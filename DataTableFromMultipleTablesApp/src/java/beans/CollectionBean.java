/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import ejb.MultiDataBean;
import general.SubscriptionInfo;
import java.util.Collection;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.Dependent;

/**
 *
 * @author root
 */
@Named(value = "collectionBean")
@Dependent
public class CollectionBean {
    @EJB MultiDataBean mb;
    
    Collection<SubscriptionInfo> subs;

    public Collection<SubscriptionInfo> getSubs() {
        subs = mb.getSubscriptionInfo();
        
        return subs;
    }

    public void setSubs(Collection<SubscriptionInfo> subs) {
        this.subs = subs;
    }

    /**
     * Creates a new instance of CollectionBean
     */
    public CollectionBean() {
    }
    
}
