/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author David
 */
public class Server implements Runnable {

    private Socket incoming;
    ServerApp sv;

    public Server(Socket incoming, ServerApp sv) {
        this.incoming = incoming;
        this.sv = sv;
        sv.setVisible(true);
    }

    @Override
    public void run() {
        try {
            String s;
            // set up streams for bidirectional transfer
            // across connection socket 
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* auto flush */);
            out.println("You are connected to "
                    + incoming.getLocalAddress().getHostName()
                    + " on port " + incoming.getLocalPort()
            );
            out.println("Type BYE to quit");
            System.out.println(incoming.getLocalAddress().getHostName() + " Connected");
            s = incoming.getLocalAddress().getHostName() + " Connected" + "\n";
            sv.appendText(s);
            boolean done = false;
            while (!done) {
                String str = in.readLine();
                if (str == null) {
                    done = true;
                } else {
                    out.println("Recieved: " + str);
                    if (str.trim().equals("BYE")) {
                        System.out.println(incoming.getLocalAddress().getHostName() + " Disconnected");
                        s = incoming.getLocalAddress().getHostName() + " Disconnected" + "\n";
                        sv.appendText(s);
                        done = true;
                    }
                }
            }
            incoming.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
