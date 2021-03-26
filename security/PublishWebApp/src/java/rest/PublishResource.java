/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.util.Collection;
import javax.ejb.EJB;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Path;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("publishing")
@RequestScoped
public class PublishResource {
    
    @EJB PublishBeanLocal pb;

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of PublishResource
     */
    public PublishResource() {
    }

     @GET
     @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public Collection<Customer> getAllCustomers() {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
     
    Collection<Customer> customers = pb.getAllCustomers();
    return customers;
    }

    
      @GET
      @Path("custbyfirstname/{fname}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
      
    public Collection<Customer> getCustomersByFirstName(@PathParam("fname") String fname) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Customer> customers = pb.getCustomersByFirstName(fname);
    return customers;
    }

    
    
     @GET
      @Path("getaddresses/{cid}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    
    public Collection<Address> getAddressesOfCustomer(@PathParam("cid") Integer custId) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   Collection<Address> addresses = pb.getAddressesOfCustomer(custId);
    return addresses;
    }

     @GET
      @Path("getsubs/{cid}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})  
    public Collection<Subscription> getSubscriptionsOfCustomer(@PathParam("cid") Integer custId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    Collection<Subscription> subs = pb.getSubscriptionsOfCustomer(custId);
    return subs;
    
    
    }

     @GET
      @Path("getcustbytitle/{sid}")
      @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
   
    public Collection<Customer> getCustomersOfTitle(@PathParam("sid") Integer subId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    Collection<Customer> customers = pb.getCustomersOfTitle(subId);
    return customers;
    }

    
    
    @POST
    @Path("createcust/{fname}/{lname}")
    public void createCustomer(@PathParam("fname") String fname, @PathParam("lname") String lname) {
     //   throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
            pb.createCustomer(fname, lname);
            
    }

    @PUT
    @Path("updatecust/{cid}/{fname}/{lname}")
    public void updateCustomer(@PathParam("cid") Integer custId,@PathParam("fname")  String fname,@PathParam("lname")  String lname) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
        pb.updateCustomer(custId, fname, lname);
    
    }

    @DELETE
    @Path("removecust/{cid}")
    public void removeCustomer(@PathParam("cid") Integer custId) {
    //    throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
    pb.removeCustomer(custId);
    }

    @POST
    @Path("addaddress/{street}/{city}/{state}/{zip}/{cid}")
    public void addAddressToCustomer(@PathParam("street") String street,@PathParam("city")  String city, @PathParam("state")  String state, @PathParam("zip") String zip, @PathParam("cid") Integer custId) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
   
      pb.addAddressToCustomer(street, city, state, zip, custId);
   
    }

    @DELETE
    @Path("remaddress/{aid}/{cid}")
    public void removeAddressFromCustomer(@PathParam("aid") Integer addressId,@PathParam("cid")  Integer custId) {
 //       throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
             pb.removeAddressFromCustomer(addressId, custId);
    }

    @POST
    @Path("addsubcust/{cid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void addSubscriptionsToCustomers(@PathParam("cid")  Integer custId, Collection<Integer> ids) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
             pb.addSubscriptionsToCustomers(custId, ids);
        
    }
    
  
    

     @POST
    @Path("remsubcust/{cid}")
    @Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public void removeSubscriptionsFromCustomers(@PathParam("cid") Integer custId, Collection<Integer> ids) {
       // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
  
         pb.removeSubscriptionsFromCustomers(custId, ids);
    
    
    }

    @POST
    @Path("addnewsub/{title}/{type}")
    public void addNewSubscription(@PathParam("title") String title, @PathParam("type") String type) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    pb.addNewSubscription(title, type);
    
    }

}
