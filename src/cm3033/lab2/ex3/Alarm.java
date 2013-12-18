/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package cm3033.lab2.ex3;

/**
 *
 * @author Florin
 */
public class Alarm {
    boolean isActive;
    
    public Alarm(){
    isActive = false;
    }
    public void activate(){
    isActive = true;
    }
    public void deactivate(){
    isActive = false;
    }
    
    public boolean active(){
    return isActive;
    }
}
