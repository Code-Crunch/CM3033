/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

import cm3033.lab2.ex3.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Florin Mazilu 1114040
 */
//alarm class
public class Alarm {
//int to determine the high and low tresholds for the alarm

    int low, high;
//boolean to determin if its active and if it's too high or too low
    boolean isActive;
    boolean ishigh;
    //String that stores what the alarm was
    String alarm;
    //for logging when an alarm is started and stopped
    final DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    Calendar start = Calendar.getInstance();
    Calendar stop = null;
    String s;
//constructor

    public Alarm(int low, int high) {
        isActive = false;
        ishigh = false;
        this.low = low;
        this.high = high;
        alarm = "";
    }
//activate the alarm

    public void activate() {
        isActive = true;
    }
//deactivate alarm

    public void deactivate() {
        stop = Calendar.getInstance();
        Date time = stop.getTime();
        s = dateFormat.format(time);
        isActive = false;
    }
//check if alarm is active

    public boolean active() {
        return isActive;
    }
//check if the value is between the treshold

    public void check(int bpm) {
        //check if it's to high
        if (bpm > high) {
            activate();
            ishigh = true;
        } //check if it's to low
        else if (bpm < low) {
            ishigh = false;
            activate();
        } else {

            deactivate();
        }
        //pop up's with the alarm
        if (active()
                && ishigh) {
            JOptionPane.showMessageDialog(null, "ALERT: HEART BEAT TOO HIGH");
            deactivate();
            alarm = "ALERT: HEART BEAT TOO HIGH, stopped at :" + s;
        } else if (active()
                && !ishigh) {
            JOptionPane.showMessageDialog(null, "ALERT: HEART BEAT TOO LOW");
            deactivate();
            alarm = "ALERT: HEART BEAT TOO LOW, stopped at :" + s;
        }
    }
//check how long it has been since the last response

    public void timeout(Calendar start, Calendar current) {
        if (start.compareTo(current) > 30000) {
            JOptionPane.showMessageDialog(null, "ALERT: NO RESPONSE FOR 30 SECONDS");
            alarm = "ALERT: NO RESPONSE FOR 30 SECONDS";
        }
    }
//get the alarm string

    public String info() {
        return alarm;
    }

//setters for the high and low values
    public void setLow(int low) {
        this.low = low;
    }

    public void setHigh(int high) {
        this.high = high;
    }

}
