/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Remote;

/**
 *
 * @author root
 */
@Remote
public interface CalculationBeanRemote {
    
    int product(int x, int y);
    int div(int x, int y);
     int sum(int x, int y);
    int diff(int x, int y);
}
