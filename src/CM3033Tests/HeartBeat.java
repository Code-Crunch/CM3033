/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

import java.util.Random;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Florin Mazilu 1114040
 */
public class HeartBeat extends Thread {
//create a random for the BPM

    private Random r;
    //set a max value that the BPM can be 
    private int max;
    //returns the automatic bpm
    private int autoBPM;

    //boolean that decides if the bpm should be user inputted or automatic
    private boolean automatic = false;
    //gen date time for logging when a BPM is automaticly generated
    private final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private Calendar start = null;

    //constructor
    public HeartBeat(int max) {
        r = new Random();
        this.max = max;
    }
//set automatic true

    public void isAutomatic() {
        automatic = true;
    }

    public boolean auto() {
        return automatic;
    }

    public String genTime(int rand) throws InterruptedException {
        start = Calendar.getInstance();
        Date time = start.getTime();
        String str = "BPM generated : " + rand + ", generated at :" + dateFormat.format(time);
        return str;
    }

    public void isManual() {
        automatic = false;
    }
//generate a random integer between 0 and the max value

    public int getRandom() {
        //generate a temp value for the random;
        int temp = 0;
        if (automatic) {
            temp = r.nextInt(max - 20) + 20;
        } else {            //if the input is not automatic prompt the user for an input and a random number between 0-10 for variation
            //user validation for using only numbers
            boolean isValid = false;
            //checks for the numbers being between 0 and 999
            String check1 = "[0-9]";
            String check2 = "[0-9]{0,9}";
            String check3 = "[0-9]{0,9}[0-9]";
            while (!isValid) {
                String str = JOptionPane.showInputDialog("Insert Next Heart Beat value(only numbers between 1-300)");
                if (str != null) {
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
        }
        return temp;
    }
}
