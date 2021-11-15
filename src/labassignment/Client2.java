package labassignment;

import java.net.*;
import java.io.*;
import java.util.*;
// invoked to handle runnable file exception
import java.util.logging.Level;
import java.util.logging.Logger;

public class Client2 implements Runnable {
// I implement runnable for Auto run for the class
    public void run() {
        InputStream in = null;
        BufferedReader bin = null;
        Socket sock = null;

        try {
            sock = new Socket("127.0.0.1", 6013);
            in = sock.getInputStream();
            bin = new BufferedReader(new InputStreamReader(in));

            String line;
            while ((line = bin.readLine()) != null)// print from server 
            {
                System.out.println(line);
            }
            System.out.println("--- Client2 end ---");// to make the output Clear

        } catch (IOException ioe) {
            System.err.println(ioe);
        } finally {
            if (sock != null) {
                try {
                    sock.close();
                } catch (IOException ex) {// handle the exception on this runnable file 
                    Logger.getLogger(Client2.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }
}
