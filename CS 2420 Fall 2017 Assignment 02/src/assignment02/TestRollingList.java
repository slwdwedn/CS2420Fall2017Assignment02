package assignment02;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestRollingList {

	RollingList testObj;

	@Before
	public void setUp() throws Exception {
		testObj = new RollingList(1.0f, 5);
	}

	@After
	public void tearDown() throws Exception {
		testObj = null;
	}
	
	
	@Test (expected = IllegalArgumentException.class)
	public void constructorShouldThrowException() throws IllegalArgumentException
	{
		new RollingList(-0.5f, -50);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void getElementShouldThrowException() throws IndexOutOfBoundsException
	{
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		
		testObj.getElement(10);
	}
	
	@Test (expected = IndexOutOfBoundsException.class)
	public void setElementShouldThrowException() throws IndexOutOfBoundsException
	{
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		testObj.append(0.1);
		
		testObj.setElement(5, 0.0);
	}
	
	@Test
	public void appendShouldInsertInLastPosition()
	{
		testObj.append(0.1);
		testObj.append(0.2);
		testObj.append(0.3);
		testObj.append(0.4);
		testObj.append(0.5);
		
		double expected = 0.5;
		double actual = testObj.getElement(4);
		assertEquals(expected, actual, 0);
	}
	
	@Test
	public void appendedElementShouldBeTheLastEntry()
	{
		testObj.append(0.1);
		testObj.prepend(0.2);
		testObj.append(0.3);
		testObj.prepend(0.4);
		testObj.append(0.5);
		testObj.prepend(0.7);
		testObj.prepend(0.8);
		testObj.prepend(1.0);
		testObj.prepend(1.1);
		
		double expected = 0.5;
		double actual = testObj.getElement(testObj.size()-1);
		assertEquals(expected, actual, 0);
	}
	
}
