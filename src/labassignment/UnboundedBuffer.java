package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * This program implements the bounded buffer using shared memory. Note that
 * this solutions is NOT thread-safe. It will be used to illustrate thread
 * safety using Java synchronization in Chapter 7.
 */
import java.util.*; // for the Arraylist

public class UnboundedBuffer implements Buffer {

    private volatile int count;   // points to the last fill index on the ArrayList
    private ArrayList<Object> buffer; // implementing ArrayList as unbounded buffer,
    // Since it doesn't have size limitation to specify on creation 
    // So we can add to the buffer as much as we want without size restriction
    public UnboundedBuffer() {
        // here I delete (in) and (out) variables because no need for them in ArrayList "Unbounded Buffer"
        count = -1; // to know how many full indexes do we have
        // I will use count to consume (remove method)
        // buffer is initially empty with NO SIZE LIMITATION
        buffer = new ArrayList<Object>();
    }
    // producer calls this method
    public void insert(Object item) {
        // add an item to the buffer
        buffer.add(item);
        count++; // since I'm usig ArrayList as unbounded buffer 
        // So I use the varible "count" to select the last index producer fill
        // It will help on consuming 
        System.out.println("Producer Entered " + item);
    }
    // consumer calls this method
    public Object remove() {
        Object item;

        while (true) {
            // The loop will end when consumer did FIRST consumed 
            if (count == -1) { // which mean its empty
                continue;
            }          
            // remove an item from the buffer
            else{
            item = (String)buffer.get(count); // since I'm usig ArrayList as unbounded buffer 
            // So I use the varible "count" to select the last index producer fill
            System.out.println("Consumer Consumed " + item);
            count--;

            // exit the loop 
            return item;
            
            }

        }

    }

}
