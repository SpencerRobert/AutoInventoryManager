

/*
 * Spencer Poultney, spoultne@uwo.ca
 * Inventory class designed to store an array of Automobile objects with methods to sort and display them.
 */

import java.util.*;
import java.io.*;

public class Inventory {
	
	private String name; 
	private final int MAXINVENTORY = 100;
	private int count = 0;
	private Automobile[] inventory;
	
	
	//Constructor for manual inventory fill
	public Inventory(String cName) {
		this.name = cName;
		this.inventory = new Automobile[MAXINVENTORY];
	}
	
	
	//Constructor to fill inventory based on CSV file content
	public Inventory(String cName, String csvName) {
		this.name = cName;
		this.inventory = new Automobile[MAXINVENTORY];
		
		String csvFile = csvName;
		String line = "";
		BufferedReader br = null; 
		
		
		//Try reading CSV file
		try {
			br = new BufferedReader(new FileReader(csvFile));
			
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				Automobile tempAuto = new Automobile(fields[0], fields[1], fields[2], fields[3], fields[4], Integer.parseInt(fields[5]), Integer.parseInt(fields[6]), Integer.parseInt(fields[7]));
				this.addAutomobile(tempAuto);	//Fill inventory with temp Automobile objects
			}
			
		//Exceptions
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	//Method designed to add provided Automobile object to inventory
	public void addAutomobile(Automobile newAutomobile) {
		
		for (int i = 0; i < this.inventory.length; i++) {
			
			if (this.inventory[i] == null) {	//Next free space
				this.inventory[i] = newAutomobile;	//Add
				this.count++;	//Update inventory count
				return;
			}
		}
	}
	
	
	//Getters & Setters
	
	public Automobile[] getInventory() {
		return this.inventory;
	}
	
	public void setInventory(Automobile[] newInventory) {
		
		this.inventory = newInventory;
	}
	
	public int getCount() {
		return this.count;
	}
	
	
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return this.name;
	}
	
	//Sort Inventory method designed to sort inventory based on user input
	public Automobile[] sortInventory() {
		
		Automobile[] inv = this.getInventory();
		int c = this.getCount();
		
		boolean input = false;
		
		while (input == false) {	//While correct input hasn't been provided
			
			//Gather user input to specify sort type and order
			Scanner sc = new Scanner(System.in);
			System.out.println("By what field would you like to sort the inventory?\n1 -----> By Year\n2 -----> By Mileage\n3 -----> By Price\n");
			int sortType = sc.nextInt();
			System.out.println("In what order?\n1 -----> Ascending Order\n2 -----> Descending Order\n");
			int sortOrder = sc.nextInt();
			
		switch (sortType) {
		
		case 1: //By Year
			
				if (sortOrder == 1) {	//If ascending
					
					//Sort
					for(int j = 0; j < c; j++) {
						for (int i = 0; i < c-1; i++) {
							
							if (inv[i].getYear() > inv[i+1].getYear()) {
								Automobile temp = inv[i];
								inv[i] = inv[i+1];
								inv[i+1] = temp;
							}
						}
						}
					input = true;	//Correct input
				}
				
				if (sortOrder == 2) {	//If descending
					
					for(int j = 0; j < c; j++) {
					for (int i = 0; i < c-1; i++) {
						
						if (inv[i].getYear() < inv[i+1].getYear()) {
							Automobile temp = inv[i];
							inv[i] = inv[i+1];
							inv[i+1] = temp;
						}
					}
					}
					input = true;
				}
					break;
					
		case 2:	//By Mileage
				
			if (sortOrder == 1) {
				
				for(int j = 0; j < c; j++) {
					for (int i = 0; i < c-1; i++) {
						
						if (inv[i].getMileage() > inv[i+1].getMileage()) {
							Automobile temp = inv[i];
							inv[i] = inv[i+1];
							inv[i+1] = temp;
						}
					}
					}
				input = true;
			}
			
			if (sortOrder == 2) {
				
				for(int j = 0; j < c; j++) {
				for (int i = 0; i < c-1; i++) {
					
					if (inv[i].getMileage() < inv[i+1].getMileage()) {
						Automobile temp = inv[i];
						inv[i] = inv[i+1];
						inv[i+1] = temp;
					}
				}
				}
				input = true;
			}
				break;
				
				
		case 3:	//By Price
				
			if (sortOrder == 1) {
				
				for(int j = 0; j < c; j++) {
					for (int i = 0; i < c-1; i++) {
						
						if (inv[i].getPrice() > inv[i+1].getPrice()) {
							Automobile temp = inv[i];
							inv[i] = inv[i+1];
							inv[i+1] = temp;
						}
					}
					}
				input = true;
			}
			
			if (sortOrder == 2) {
				
				for(int j = 0; j < c; j++) {
				for (int i = 0; i < c-1; i++) {
					
					if (inv[i].getPrice() < inv[i+1].getPrice()) {
						Automobile temp = inv[i];
						inv[i] = inv[i+1];
						inv[i+1] = temp;
					}
				}
				}
				input = true;
			}
				break;
				
		default: //Incorrect input
					System.out.println("Incorrect input please try again.");
					break;
		}
		}
		return inv; //Return sorted inventory
	}
	
	
	//Display Inventory method designed to loop through inventory and print its associated Automobile objects
	public void displayInventory() {
		
		int c = this.getCount();
		String n = this.getName();
		
		Automobile[] invToDisplay = this.sortInventory();
		
		System.out.println(n + " Current Inventory:\n ________________________________________________________________________________________________________________________________________________________________________________________________________\n");
		
		for (int x = 0; x < c; x++) {
			System.out.print(invToDisplay[x].printAutomobile());
		}
		
		System.out.println("\nInventory Count: " + c + "\n");	//display total # of automobiles in inventory
		
	}
	
	
}
