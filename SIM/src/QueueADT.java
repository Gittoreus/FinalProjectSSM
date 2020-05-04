package FinalProject;

/** A FIFO List. */
public interface QueueADT<E> {
	/** Add the value at the back of this QueueADT. */
	void add(E value);

	/** Remove the value at the front of this QueueADT. */
	E remove();

	/** @return value at the front of this QueueADT, or null if empty. */
	E peek();

	/** @return the size of this QueueADT */
	int size();

	/** Clear this QueueADT */
	void clear();

	/** @return true iff this QueueADT is empty */
	boolean isEmpty();
	
	/** @return this QueueADT as a String */
	public String toString();
}
