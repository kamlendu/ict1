/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.PublishBeanLocal;
import entity.Address;
import entity.Customer;
import entity.Subscription;
import gen.GujCust;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "PubServlet", urlPatterns = {"/PubServlet"})
public class PubServlet extends HttpServlet {
    
    @EJB PublishBeanLocal pbl;

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
            
          //  pbl.createCustomer("Shashikant", "Shah");
          //  pbl.addAddressToCustomer("One street", "Chennai", "Tamilnadu", "34532", 16);
          //pbl.removeAddressFromCustomer(13,16);
         // Collection<Integer> ids = new ArrayList<Integer>();
          //ids.add(3);
          //ids.add(4);
          //ids.add(5);
          //pbl.removeSubscriptionsFromCustomers(16, ids);
         // pbl.addSubscriptionsToCustomers(16, ids);
   
         
         out.println("<h3><br/>Result of First Dynamic Query method <br/> ");
         Collection<Address> GujAddresses =  pbl.getAdressOfCityAndState("surat", "Gujarat");
       //  System.out.println("Gujarat="+GujAddresses);
      for(Address a : GujAddresses)
      {
      
          out.println("<br/>Street= "+ a.getStreet() +" city=  " + a.getCity() + " state="+ a.getState());
      }
        out.println("<hr/>"); 
         
         out.println("<br/>Result of Native Query method <br/>");
         List<GujCust> Gujustomers =  pbl.getAddressFromGujarat();
        // System.out.println("Gujarat="+Gujustomers);
      for(GujCust o : Gujustomers)
      {
      
          out.println("<br/> Name "+ o.getFirstName() +" state= " +o.getState());
      }
         
         out.println("<hr/>"); 
         
         out.println("<br/>Result of Second Dynamic Query method <br/>");
         List<GujCust> Gujcustomers =  pbl.getAddressOfCustomersFromGujarat();
       
      for(GujCust o : Gujcustomers)
      {
      
          out.println("<br/>Name "+ o.getFirstName() +" State " +o.getState());
      }
         
         
         System.out.println("</h3><hr/>");
//            Collection<Customer> customers = pbl.getAllCustomers();
//            for(Customer c : customers)
//            {
//               out.println("<h2>Cust Id = " + c.getCustomerID()+ " Name = "+ c.getFirstName()+ " "+ c.getLastName()+"</h2>");
//               
//               Collection<Address> addresses = pbl.getAddressesOfCustomer(c.getCustomerID());
//               
//               for(Address a : addresses)
//               {
//                 out.println("<h2>Add Id = " + a.getAddressId()+ " City = "+ a.getCity()+ " state = "+ a.getState()+ "</h2>");
//                 
//                   
//               }
//               
//               Collection<Subscription> subs = pbl.getSubscriptionsOfCustomer(c.getCustomerID());
//               
//                for(Subscription s : subs)
//                {
//                    out.println("<h2>Sub Id = " + s.getSubscriptionId()+ " Title = "+ s.getTitle()+ "  Type = "+ s.getType()+ "</h2>");
//                 
//                }
//                
//               out.println("<hr>"); 
//            }
//            
//            
            
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

}
