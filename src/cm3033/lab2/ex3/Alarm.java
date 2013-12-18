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

    int low, high;
    boolean isActive;

    public Alarm(int low, int high) {
        isActive = false;
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
        } else if (bpm < low) {
            activate();
        } else if (!active()) {
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
