/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

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

    public Server(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try {
            // set up streams for bidirectional transfer
            // across connection socket 
            BufferedReader in = new BufferedReader(new InputStreamReader(incoming.getInputStream()));
            PrintWriter out = new PrintWriter(incoming.getOutputStream(), true /* auto flush */);
            out.println("You are connected to "
                    + incoming.getLocalAddress().getHostName()
                    + " on port " + incoming.getLocalPort()
            );
            //out.println("Type BYE to quit");
            System.out.println(incoming.getLocalAddress().getHostName() + " Connected");
            boolean done = false;
            while (!done) {
                if (in.ready()) {
                    String str = in.readLine().trim();
                    if (str == null) {
                        //done = true;
                    } else {
                        out.println("Recieved: " + str);
                        System.out.println("Recieved: " + str);
                        if (str.trim().equals("BYE")) {
                            System.out.println(incoming.getLocalAddress().getHostName() + " Disconnected");
                            done = true;
                        }
                    }
                }
            }
            incoming.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
}
