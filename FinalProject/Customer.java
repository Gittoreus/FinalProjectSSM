package FinalProject;

import java.util.Random;

public class Customer {
	private String name; // Unique first name for the customer.
	private int entryTime; // Time they entered the queue; Qualifies as unique identifier
	private int waitTime; // Time the customer has waited so far
	private int procTime; //Time it will take to process the customer
	private int cart; // Number of items in the cart

	private Random rand = new Random();

	// Default Constructor, empty variables
	public Customer() {
		name = "";
		entryTime = 0;
		waitTime = 0;
		procTime = 0;
		cart = 0;
	}

    //@Author : Matthew Keville
    //Primary Constructor	
    public Customer(String name, int entryTime){
        this.name = name;
        this.entryTime = entryTime;
        this.waitTime = 0;
        this.cart = rand.nextInt(10);
        this.procTime = 1 + rand.nextInt(cart);
    }


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEntryTime() {
		return entryTime;
	}

	public void setEntryTime(int entryTime) {
		this.entryTime = entryTime;
	}

    
	public int getWaitTime() {
		return waitTime;
	}

	public void setWaitTime(int waitTime) {
		this.waitTime = waitTime;
	}

	public int getProcTime() {
		return procTime;
	}

	public void setProcTime(int procTime) {
		this.procTime = procTime;
	}

	public int getCart() {
		return cart;
	}

	public void setCart(int cart) {
		this.cart = cart;
	}

	public String toStringName() {
		return name;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", entryTime=" + entryTime + ", waitTime=" + waitTime + ", procTime="
				+ procTime + ", cart=" + cart + "]";
	}
}