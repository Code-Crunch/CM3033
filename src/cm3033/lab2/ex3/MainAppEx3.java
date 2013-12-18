/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cm3033.lab2.ex3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 * @author David
 */
public class MainAppEx3 {

    public static void main(String[] args) {
        int tpSize = 5;
        ServerApp sv = new ServerApp();
        ThreadPoolExecutor pool = new ThreadPoolExecutor(
                tpSize,
                tpSize,
                50000L,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<Runnable>());
        try {
            ServerSocket s = new ServerSocket(8189);
            System.out.println("Server>Waiting For Clients...");
            // listen for a connection request on server socket s
            // incoming is the connection socket
            for (;;) {
                Socket incoming = s.accept();
                pool.execute(new Server(incoming, sv));
            }
        } catch (IOException e) {
            System.out.println(e);
        }
        pool.shutdown();
    }
}
