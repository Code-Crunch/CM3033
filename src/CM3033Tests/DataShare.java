/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

/**
 *
 * @author Sam Cusson 1006286
 */
public class DataShare {

    ////////////////////////////
    //////   VARIABLES   ///////
    ////////////////////////////
    //integer for min and max 
    int min, max;
    // Store wether to connect or not
    public static volatile boolean connect = false;
    // Store if connected or not
    public static volatile boolean connected = false;
    // Store if running or not
    public static volatile boolean running = true;
    // Store the max/min limits
    public static volatile String maxMin = "";
    // BPM
    HeartBeat hb;
    int BPM;

    ////////////////////////////
    //////  CONSTRUCTOR  ///////
    ////////////////////////////
    public DataShare() {
    }

    public void setMin(int min) {
        this.min = min;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public void startHb() {
        hb = new HeartBeat(min, max);

    }

    //////////////////////////////
    ////// GETTERS/SETTERS ///////
    //////////////////////////////
    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        DataShare.connect = connect;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        DataShare.connected = connected;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        DataShare.running = running;
    }

    public String getMaxMin() {
        return maxMin;
    }

    public void setMaxMin(String maxMin) {
        DataShare.maxMin = maxMin;
    }

    public void setHbLimits(int min, int max) {
        hb.setMaxMin(min, max);
    }

    public int getHb() {
        BPM = hb.getCurrentBPM();
        return BPM;
    }

    public String genTime() throws InterruptedException {
        return hb.genTime(BPM);
    }

    public void runHb() {
        for (int i = 0; i < 10; i++) {
            hb.run();
        }
    }
}
