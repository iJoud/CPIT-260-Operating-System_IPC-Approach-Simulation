/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package labassignment;

/**
 * Time-of-day server listening to port 6013.
 *
 */
import java.net.*;
import java.io.*;
import java.util.Scanner;
// invoked to handle runnable file exception
import java.util.logging.Level;
import java.util.logging.Logger;

public class Server implements Runnable {
// I implement runnable for Auto run for the class
    public void run() {
        Socket client = null;
        ServerSocket sock = null;
        try {
            sock = new ServerSocket(6013);
            // now listen for connections
            while (true) {
                client = sock.accept();
                PrintWriter pout = new PrintWriter(client.getOutputStream(), true);

                // Check if we get the address the first client
                // then ask the client to enter a string and semd it to the client
                if (client.getLocalAddress().toString().equals("/127.0.0.3")) {
                    // we have a connection
                    Scanner UserInput = new Scanner(System.in);
                    // Ask user to enter text
                    System.out.print("Enter String : ");
                    // Read from user
                    String message = UserInput.nextLine();
                    // write the String to the socket
                    pout.println("Entered String: " +message);
                }else { // if the connected client is not the seconed client
                    // then send the current date info. to the client
                pout.println("I Choose Client2 string to be date!\n"+new java.util.Date().toString());
                }
                pout.close();
                client.close();
            }

        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            try {
                if (sock != null) {
                    sock.close();
                }
                if (client != null) {
                    client.close();
                }
            } catch (IOException ex) {// handle the exception on this runnable file 
                Logger.getLogger(Server.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
