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
@Path("test")
public class ITResource {
    

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of ITResource
     */
    public ITResource() {
    }

   
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String sayHello()
    {
        return "<h1> Hello World of Rest</h1>\n";
    }
    
     @GET
     @Path("special/{sname}")
    @Produces(MediaType.TEXT_HTML)
    public String saySpecialHello(@PathParam("sname")   String somename)
    {
        return "<h1> Special Hello World of Rest to " + somename+ "</h1>\n";
    }
    
   
    
    @POST
    @Path("cnames")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<String> getUnames(Collection<String> lnames)
    {
        Collection<String> unames = new ArrayList<String>();
        for(String s: lnames)
        {
            unames.add(s.toUpperCase());
        }
        
        return unames;
    }
    
    
}
