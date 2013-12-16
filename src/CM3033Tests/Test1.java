/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

/**
 *
 * @author samc
 */
public class Test1 {

    public static volatile boolean connect = false;
    public static volatile boolean connected = false;
    public static volatile boolean running = true;
    public static volatile String maxMin = "";

    public Test1() {
    }

    public boolean isConnect() {
        return connect;
    }

    public void setConnect(boolean connect) {
        Test1.connect = connect;
    }

    public boolean isConnected() {
        return connected;
    }

    public void setConnected(boolean connected) {
        Test1.connected = connected;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        Test1.running = running;
    }

    public String getMaxMin() {
        return maxMin;
    }

    public void setMaxMin(String maxMin) {
        Test1.maxMin = maxMin;
    }

}
