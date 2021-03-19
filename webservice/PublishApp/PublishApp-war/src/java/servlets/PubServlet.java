/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.PublishService_Service;
import client.Address;
import client.Customer;
import client.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author root
 */
@WebServlet(name = "PubServlet", urlPatterns = {"/PubServlet"})
public class PubServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "http://localhost:8080/PublishService/PublishService?wsdl")
    private PublishService_Service service;
    client.PublishService pbl;
    
   

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PubServlet</title>");            
            out.println("</head>");
            out.println("<body>");
          
             pbl = service.getPublishServicePort();
            
          //  pbl.createCustomer("Narendra", "Rawat");
          ///  pbl.addAddressToCustomer("OW-234", "Jammu", "UT of JandK", "432", 17);
           // pbl.addAddressToCustomer("X-1", "Chandigarh", "Punjab", "52343", 17);
        
          //  pbl.removeAddressFromCustomer(14,17);
          List<Integer> ids = new ArrayList<Integer>();
          ids.add(3);
          //ids.add(4);
          ids.add(5);
          pbl.removeSubscriptionsFromCustomers(17, ids);
          //pbl.addSubscriptionsToCustomers(17, ids);
          
            Collection<Customer> customers = pbl.getAllCustomers();
            for(Customer c : customers)
            {
               out.println("<h2>Cust Id = " + c.getCustomerID()+ " Name = "+ c.getFirstName()+ " "+ c.getLastName()+"</h2>");
               
               Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
               
               for(Address a : addresses)
               {
                 out.println("<h2>Add Id = " + a.getAddressId()+ " City = "+ a.getCity()+ " state = "+ a.getState()+ "</h2>");
                 
                   
               }
               
               Collection<Subscription> subs = pbl.getSubscriptionsOfCustomer(c.getCustomerID());
               
                for(Subscription s : subs)
                {
                    out.println("<h2>Sub Id = " + s.getSubscriptionId()+ " Title = "+ s.getTitle()+ "  Type = "+ s.getType()+ "</h2>");
                 
                }
                
               out.println("<hr>"); 
            }
            
            
            
            out.println("<h1>Servlet PubServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

//    private java.util.List<client.Customer> getAllCustomers() {
//        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
//        // If the calling of port operations may lead to race condition some synchronization is required.
//        client.PublishService port = service.getPublishServicePort();
//        return port.getAllCustomers();
//    }

}
