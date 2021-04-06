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
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {

    // Taking data from three tables. This requires customername from customer table,
    //title from subscription and state from address;
    
  // Using Dynamic Query
    Collection<Address> getAdressOfCityAndState(String city, String state);
    
    // Using Dynamic Query
    List<GujCust> getAddressOfCustomersFromGujarat();
    
    // Using Native Query
    List<GujCust> getAddressFromGujarat();
    
    
    
    Collection<Customer> getAllCustomers();

    Collection<Customer> getCustomersByFirstName(String fname);

    Collection<Customer> getCustomersByLastName(String lname);

    Collection<Address> getAddressesOfCustomer(Integer custId);

    Collection<Subscription> getSubscriptionsOfCustomer(Integer custId);

    Collection<Customer> getCustomersOfTitle(Integer subId);

    Collection<Subscription> getAllSubscriptions();

    void createCustomer(String fname, String lname);

    void updateCustomer(Integer custId, String fname, String lname);

    void removeCustomer(Integer custId);

    void addAddressToCustomer(String street, String city, String state, String zip, Integer custId);

    void removeAddressFromCustomer(Integer addressId, Integer custId);

    void addSubscriptionsToCustomers(Integer custId, Collection<Integer> ids);

    void removeSubscriptionsFromCustomers(Integer custId, Collection<Integer> ids);

    void addNewSubscription(String title, String type);

    void updateSubscription(Integer subId, String title, String type);

    void removeSubscription(Integer subId);

    Collection<Subscription> findSubscriptionsByTitle(String title);

}
