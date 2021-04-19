/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.BookMaster;
import java.util.Collection;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author root
 */
@Stateless
//@DeclareRoles({"Admin","Supervisor"})
public class DataSessionBean implements DataSessionBeanLocal {
    
    @PersistenceContext(unitName = "ejbpu")
    EntityManager em;
    @PostConstruct()
    public void init()
    {
    //  em = Persistence.createEntityManagerFactory("ejbpu").createEntityManager();
    }

    //@PermitAll
    @Override
    public Collection<BookMaster> getAllBooks() {
        System.out.println("In EJB");
    return em.createNamedQuery("BookMaster.findAll").getResultList();
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")


}
