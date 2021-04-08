/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import entity.Projectgroups;
import entity.ProjectgroupsPK;
import entity.Projectusers;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.glassfish.soteria.identitystores.hash.Pbkdf2PasswordHashImpl;

/**
 *
 * @author root
 */
@Stateless
public class UserBean {
    @PersistenceContext(unitName = "ictpu")
    EntityManager em;
    private Pbkdf2PasswordHashImpl pb;
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

public void addUserAndGroup(String user, String password, String group)
{
    pb = new Pbkdf2PasswordHashImpl();
    String  encryptedpassword = pb.generate(password.toCharArray());
    Projectusers pu = new Projectusers(user, encryptedpassword);
    em.persist(pu);
    
    Projectgroups pg = new Projectgroups();
    pg.setProjectgroupsPK(new ProjectgroupsPK(group,user));
    pg.setProjectusers(pu);
    em.persist(pg);
    
     
}


}
