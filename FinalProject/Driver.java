package FinalProject;

import java.util.Scanner;

/*
 * @author Kyle K, Tim G, Matt K, Victor C
 * @purpose SSM Final Project
 * @prof Professor Safko
 * @date May 4, 2020
 */

public class Driver {
	/*
	 * Balk: A customer can decide to not join a queue in the first place 
	 * Renege: A customer can decide to leave the queue without being served
	 * Jockey: A customer can decide to jump to another server if that server opens.
	 */
	
	/*
	 * ISSUES:
	 * Iterator needed for ArrayQueue
	 * dequeue() method returning IndexOutOfBoundsException() (can be tested in option 2)
	 * ^^^use MyQueueTest.java to test this
	 * Code for Balk needed
	 * Code for Renege needed
	 * Code for Jockey needed
     * q_hat, B(t)
	 */
	
	static int time = 0; // Global time keeper

	public static void main(String[] args) {
		final int EXPRESS_CHECKOUT_SIZE = 5; // Number of items allowed for express checkout
		boolean run = true;
		Scanner sc = new Scanner(System.in);
		

		Server server1 = new Server("Regular");
		Server server2 = new Server("Express");

		server1.setOpen(true); // Start the first server open; can take any size cart
		server2.setOpen(false); // Start the second server closed; counts as the express lane

		Customer c;
		String name;

		System.out.println("Welcome to the SSM Queue and Server System");
		System.out.println("Team: Team Geese 2.0");
		System.out.println("Members: Kyle K, Tim G, Matt K, Victor C\n\n*****");

		do { // Repeating Menu + Selections
			System.out.println("\nSelect an Option for the System:");
			System.out.println("1. Create a [Customer]");
			System.out.println("2. Increment Time"); //Process a [Customer]");
			System.out.println("3. Open the second server");
			System.out.println("4. Close the second server");
			System.out.println("5. Find q-hat");
			System.out.println("6. Find u-hat");
			System.out.println("7. Find B(t)");
			System.out.println("8. Report on balking [customers]");
			System.out.println("9. Report on reneging [customers]");
			System.out.println("10. Report on jockeying [customers]");
			System.out.println("11. Quit");
			int choice = sc.nextInt();


			switch (choice) {

			case 1: // Create a [Customer]
				System.out.println("Enter Customer name:");
				name = sc.next();
				c = new Customer(name,getTime()); //Matt -K : changed constructor
				String added = "null";
				// BALKING: if (server size > 5) dont add (for both servers)
		        	

                // Server Placement (will they go to express?)	
				if (server2.getOpen() && c.getCart() <= EXPRESS_CHECKOUT_SIZE) {
					server2.enqueue(c);
					added = server2.getName();
				} else {
					server1.enqueue(c);
					added = server1.getName();
				}
				
				System.out.println(c.getName() + " added to " + added + ".");
				break;

			case 2:    //increment time and update system 

                addTime();

                //process servers

                server1.update();
                server2.update();                
                System.out.print("Time: " + time);


                        /* 
                        // Process a [Customer]
                        if (server1.getOpen() && server2.getOpen()) { // Both open
                            System.out.println("Removing from " + server1.getName() + " or " + server2.getName() + "?");
                            choice = sc.nextInt();
                            if (choice == 1) {
                                c = server1.dequeue();
                                System.out.println(c.getName() + " has been processed from " + server1.getName());
                                System.out.println(c.toString()); // Print customer removed from Regular checkout
                            }
                            else if (choice == 2) {
                                c = server2.dequeue();
                                System.out.println(c.getName() + " has been processed from " + server2.getName());
                                System.out.println(c.toString()); // Print customer removed from Express checkout
                            }
                            else
                                System.out.println("Incorrect option. Going back to menu.");
                                break; // End this choice (nothing happens)
                        }
                        else if ((server1.getOpen() && !server2.getOpen()) || server2.getWaitTime() == 0) { // 1 open, 2 closed or empty
                            c = server1.dequeue(); // ***
                            System.out.println(c.getName() + " has been processed from " + server1.getName());
                            System.out.println(c.toString()); // Print customer removed from Regular checkout
                        }
                        else if ((!server1.getOpen() && server2.getOpen()) || server1.getWaitTime() == 0) { // 1 closed or empty, 2 open
                            c = server2.dequeue();
                            System.out.println(c.getName() + " has been processed from " + server2.getName());
                            System.out.println(c.toString()); // Print customer removed from Express checkout
                        }
                        else { // If both are closed and/or empty
                            System.out.print("Cannot process from " + server1.getName() + " or " + server2.getName() + ".");
                            System.out.println(" Going back to menu.");
                        }
                        */

    
                        break;
			case 3: // Open the second server
				server2.open();
				System.out.println(server2.getName() + " is now open.");
				break;
			case 4: // Close the second server
				server2.close(server1);
				System.out.println(server2.getName() + " is now closed.");
				System.out.println("Moving all customers to the end of " + server1.getName());
				
				break;
			case 5: // Find q-hat
				System.out.println("q_hat of " + server1.getName() + ": " + server1.getQ_Hat(time));
				System.out.println("q_hat of " + server2.getName() + ": " + server2.getQ_Hat(time));
				break;
			case 6: // Find u-hat
				System.out.println("u_hat of " + server1.getName() + ": " + server1.getU_Hat(time));
				System.out.println("u_hat of " + server2.getName() + ": " + server2.getU_Hat(time));
				break;
			case 7: // Find B(t)
				System.out.println("B(T) of " + server1.getName() + ": " + server1.B_T());
				System.out.println("B(T) of " + server2.getName() + ": " + server2.B_T());
				break;


			case 8: // Report on balking [customers]

				break;
			case 9: // Report on reneging [customers]

				break;
			case 10: // Report on jockeying [customers]

				break;
			case 11: // Quit
				sc.close();
				System.exit(0);
				break;
			default:
				System.out.println("Please enter valid choice.");
			}
		} while (run);
	}
	
	/*
	 * @returns the global time.
	 * 
	 */
	private static int getTime() {
		return time;
	}

	/*
	 * Increments the global time.
	 */
	private static void addTime() {
		time++;
//		balk();
//		renege();
//		jockey();
	}
	
//	private static String renege() {
//		
//	}
}