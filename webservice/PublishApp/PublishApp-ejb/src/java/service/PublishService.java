/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author root
 */
@WebService(serviceName = "PublishService")
@Stateless()
public class PublishService {

    @EJB
    private PublishBeanLocal ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getAllCustomers")
    public Collection<Customer> getAllCustomers() {
        return ejbRef.getAllCustomers();
    }

    @WebMethod(operationName = "getCustomersByFirstName")
    public Collection<Customer> getCustomersByFirstName(@WebParam(name = "fname") String fname) {
        return ejbRef.getCustomersByFirstName(fname);
    }

    @WebMethod(operationName = "getCustomersByLastName")
    public Collection<Customer> getCustomersByLastName(@WebParam(name = "lname") String lname) {
        return ejbRef.getCustomersByLastName(lname);
    }

    @WebMethod(operationName = "getAddressesOfCustomer")
    public Collection<Address> getAddressesOfCustomer(@WebParam(name = "custId") Integer custId) {
        return ejbRef.getAddressesOfCustomer(custId);
    }

    @WebMethod(operationName = "getSubscriptionsOfCustomer")
    public Collection<Subscription> getSubscriptionsOfCustomer(@WebParam(name = "custId") Integer custId) {
        return ejbRef.getSubscriptionsOfCustomer(custId);
    }

    @WebMethod(operationName = "getCustomersOfTitle")
    public Collection<Customer> getCustomersOfTitle(@WebParam(name = "subId") Integer subId) {
        return ejbRef.getCustomersOfTitle(subId);
    }

    @WebMethod(operationName = "getAllSubscriptions")
    public Collection<Subscription> getAllSubscriptions() {
        return ejbRef.getAllSubscriptions();
    }

    @WebMethod(operationName = "createCustomer")
    @Oneway
    public void createCustomer(@WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname) {
        ejbRef.createCustomer(fname, lname);
    }

    @WebMethod(operationName = "updateCustomer")
    @Oneway
    public void updateCustomer(@WebParam(name = "custId") Integer custId, @WebParam(name = "fname") String fname, @WebParam(name = "lname") String lname) {
        ejbRef.updateCustomer(custId, fname, lname);
    }

    @WebMethod(operationName = "removeCustomer")
    @Oneway
    public void removeCustomer(@WebParam(name = "custId") Integer custId) {
        ejbRef.removeCustomer(custId);
    }

    @WebMethod(operationName = "addAddressToCustomer")
    @Oneway
    public void addAddressToCustomer(@WebParam(name = "street") String street, @WebParam(name = "city") String city, @WebParam(name = "state") String state, @WebParam(name = "zip") String zip, @WebParam(name = "custId") Integer custId) {
        ejbRef.addAddressToCustomer(street, city, state, zip, custId);
    }

    @WebMethod(operationName = "removeAddressFromCustomer")
    @Oneway
    public void removeAddressFromCustomer(@WebParam(name = "addressId") Integer addressId, @WebParam(name = "custId") Integer custId) {
        ejbRef.removeAddressFromCustomer(addressId, custId);
    }

    @WebMethod(operationName = "addSubscriptionsToCustomers")
    @Oneway
    public void addSubscriptionsToCustomers(@WebParam(name = "custId") Integer custId, @WebParam(name = "ids") Collection<Integer> ids) {
        ejbRef.addSubscriptionsToCustomers(custId, ids);
    }

    @WebMethod(operationName = "removeSubscriptionsFromCustomers")
    @Oneway
    public void removeSubscriptionsFromCustomers(@WebParam(name = "custId") Integer custId, @WebParam(name = "ids") Collection<Integer> ids) {
        ejbRef.removeSubscriptionsFromCustomers(custId, ids);
    }

    @WebMethod(operationName = "addNewSubscription")
    @Oneway
    public void addNewSubscription(@WebParam(name = "title") String title, @WebParam(name = "type") String type) {
        ejbRef.addNewSubscription(title, type);
    }

    @WebMethod(operationName = "updateSubscription")
    @Oneway
    public void updateSubscription(@WebParam(name = "subId") Integer subId, @WebParam(name = "title") String title, @WebParam(name = "type") String type) {
        ejbRef.updateSubscription(subId, title, type);
    }

    @WebMethod(operationName = "removeSubscription")
    @Oneway
    public void removeSubscription(@WebParam(name = "subId") Integer subId) {
        ejbRef.removeSubscription(subId);
    }

    @WebMethod(operationName = "findSubscriptionsByTitle")
    public Collection<Subscription> findSubscriptionsByTitle(@WebParam(name = "title") String title) {
        return ejbRef.findSubscriptionsByTitle(title);
    }
    
}
