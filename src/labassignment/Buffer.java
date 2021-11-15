package labassignment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 /**
 * An interface for buffers
 *
 */


public interface Buffer
{
	/**
	 * insert an item into the Buffer.
	 * Note this may be either a blocking
	 * or non-blocking operation.
	 */
	public abstract void insert(Object item);

	/**
	 * remove an item from the Buffer.
	 * Note this may be either a blocking
	 * or non-blocking operation.
	 */
	public abstract Object remove();
}
