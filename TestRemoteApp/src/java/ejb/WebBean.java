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
public class WebBean {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public String upperCase(String str)
    {
        return str.toUpperCase();
    }


}
