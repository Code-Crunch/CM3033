/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

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
public class StartServer {
  public static void main(String[] args){
    int tpSize = 5;
    ThreadPoolExecutor pool = new ThreadPoolExecutor(
              tpSize,
              tpSize,
              50000L,
              TimeUnit.MILLISECONDS,
              new LinkedBlockingQueue<Runnable>());
    try 
    { 
      ServerSocket s = new ServerSocket(8189) ;
      System.out.println("Server>Waiting For Clients...");
      // listen for a connection request on server socket s
      // incoming is the connection socket
      for(;;)
      { 
        Socket incoming = s.accept() ;
        pool.execute(new Server(incoming));
      }
    }
    catch(IOException e)
    {
        System.out.println(e);
    }
    pool.shutdown();
  }   
}
