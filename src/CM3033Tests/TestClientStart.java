/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CM3033Tests;

import java.io.IOException;

/**
 *
 * @author samc
 */
public class TestClientStart {

    static volatile Test1 t1 = new Test1();

    public static void main(String args[]) throws IOException {
        Thread client = new Thread(new Client(t1));
        Thread clientGUI = new Thread(new ClientApp(t1));

        clientGUI.start();
        client.start();
    }
}
