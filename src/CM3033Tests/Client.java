/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JOptionPane;

/**
 *
 * @author samc
 */
public class Client implements Runnable {

    Socket requestSocket;
    PrintWriter out;
    BufferedReader in;

    //ClientApp ca;
    String sendStr = "MaxMin:null";
    String oldSendStr = sendStr;
    int test = 0;
    Component frame = null;
    String oldMaxMin = "";

    volatile Test1 t1;

    public Client(Test1 t2) {
        t1 = t2;
    }

    public static void main(String args[]) throws IOException {
        //Client client = new Client();
        //client.run();
    }

    @Override
    public void run() {
        while (t1.isRunning()) {
            try {
                //ca.updateTime();
                //System.out.println(t1.isConnect());
                if (t1.isConnect()) {
                    if (!t1.isConnected()) {
                        System.out.println(3);
                        System.out.println("1test=" + test);
                        String ip = JOptionPane.showInputDialog("input ip address");
                        if (ip != null) {
                            System.out.println(4);
                            //ca.alterText("Connecting...");
                            requestSocket = new Socket(ip, 8189);
                            System.out.println("Client>Connected to "
                                    + requestSocket.getLocalAddress().getHostName()
                                    + " on port " + requestSocket.getLocalPort());
                            out = new PrintWriter(requestSocket.getOutputStream(), true /* auto flush */);
                            in = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
                            t1.setConnected(true);
                            //ca.alterText("Connected to " + requestSocket.getLocalAddress().getHostName()
                            //        + " on port " + requestSocket.getLocalPort());
                            //sendStr = "MaxMin:" + t1.getMaxMin();
                            //sendMessage(sendStr);
                            //oldSendStr = sendStr;
                            //test = 0;
                            test++;

                            if (in.ready()) {
                                System.out.println(5);
                                //t1.setMaxMin(in.readLine());
                                if (t1.getMaxMin() != null) {
                                    System.out.println(6);
                                    System.out.println("Server>" + t1.getMaxMin());
                                    test++;
                                    System.out.println("2test=" + test);
                                } else {
                                    System.out.println(7);
                                    t1.setMaxMin(oldMaxMin);
                                }
                            }

                            sendStr = "MaxMin:" + t1.getMaxMin();
                            if (!sendStr.equals(oldSendStr)) {
                                System.out.println(8);
                                sendMessage(sendStr);
                                oldSendStr = sendStr;
                                test--;
                                System.out.println("3test=" + test);

                                if (test < 0) {
                                    System.out.println(9);
                                    System.out.println("4test=" + test);
                                    sendMessage("BYE");
                                    t1.setConnected(false);
                                    if (t1.isRunning()) {
                                        System.out.println(10);
                                        //ca.alterText("Server Timeout!");
                                    } else {
                                        System.out.println(11);
                                        System.exit(0);
                                    }
                                }
                            }
                        } else {
                            System.out.println(12);
                            t1.setConnect(false);
                            t1.setConnected(false);
                            JOptionPane.showMessageDialog(frame, "Please enter a valid IP.");
                        }
                    }
                } else if (t1.isConnected()) {
                    System.out.println(13);
                    System.out.println("Disconnecting");
                    sendMessage("BYE");
                    //ca.alterText("Disconnected");
                    t1.setConnected(false);
                }
            } catch (IOException ex) {
                System.out.println(ex.toString());
                t1.setConnect(false);
                System.out.println("OOHGAHBOOGAH");
                JOptionPane.showMessageDialog(frame, "Connection Failed");
                //ca.alterText("Connection Failed");
                t1.setConnected(true);
            }
        }
    }

    private void sendMessage(String msg) {
        out.println(msg);
        System.out.println("Client>" + msg);
    }
}
