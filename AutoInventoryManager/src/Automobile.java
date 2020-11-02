
import java.util.*;

/*
 * Spencer Poultney, spoultne@uwo.ca
 * Automobile class designed to store vehicle information.
 */

public class Automobile {

	private String classification;
	private String make;
	private String model;
	private String condition;
	private String color; 
	
	
	private int year;
	private int mileage;
	private int price; 
	
	public Automobile(String cClassification, String cMake, String cModel, String cCondition, String cColor, int cYear, int cMileage, int cPrice) {
		
		this.classification = cClassification;
		this.make = cMake;
		this.model = cModel;
		this.condition = cCondition;
		this.color = cColor; 
		this.year = cYear;
		this.mileage = cMileage;
		this.price = cPrice;
		
	}
	
	
	//Getters & Setters
	
	public void setClassification(String newClassification) {
		this.classification = newClassification;
	}
	
	public String getClassification() {
		return this.classification;
	}
	
	public void setMake(String newMake) {
		this.make = newMake;
	}
	
	public String getMake() {
		return this.make;
	}
	
	public void setModel(String newModel) {
		this.model = newModel;
	}
	
	public String getModel() {
		return this.model;
	}
	
	public void setCondition(String newCondition) {
		this.condition = newCondition;
	}
	
	public String getCondition() {
		return this.condition;
	}
	
	public void setColor(String newColor) {
		this.color = newColor;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setYear(int newYear) {
		this.year = newYear;
	}
	
	public int getYear() {
		return this.year;
	}
	
	public void setMileage(int newMileage) {
		this.mileage = newMileage;
	}
	
	public int getMileage() {
		return this.mileage;
	}
	
	public void setPrice(int newPrice) {
		this.price = newPrice;
	}
	
	public int getPrice() {
		return this.price;
	}
	
	//Print function used to return Automobile object formatted to a string ready to be printed.
	public String printAutomobile() {
		
		String autoPrint = String.format("Classification: %s	|	Make: %s	|	Model: %s	|	Condition: %s	|	Color: %s	|	Year: %d	|	Mileage: %dkm	|	Price: $%d	\n", this.getClassification(), this.getMake(), this.getModel(), this.getCondition(), this.getColor(), this.getYear(), this.getMileage(), this.getPrice());
		return autoPrint;
	}
	
	
	
	
}
