/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
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
}
