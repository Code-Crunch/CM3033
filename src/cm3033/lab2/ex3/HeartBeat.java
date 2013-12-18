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

    private Random r;
    int max;
    boolean automatic = false;

    public HeartBeat(int max) {
        r = new Random();
        this.max = max;
    }

    public void isAutomatic() {
        automatic = true;
    }



    public int getRandom() throws InterruptedException {
        int temp;
        if (automatic) {
            temp = r.nextInt(max);
        } else {
            temp = Integer.parseInt(JOptionPane.showInputDialog("Insert Next Heart Beat value")) + r.nextInt(10);
        }
        return temp;
    }

}
