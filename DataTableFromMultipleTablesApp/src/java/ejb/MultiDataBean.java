/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import general.SubscriptionInfo;
import java.util.ArrayList;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class MultiDataBean {

    @EJB
    PublishBeanLocal pb;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public Collection<SubscriptionInfo> getSubscriptionInfo() {

        Collection<SubscriptionInfo> subinfocoll = new ArrayList<SubscriptionInfo>();
        Collection<Customer> customers = pb.getCustomers();
        for (Customer c : customers) {
            String alladdresses = "";
            SubscriptionInfo sinfo = new SubscriptionInfo();
            Integer cid = c.getCustomerID();
            Collection<Subscription> subs = pb.getAllSubscriptions(cid);
            Collection<Address> addresses = pb.getAddresses(cid);
            for (Subscription s : subs) {
                sinfo.setCustomerName(c.getFirstName());
                sinfo.setTitle(s.getTitle());
                sinfo.setType(s.getType());
                for (Address adress : addresses) {
                    alladdresses += adress.getStreet() + " " + adress.getCity() + " " + adress.getState()+" :: ";
                }
                sinfo.setAddress(alladdresses);

                subinfocoll.add(sinfo);

            }

        }

        return subinfocoll;
    }

}
