/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import javax.swing.JOptionPane;

/**
 *
 * @author Florin
 */
public class Alarm {

    int low, high;
    boolean isActive;
    boolean ishigh;

    public Alarm(int low, int high) {
        isActive = false;
        ishigh = false;
        this.low = low;
        this.high = high;
    }

    public void activate() {
        isActive = true;
    }

    public void deactivate() {
        isActive = false;
    }

    public boolean active() {
        return isActive;
    }

    public void check(int bpm) {
        if (bpm > high) {
            activate();
            ishigh = true;
        } else if (bpm < low) {
            activate();
        } else if (!active()) {
            deactivate();
        }
        if (active() && ishigh) {
            JOptionPane.showMessageDialog(null, "ALERT: HEART BEAT TOO HIGH");
            deactivate();
        } else if (active() && !ishigh) {
            JOptionPane.showMessageDialog(null, "ALERT: HEART BEAT TOO LOW");
            deactivate();
        }
    }

    public void setLow(int low) {
        this.low = low;
    }

    public void setHigh(int high) {
        this.high = high;
    }

}
