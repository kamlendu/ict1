/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

//import com.sun.xml.rpc.processor.modeler.j2ee.xml.string;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
//@LocalBean
public class PublishBean implements PublishBeanLocal{
@PersistenceContext(unitName = "PublishPU")
EntityManager em;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

public Collection<Customer> getCustomers()
{
    Collection<Customer> custs =  (Collection<Customer>) em.createNamedQuery("Customer.findAll").getResultList();
    return custs;
}

public Collection<Address> getAddresses(Integer custId)
{
     Customer c = (Customer)em.find(Customer.class, custId);
     Collection<Address> adds = c.getAddressCollection();
     return adds;
}

public Collection<Subscription> getAllSubscriptions(Integer custId)
{
    Customer c = (Customer)em.find(Customer.class, custId);
    Collection<Subscription> subs = c.getSubscriptionCollection();
    return subs;
}



public void addCustomer(String fname, String lname)
{
    Customer c = new Customer();
    c.setFirstName(fname);
    c.setLastName(lname);
    em.persist(c);
}

public void removeCustomer(Integer custId)
{
 Customer c = (Customer)em.find(Customer.class, custId);
 em.remove(c);
}
public void AddAddressToCustomer(String street, String city, String state, String zip, Integer id)
{
     Customer c = (Customer)em.find(Customer.class, id);
    Collection<Address> addressCollection = c.getAddressCollection();
    Address a = new Address();
    a.setStreet(street); a.setState(state); a.setCity(city);a.setZip(zip);
    a.setCustomerId(c);
    addressCollection.add(a);
    c.setAddressCollection(addressCollection);
    em.persist(a);
    em.merge(c);
    
    
}
public void removeAddressFromCustomer(Integer addressId, Integer custId)
{
    Address a = (Address)em.find(Address.class, addressId);
    Customer c = (Customer)em.find(Customer.class, custId);
    Collection<Address> addressCollection = c.getAddressCollection();
    if(addressCollection.contains(a))
    {
      addressCollection.remove(a);
      c.setAddressCollection(addressCollection);
      em.remove(a);
      em.merge(c);
    }
}
    public void addTitlesToCustomers(Integer custId, Collection<Integer> ids)
    {
          Customer c = (Customer)em.find(Customer.class, custId);
          Collection<Subscription> subs = c.getSubscriptionCollection();
          for(Integer sid : ids)
          {
              Subscription s = (Subscription)em.find(Subscription.class, sid);
              if(!subs.contains(s))
              {
                  Collection<Customer> custs = s.getCustomerCollection();
                  subs.add(s);
                  custs.add(c);
                  c.setSubscriptionCollection(subs);
                  s.setCustomerCollection(custs);
                  em.merge(c);
                  
              }
          }
    }
         public void removeTitlesToCustomers(Integer custId, Collection<Integer> ids)
    {
          Customer c = (Customer)em.find(Customer.class, custId);
          Collection<Subscription> subs = c.getSubscriptionCollection();
          for(Integer sid : ids)
          {
              Subscription s = (Subscription)em.find(Subscription.class, sid);
              if(subs.contains(s))
              {
                  Collection<Customer> custs = s.getCustomerCollection();
                  subs.remove(s);
                  custs.remove(c);
                  c.setSubscriptionCollection(subs);
                  s.setCustomerCollection(custs);
                  em.merge(c);
                  
              }
          }
    }
    
    




}
