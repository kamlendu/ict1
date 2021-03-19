/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author root
 */
@WebService(serviceName = "TestService")
public class TestService {
    

    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
       
        return "Hello " + txt + " !";
    }
    
    @WebMethod(operationName = "specialHello")
    public String specialHello(@WebParam(name = "greet") String greeting) {
       
        return "Welcome " + greeting + " !";
    }
    
}
