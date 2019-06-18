package cse360assign2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AddingMachineTest {

	// test get initial total
	@Test
	public void testGetTotal() {
		
		AddingMachine myCalculator = new AddingMachine();
		int result = myCalculator.getTotal();
		assertEquals(0, result);
	}
	
	// test get total after additions and subtractions
	@Test
	public void testGetTotal2() {
		AddingMachine myCalculator = new AddingMachine();
		myCalculator.add(4);
		myCalculator.subtract(2);
		myCalculator.add(5);
		int result = myCalculator.getTotal();
		assertEquals(7, result);
	}

	// test add
	@Test
	public void testAdd() {
		AddingMachine myCalculator = new AddingMachine();
		myCalculator.add(4);
		int result = myCalculator.getTotal();
		assertEquals(4, result);
		
	}

	// test subtract
	@Test
	public void testSubtract() {
		AddingMachine myCalculator = new AddingMachine();
		myCalculator.subtract(2);
		int result = myCalculator.getTotal();
		assertEquals(-2, result);
	}

	// test toString after additions and subtractions
	@Test
	public void testToString() {
		AddingMachine myCalculator = new AddingMachine();
		myCalculator.add(4);
		myCalculator.subtract(2);
		myCalculator.add(5);
		String result = myCalculator.toString();
		assertEquals("0 + 4 - 2 + 5", result);
	}

	// test clear after additions and subtractions
	@Test
	public void testClear() {
		AddingMachine myCalculator = new AddingMachine();
		myCalculator.add(4);
		myCalculator.subtract(2);
		myCalculator.add(5);
		myCalculator.clear();
		int result = myCalculator.getTotal();
		assertEquals(0, result);
	}

}
