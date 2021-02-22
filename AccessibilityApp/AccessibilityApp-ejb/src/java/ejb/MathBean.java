/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Stateless;

/**
 *
 * @author root
 */
@Stateless
public class MathBean implements MathBeanLocal {

    @Override
    public int sum(int x, int y) {
      //  throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
        return x+y;
    
    }

    @Override
    public int diff(int x, int y) {
   //     throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return x-y;
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



}
