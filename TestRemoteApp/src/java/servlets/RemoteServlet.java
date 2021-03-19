/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import ejb.CalculationBeanRemote;
import ejb.WebBean;
//import ejb.MathBeanLocal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;
import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@WebServlet(name = "RemoteServlet", urlPatterns = {"/RemoteServlet"})
public class RemoteServlet extends HttpServlet {
    
   // @EJB(mappedName = "ejb/calc")
   // MathBeanLocal mbl;
    @EJB WebBean wb;
    CalculationBeanRemote cbr;
    InitialContext ctx;

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
            out.println("<title>Servlet RemoteServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            out.println("<h2> Ucase : " + wb.upperCase("university") );
          try{
              Properties p = new Properties();
 p.setProperty("org.omg.CORBA.ORBInitialHost", "localhost");
 p.setProperty("org.omg.CORBA.ORBInitialPort", "3700");
              
              ctx = new InitialContext(p);
              cbr = (CalculationBeanRemote) ctx.lookup("ejb/calc");
           //   mbl=(MathBeanLocal)ctx.lookup("java:global/AccessibilityApp/AccessibilityApp-ejb/MathBean");
          }  
          catch(NamingException ne)
          {
             ne.printStackTrace();
          }
        
          
          
            out.println("<h1>Product of 50 and 5 is  " + cbr.product(50, 5) + "</h1>");
            out.println("<h1>Division of 50 and 5 is  " + cbr.div(50, 5) + "</h1>");
  out.println("<h1>Sum of 50 and 5 is  " + cbr.sum(50, 5) + "</h1>");
            out.println("<h1>Diff of 50 and 5 is  " + cbr.diff(50, 5) + "</h1>");

//           out.println("<h1>Addition of 50 and 5 is  " + mbl.sum(50, 5) + "</h1>");
           
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
