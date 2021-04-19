/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.util.Set;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import static javax.faces.application.FacesMessage.SEVERITY_ERROR;
import javax.inject.Named;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.security.enterprise.AuthenticationStatus;
import static javax.security.enterprise.AuthenticationStatus.SEND_CONTINUE;
import javax.security.enterprise.SecurityContext;
import static javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters.withParams;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author root
 */
@Named(value = "loginBean")
@RequestScoped
 public class LoginBean {
    
    @Inject private SecurityContext securityContext;

    private String username;
    private String password;
    private String message;
    private AuthenticationStatus status;
   private Set<String> roles;

    public SecurityContext getSecurityContext() {
        return securityContext;
    }

    public Set<String> getRoles() {
        return roles;
    }

    public void setRoles(Set<String> roles) {
        this.roles = roles;
    }

    public void setSecurityContext(SecurityContext securityContext) {
        this.securityContext = securityContext;
    }

    public AuthenticationStatus getStatus() {
        return status;
    }

    public void setStatus(AuthenticationStatus status) {
        this.status = status;
    }
    
    /** AuthenticationStatus status= securityContext.authenticate(request, response, 
//                                   withParams().credential(creden
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

     public void setPassword(String password) {
        this.password = password;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
    
   public String login()
    {
        FacesContext context = FacesContext.getCurrentInstance();
        try{
        
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
      
        request.getSession().setAttribute("logged-group", ""); 
        
        Credential credential = new UsernamePasswordCredential(username, new Password(password));
        AuthenticationStatus status= securityContext.authenticate(request, response, withParams().credential(credential));
                                           
     
       if (status.equals(SEND_CONTINUE)) {
            // Authentication mechanism has send a redirect, should not
            // send anything to response from JSF now. The control will now go into HttpAuthenticationMechanism
            context.responseComplete();
       } 
       
 
         System.out.println("In bean");
         if(roles.contains("Admin"))
           {
               System.out.println("In admin");
               request.getSession().setAttribute("logged-group", "Admin");
              return "/admins/AdminPage.jsf";
           }
        //   else if(securityContext.isCallerInRole("Supervisor"))
       else if(roles.contains("Supervisor"))
           {
               System.out.println("In supervisor");
               request.getSession().setAttribute("logged-group", "Supervisor");
               return "/users/UserPage.jsf";
           }
        
       //} 
       
       
        }
        catch (Exception e)
        {
             message = "Out- Either user or login is wrong !!!";
           //   e.printStackTrace();
        }
//        
      return "/Login.jsf";
    }
   
   private static void addError(FacesContext context, String message) {
        context = FacesContext.getCurrentInstance();
        context
                .addMessage(
                        null,
                        new FacesMessage(SEVERITY_ERROR, message, null));
    }
   public String logout() throws ServletException
   {
       System.out.println("In Log out");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
          request.getSession().setAttribute("logged-group", "");
           request.logout();
          request.getSession().invalidate();
         
          
          return "/Login.jsf";
             
             }
    
}
