/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author samc
 */
public class Client implements Runnable {

    Socket requestSocket;
    PrintWriter out;
    BufferedReader in;
    boolean connected;
    String recievedStr = "";
    ClientApp ca;
    String sendStr = "MaxMin:null";
    String oldSendStr = sendStr;
    int test = 0;
    Component frame = null;

    public static void main(String args[]) throws IOException {
        Client client = new Client();
        client.run();
    }

    @Override
    public void run() {
        try {
            ca = new ClientApp();
            ca.setVisible(true);
            ca.setConnection(false);

            while (ca.running) {
                try {
                    ca.updateTime();
                    if (ca.connect) {
                        if (!connected) {
                            String ip = JOptionPane.showInputDialog("input ip address");
                            if (ip != null) {
                                ca.alterText("Connecting...");
                                requestSocket = new Socket(ip, 8189);
                                System.out.println("Client>Connected to "
                                        + requestSocket.getLocalAddress().getHostName()
                                        + " on port " + requestSocket.getLocalPort());
                                ca.setConnection(true);
                                connected = true;
                                ca.alterText("Connected to " + requestSocket.getLocalAddress().getHostName()
                                        + " on port " + requestSocket.getLocalPort());
                                out = new PrintWriter(requestSocket.getOutputStream(), true /* auto flush */);
                                in = new BufferedReader(new InputStreamReader(requestSocket.getInputStream()));
                                sendStr = "MaxMin:" + ca.getMaxMin();
                                sendMessage(sendStr);
                                oldSendStr = sendStr;
                                test = 0;
                                test--;
                                ca.updateBpm(String.valueOf(ca.hb.getRandom()));
                                if (in.ready()) {
                                    recievedStr = in.readLine();
                                    if (recievedStr != null) {
                                        System.out.println("Server>" + recievedStr);
                                        test++;
                                        System.out.println("test=" + test);
                                    }
                                }

                                sendStr = "MaxMin:" + ca.getMaxMin();
                                if (!sendStr.equals(oldSendStr)) {
                                    sendMessage(sendStr);
                                    oldSendStr = sendStr;
                                    test--;
                                    System.out.println("test=" + test);

                                    if (test < 1) {
                                        System.out.println("test=" + test);
                                        sendMessage("BYE");
                                        ca.setConnection(false);
                                        if (ca.running) {
                                            ca.alterText("Server Timeout!");
                                        } else {
                                            System.exit(0);
                                        }
                                    }
                                }
                            } else {
                                ca.connect = false;
                                ca.setConnection(false);
                                JOptionPane.showMessageDialog(frame, "Please enter a valid IP.");
                            }
                        }
                    } else if (connected) {
                        ca.setConnection(false);
                        System.out.println("Disconnecting");
                        sendMessage("BYE");
                        ca.alterText("Disconnected");
                        connected = false;
                    }
                } catch (IOException ex) {
                    System.out.println(ex.toString());
                    ca.connect = false;
                    JOptionPane.showMessageDialog(frame, "Connection Failed");
                    ca.alterText("Connection Failed");
                    ca.setConnection(false);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
    }

    private void sendMessage(String msg) {
        out.println(msg);
        System.out.println("Client>" + msg);
    }
}
