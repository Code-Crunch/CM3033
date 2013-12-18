/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import java.util.Random;
import java.util.Timer;
import javax.swing.JOptionPane;

/**
 *
 * @author Florin
 */
public class HeartBeat extends Timer {
//create a random for the BPM

    private Random r;
    //set a max value that the BPM can be 
    int max;
    //boolean that decides if the bpm should be user inputted or automatic
    boolean automatic = false;
//constructor

    public HeartBeat(int max) {
        r = new Random();
        this.max = max;
    }
//set automatic true

    public void isAutomatic() {
        automatic = true;
    }
//generate a random integer between 0 and the max value

    public int getRandom() throws InterruptedException {
        int temp;
        if (automatic) {
            temp = r.nextInt(max);
        } else {           //if the input is not automatic prompt the user for an input and a random number between 0-10 for variation
            temp = Integer.parseInt(JOptionPane.showInputDialog("Insert Next Heart Beat value")) + r.nextInt(10);
        }
        return temp;
    }

}
