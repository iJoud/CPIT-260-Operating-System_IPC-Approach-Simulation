package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This is the consumer thread for the bounded buffer problem.
 */
import java.util.*;

class MessagePassingConsumer implements Runnable {

    public MessagePassingConsumer(Channel m) {
        mbox = m;
    }

    public void run() {
        String message;
        System.out.println("Consumer wants to consume.");
        while (true) { // I will Break the loop in case ((FIRST)) String is consumed
            // consume an item from the buffer
            message = (String) mbox.receive();
            if (message != null) {
                System.out.println("Consumer consumed " + message);
                break; // The loop will break if we get the ((FIRST)) String
            }
        }
    }

    private Channel mbox;
}
