/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author root
 */
@Path("rest")
public class RestResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of RestResource
     */
    public RestResource() {
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello()
    {
        return "<h1>Hello World of Rest</h1>\n";
    }
    
    @GET
    @Path("special/{fname}")
    @Produces(MediaType.TEXT_HTML)
    public String saySpecialHello(@PathParam("fname") String name)
    {
        return "<h1>Special Hello World of Rest to" + name + "</h1>\n";
    }
    
    
  @POST
  @Path("unames")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
   public Collection<String> getUpperNames(Collection<String> lnames)
    {
        Collection<String> unames = new ArrayList<String>();
        
        for(String s : lnames)
        {
            unames.add(s.toUpperCase());
        }
        
        return unames;
    }
    
    
}
