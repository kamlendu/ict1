/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import client.BookRestClient;
import entity.BookMaster;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author root
 */
@Named(value = "cust")
@RequestScoped
public class BookCDIBean {
    //@EJB DataSessionBeanLocal dbl;
    Response res;
    String username;
    String password;
    BookRestClient brc;
    Collection<BookMaster> books;
    GenericType<Collection<BookMaster>> gbooks;

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

    public BookRestClient getBrc() {
        return brc;
    }

    public void setBrc(BookRestClient brc) {
        this.brc = brc;
    }

    public Collection<BookMaster> getBooks() {
        System.out.println("In get books");
        res = brc.getBooks(Response.class);
        System.out.println(res);
        //res.
        books = res.readEntity(gbooks);
        //books = dbl.getAllBooks();
        System.out.println(books);
        return books;
    }

    public void setBooks(Collection<BookMaster> books) {
        this.books = books;
    }

//    public GenericType<Collection<BookMaster>> getGbooks() {
//        return gbooks;
//    }
//
//    public void setGbooks(GenericType<Collection<BookMaster>> gbooks) {
//        this.gbooks = gbooks;
//    }
//    
    

    /**
     * Creates a new instance of BookCDIBean
     */
    public BookCDIBean() {
        System.out.println("Hello BookCDI Bean ");
          HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
       String token="";

        token = request.getSession().getAttribute("token").toString();
       System.out.println("Token="+token);
        
        //String token1 = request.getHeader("Authorization").substring("Bearer ".length());
      // System.out.println("Token="+token);
        brc = new BookRestClient(token);
           
      // brc = new BookRestClient(username, password);
        books = new ArrayList<BookMaster>();
        gbooks = new GenericType<Collection<BookMaster>>(){};
        
    }
    
}
