/**
    * Author: Mary McCready
    * Class: CSE 360 2019 Summer C (41792)
    * Assignment #2
    * This program adds.
    */


package cse360assign2;

import java.util.ArrayList;
import java.util.List;

/**
 * AddingMachine is the base class for the AddingMachine program.
 * 
 * @author marymccready
 *
 */
public class AddingMachine {

	/** The total amount. */
	private int total;
	
	/** The list that contains the history of additions and
	 * subtractions.
	 */
	private List<String> history = new ArrayList<String>();
	
	/** The string output used by toString.*/
	private String stringBuilder;
	
	/** 
	 * Sole class constructor for AddingMachine.
	 */
	public AddingMachine () {
		total = 0;  // not needed - included for clarity
	}
	
	/**
	 * The method used to get the current total.
	 * 
	 * @return total as int.
	 */
	public int getTotal () {
		return total;
	}
	
	/**
	 * The method used to add the parameter value to the total.
	 * 
	 * @param value (required) to be added to total.
	 */
	public void add (int value) {
		total = total + value;
		history.add(" + " + value);
		
	}
	
	/**
	 * The method used to subtract the parameter value from the total.
	 * 
	 * @param value (required) to be subtracted from total.
	 */
	public void subtract (int value) {
		total = total - value;
		history.add(" - " + value);
	}
		
	/**
	 * The method used to convert the output to a string.
	 * 
	 * @return String with the calculation history.
	 */
	public String toString () {
		stringBuilder = "0";
		for (int element = 0; element < history.size(); element++) {
			stringBuilder = stringBuilder + history.get(element);
		}
		return stringBuilder;
	}

	/**
	 * The method used to clear the total and history.
	 */
	public void clear() {
		total = 0;
		stringBuilder = null;
	}
}
