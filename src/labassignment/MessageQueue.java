package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * This program implements the bounded buffer using message passing.
 * Note that this solutions is NOT thread-safe. A thread safe solution
 * can be developed using Java synchronization which is discussed in Chapter 6.
 */

import java.util.Vector;
 
public class MessageQueue implements Channel
{
private Vector queue;

   public MessageQueue() {
      queue = new Vector();
   }
   
   /*
    * This implements a non-blocking send
    */
   public void send(Object item) {
      queue.addElement(item);
   }
   
   /*
    * This implements a non-blocking receive
    */
    
   public Object receive() {
      if (queue.size() == 0)
	 return null;
      else 
         return queue.remove(0);
    }
}
