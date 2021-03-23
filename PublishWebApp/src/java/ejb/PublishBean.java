/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    
    @PersistenceContext(unitName = "ictpu")
    EntityManager em;
    
    @Override
    public Collection<Customer> getAllCustomers() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Customer> customers = em.createNamedQuery("Customer.findAll").getResultList();
    return customers;
    }

    @Override
    public Collection<Customer> getCustomersByFirstName(String fname) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Collection<Customer> customers = em.createNamedQuery("Customer.findByFirstName")
            .setParameter("firstName", fname)
            .getResultList();
    return customers;
    }

    @Override
    public Collection<Customer> getCustomersByLastName(String lname) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Address> getAddressesOfCustomer(Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    Collection<Address>  addresses = c.getAddressCollection();
    return addresses;
    }

    @Override
    public Collection<Subscription> getSubscriptionsOfCustomer(Integer custId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    return subs;
    
    
    }

    @Override
    public Collection<Customer> getCustomersOfTitle(Integer subId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Subscription s = em.find(Subscription.class, subId);
    Collection<Customer> customers = s.getCustomerCollection();
    
    return customers;
    }

    @Override
    public Collection<Subscription> getAllSubscriptions() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void createCustomer(String fname, String lname) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     Customer c = new Customer();
     c.setFirstName(fname);
     c.setLastName(lname);
     
     em.persist(c);
     
    }

    @Override
    public void updateCustomer(Integer custId, String fname, String lname) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    c.setFirstName(fname);
    c.setLastName(lname);
    
    em.merge(c);
    
    }

    @Override
    public void removeCustomer(Integer custId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    
    em.remove(c);
    
    }

    @Override
    public void addAddressToCustomer(String street, String city, String state, String zip, Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    Address a = new Address();
    a.setStreet(street);
    a.setCity(city);
    a.setState(state);
    a.setZip(zip);
    a.setCustomerId(c);
    Collection<Address> addresses = c.getAddressCollection();
    addresses.add(a);
    c.setAddressCollection(addresses);
    em.persist(a);
    em.merge(c);
   
    }

    @Override
    public void removeAddressFromCustomer(Integer addressId, Integer custId) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Customer c = em.find(Customer.class, custId);
    Address a = em.find(Address.class, addressId);
    
    Collection<Address> addresses = c.getAddressCollection();
    if(addresses.contains(a))
    {
        addresses.remove(a);
        c.setAddressCollection(addresses);
        em.remove(a);
        em.merge(c);
    }
    
    
    }

    @Override
    public void addSubscriptionsToCustomers(Integer custId, Collection<Integer> ids) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Customer c = em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    for(Integer sid : ids)
    {
        Subscription s = em.find(Subscription.class, sid);
        
        if(!subs.contains(s))
        {
           Collection<Customer> custs = s.getCustomerCollection();
           custs.add(c);
           subs.add(s);
           c.setSubscriptionCollection(subs);
           s.setCustomerCollection(custs);
           
           em.merge(c);
            
            
            
        }
        
    }
    
  
    }

    @Override
    public void removeSubscriptionsFromCustomers(Integer custId, Collection<Integer> ids) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Customer c = em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    
    for(Integer sid : ids)
    {
        Subscription s = em.find(Subscription.class, sid);
        
        if(subs.contains(s))
        {
           Collection<Customer> custs = s.getCustomerCollection();
           custs.remove(c);
           subs.remove(s);
           c.setSubscriptionCollection(subs);
           s.setCustomerCollection(custs);
           
           em.merge(c);
            
            
            
        }
        
    }
    
    
    }

    @Override
    public void addNewSubscription(String title, String type) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    
    }

    @Override
    public void updateSubscription(Integer subId, String title, String type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void removeSubscription(Integer subId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<Subscription> findSubscriptionsByTitle(String title) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}
