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
 * @author Florin Mazilu 1114040
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
        int temp = 0;
        if (automatic) {
            temp = r.nextInt(max);
        } else {           //if the input is not automatic prompt the user for an input and a random number between 0-10 for variation
            //user validation for using only numbers
            boolean isValid = false;
            //checks for the numbers being between 0 and 999
            String check1 = "[0-9]";
            String check2 = "[0-9]{0,9}";
            String check3 = "[0-9]{0,9}[0-9]";
            while (!isValid) {
                String str = JOptionPane.showInputDialog("Insert Next Heart Beat value(only numbers between 1-300)");
                if (str.matches(check1) || str.matches(check2) || str.matches(check3)) {
                    temp = Integer.parseInt(str) + r.nextInt(10);
                    //check for the values to be between 0-300 as there will never be a bpm that high
                    if (temp > 0 && temp < 300) {
                        isValid = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "Please only use values lower than 300");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please only use numerical values");

                }
            }
        }
        return temp;
    }

}
