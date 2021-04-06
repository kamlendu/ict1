/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gen;

import java.io.Serializable;

/**
 *
 * @author root
 */
public class GujCust implements Serializable {

    public GujCust(String firstName, String state) {
        this.firstName = firstName;
        this.state = state;
    }
    
    String firstName;
    String state;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public GujCust() {
    }

   
}
