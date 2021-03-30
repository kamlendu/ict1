/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import client.PublishClient;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@WebServlet(name = "PublishingRestServlet", urlPatterns = {"/PublishingRestServlet"})
public class PublishingRestServlet extends HttpServlet {
    
    PublishClient client;
    Response res;
    Collection<Customer> customers;
    GenericType<Collection<Customer>> gcustomers;
    Collection<Address> addresses;
    GenericType<Collection<Address>> gaddresses;
    Collection<Subscription> subs;
    GenericType<Collection<Subscription>> gsubs;
    
    
    
    
    

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
            out.println("<title>Servlet PublishingRestServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            String username = request.getSession().getAttribute("username").toString();
            String password = request.getSession().getAttribute("password").toString();
            
            client = new PublishClient(username,password);
            customers = new ArrayList<Customer>();
            gcustomers = new GenericType<Collection<Customer>>(){};
            addresses = new ArrayList<Address>();
            gaddresses = new GenericType<Collection<Address>>(){};
            subs = new ArrayList<Subscription>();
            gsubs = new GenericType<Collection<Subscription>>(){};
           
          // client.createCustomer("Harish", "Patel");
           //client.addAddressToCustomer("One Street", "Manglore", "Karnataka","234123", "20");
           //client.addAddressToCustomer("Second Street", "Chennai", "Tamilnadu","312342", "20");
          //client.removeAddressFromCustomer("19", "20");

            // Collection<Integer> ids = new ArrayList<Integer>();
           //ids.add(1);
          // ids.add(2);
           //ids.add(3);
          // client.addSubscriptionsToCustomers_JSON(ids, "20");
           // client.removeSubscriptionsFromCustomers_JSON(ids, "20");
            
            
            res = client.getAllCustomers_JSON(Response.class);
            if(res.getStatus()==403)
            {
                getServletContext().getRequestDispatcher("/loginError.jsp").forward(request, response);
            }
            
            customers = res.readEntity(gcustomers);
            
            for(Customer c : customers)
            {
                out.println("<h2> custID= "+ c.getCustomerID() + " Name = "+ c.getFirstName()+" "+ c.getLastName()+"</h2>");
            
                res = client.getAddressesOfCustomer_JSON(Response.class, c.getCustomerID().toString());
                addresses = res.readEntity(gaddresses);
                for(Address a : addresses)
                {
                     out.println("<h2> AddressID= "+ a.getAddressId() + " Street = "+ a.getStreet() +" City =  "+ a.getCity()+ " State = "+ a.getState() +"</h2>");
            
                }
                
                res = client.getSubscriptionsOfCustomer_JSON(Response.class, c.getCustomerID().toString());
                subs = res.readEntity(gsubs);
                for(Subscription s : subs)
                {
                     out.println("<h2> SubID= "+ s.getSubscriptionId() + " Title = "+ s.getTitle()+" Type = "+ s.getType()+"</h2>");
            
                }
                
                out.println("<hr/>");
            
            }
            
            
            out.println("<h1>Servlet PublishingRestServlet at " + request.getContextPath() + "</h1>");
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

}
