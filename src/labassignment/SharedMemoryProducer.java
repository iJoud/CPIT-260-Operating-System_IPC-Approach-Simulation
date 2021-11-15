package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This is the producer thread for the bounded buffer problem.
 */


import java.util.*;

public class SharedMemoryProducer implements Runnable
{
   public SharedMemoryProducer(Buffer b) {
      buffer = b;
   }
   
   public void run()
   {
   String message;
     
         // produce an item & enter it into the buffer
         // create scanner to read from user
         Scanner UserInput = new Scanner (System.in);
         // Ask user to enter text
         System.out.print("Enter text : ");
         // Read from user
         message = UserInput.nextLine();  
         System.out.println("Producer produced : " + message);
         // insert the text
         buffer.insert(message);
      
         
   }
   
   private  Buffer buffer;
}
