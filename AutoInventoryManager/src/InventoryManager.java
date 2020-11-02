

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.ApplicationContext;

/*
 * Spencer Poultney, spoultne@uwo.ca
 * Inventory Manager class designed to make use of Java's Spring Framework to create Inventory and Automobile objects using 
 * constructor injection
 */

public class InventoryManager {

	
	public static void main(String args[]) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		System.out.println("Config loaded");
		
		/**
		 * TEST 1
		 * Used constructor injection to create inventory with the CSV parameter constructor
		 */
		Inventory londonUsedVehicles = context.getBean("LondonUsedVehicles",Inventory.class);	
		londonUsedVehicles.displayInventory();
		
		
		/**
		 * TEST 2 
		 * Creating Automobile beans via constructor injection then adding them to existing inventory
		 */
		
		//Add 5 new Automobiles 
		Automobile testAutomobile1 = context.getBean("TestAutomobile1", Automobile.class);
		londonUsedVehicles.addAutomobile(testAutomobile1);
		
		Automobile testAutomobile2 = context.getBean("TestAutomobile2", Automobile.class);
		londonUsedVehicles.addAutomobile(testAutomobile2);
		
		Automobile testAutomobile3 = context.getBean("TestAutomobile3", Automobile.class);
		londonUsedVehicles.addAutomobile(testAutomobile3);
		
		Automobile testAutomobile4 = context.getBean("TestAutomobile4", Automobile.class);
		londonUsedVehicles.addAutomobile(testAutomobile4);
		
		Automobile testAutomobile5 = context.getBean("TestAutomobile5", Automobile.class);
		londonUsedVehicles.addAutomobile(testAutomobile5);
		
		londonUsedVehicles.displayInventory();	//Display updated inventory
		
	}
}
