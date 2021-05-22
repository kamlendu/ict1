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
import javax.ejb.Local;

/**
 *
 * @author root
 */
@Local
public interface PublishBeanLocal {

    Collection<Customer> getCustomers();

    Collection<Address> getAddresses(Integer custId);

    Collection<Subscription> getAllSubscriptions(Integer custId);

    void addCustomer(String fname, String lname);

    void removeCustomer(Integer custId);

    void AddAddressToCustomer(String street, String city, String state, String zip, Integer id);

    void removeAddressFromCustomer(Integer addressId, Integer custId);

    void addTitlesToCustomers(Integer custId, Collection<Integer> ids);

    void removeTitlesToCustomers(Integer custId, Collection<Integer> ids);
    

}
