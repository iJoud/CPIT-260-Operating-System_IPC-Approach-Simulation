package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Client program requesting current date from server.
 *
 */
import java.net.*;
import java.io.*;
import java.util.*;
// invoked to handle runnable file exception
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client1 implements Runnable {
// I implement runnable for Auto run for the class
    public void run() {
        InputStream in = null;
        BufferedReader bin = null;
        Socket sock = null;

        try {
            // I change the address to identify which client to ask the user to enter string and which not
            sock = new Socket("127.0.0.3", 6013);
            in = sock.getInputStream();
            bin = new BufferedReader(new InputStreamReader(in));

            String line;// printing from server
            while ((line = bin.readLine()) != null) {
                System.out.println( line);
            }
            System.out.println("--Client1 End---");// to make the output Clear
        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException ex) {// handle the exception on this runnable file 
                    Logger.getLogger(Client1.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
