/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Address;
import entity.Customer;
import entity.Subscription;
import gen.GujCust;
import java.util.Collection;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.SqlResultSetMapping;

/**
 *
 * @author root
 */
@Stateless
public class PublishBean implements PublishBeanLocal {
    
    @PersistenceContext(unitName = "ictpu")
    EntityManager em;

    //Example of Dynamic Query
    @Override
    public Collection<Address> getAdressOfCityAndState(String city, String state) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
       Collection<Address> addresses = em.createQuery("select a from Address a where a.city = :city AND a.state = :state")
                                        .setParameter("city", city)
                                        .setParameter("state", state).getResultList();
    
    return addresses;
    }

    
    // Using Native Query and Putting the result in a POJO GujCust
    // See the additional annotation used in Customer entity class
//    @SqlResultSetMapping(name = "PojoExample", 
//  classes = @ConstructorResult(columns = {
//    @ColumnResult(name = "firstName", type = String.class), 
//    @ColumnResult(name = "state", type = String.class)
//  }, 
//  targetClass = GujCust.class)
// )
    @Override
    public List<GujCust> getAddressFromGujarat() {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    Query query = em.createNativeQuery("select FirstName as firstName, State from customer  , address   where customer.CustomerID=address.CustomerId and address.State='Gujarat'"  ,"PojoExample");
   List<GujCust> statewisecustomers = query.getResultList();
    return statewisecustomers;
    }

    
    // Dynamic Queries result to be stored in a POJO GujCust.
    //No annotations required for this
    @Override
    public List<GujCust> getAddressOfCustomersFromGujarat() {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    List<GujCust> custs;
    Query query = em.createQuery("select c.firstName as firstName, a.state as state from Customer c  , Address a   where c=a.customerId and a.state='Gujarat'"  ,GujCust.class);
     custs = new java.util.ArrayList<GujCust>();
     List<GujCust> statewisecustomers = query.getResultList();
    for(Object o : statewisecustomers)
      {
           Object[] obj = (Object[]) o;
           String fname = String.valueOf(obj[0]); // don't know the type of column CLIENT assuming String 
           String state = String.valueOf(obj[1]);
          GujCust g = new GujCust(fname,state);
          custs.add(g);
          // System.out.println("Data "+ fname +"  " +state);
      
          // System.out.println("Data "+ o.getFirstName() +"  " +o.getState());
      }
    return custs;
    }
    
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
