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

public class SharedMemoryConsumer implements Runnable {

    public SharedMemoryConsumer(Buffer b) {
        buffer = b;
    }

    public void run() {
            // consume an item from the buffer
            System.out.println("Consumer wants to consume.");
            // read from buffer
           String message = (String) buffer.remove();
    }

    private Buffer buffer;
}
