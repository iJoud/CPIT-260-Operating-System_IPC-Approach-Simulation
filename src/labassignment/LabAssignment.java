package labassignment;

import java.io.IOException;
import java.util.*;

public class LabAssignment {

    public static void main(String[] args) throws Exception {
        int choice; // I use this variable inside the loop to get user choice
        loop1:
        while (true) {
            // Display menu to user and asking user to enter choice 
            System.out.print("The application contain following approaches to simulate\n "
                    + "Choose one of the three given approaches to simulate:\n"
                    + "1- Shared Memory\n"
                    + "2- Massage Passing\n"
                    + "3- Client-server\n"
                    + "Enter the number of your choice: ");
            Scanner scan = new Scanner(System.in);
            choice = scan.nextInt(); // variable to get user choice 
            // In case user didn't choose correct choice, keep asking him to enter a valid number 
            if (choice != 1 && choice != 2 && choice != 3) {
                System.out.print("Wrong choice number, "+"\nRetry again!\n");
            } else {
                break loop1; // and go to simulate the choosen approache
            }
        } // end of while loop
        if (choice == 1) {
            SharedMemory();
        } else if (choice == 2) {
            MessagePassing();
        } else if (choice == 3) {
            Client_Server();
        }

    }

    public static void SharedMemory() {
        //Factory Part start
        {
            Buffer server = new UnboundedBuffer();

            // now create the producer and consumer threads
            Thread producerThread = new Thread(new SharedMemoryProducer(server));
            Thread consumerThread = new Thread(new SharedMemoryConsumer(server));

            producerThread.start();
            consumerThread.start();
        }
        //Factory Part end
    }

    public static void MessagePassing() {

        //Factory Part start
        {
            // first create the message buffer     
            Channel mailBox = new MessageQueue();

            // now create the producer and consumer threads
            Thread producerThread = new Thread(new MessagePassingProducer(mailBox));
            Thread consumerThread = new Thread(new MessagePassingConsumer(mailBox));

            producerThread.start();
            consumerThread.start();
        }
        //Factory Part end

    }

    public static void Client_Server() throws Exception {

        try {
            // I create a thread for server class so I can make it runnable all the time from my main class
            // Then go and run each client separately
            Thread RunServer = new Thread(new Server());
            Thread Client1 = new Thread(new Client2());
            Thread Client2 = new Thread(new Client1());

            // Start the threads
            Client1.start();
            Client2.start();
            RunServer.start();
        } catch (Exception ioe) {
            System.err.println(ioe);
        }

    }

}
