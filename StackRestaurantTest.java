import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Lab 9
 *
 * Test suite for the StackRestaurant class.
 *
 * @author Em Evans
 * @version 2019-10-14
 * @param <T>
 * @param <T>
 *
 */
public class StackRestaurantTest<T> {

	private StackRestaurant<String> stack;
	private Order<T> firstOrder = new Order("Pizza", 1);
	private Order<T> secondOrder = new Order("Pasta", 2);
	private Order<T> lastOrder = new Order("Calzone", 3);
	
	public void initialize() throws AssertException
	{
		stack = new StackRestaurant<String>();
		
	}

	@Test
	public void testAddOrder() throws AssertException 
	{
		initialize();
		assertTrue(stack.addOrder((Order<String>) firstOrder));
		
		Order<String> expected = (Order<String>) firstOrder;
		Order<String> actual = stack.checkNextCompletedOrder();
		assertEquals(expected, actual);
	}

	public void testCompleteOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		
		Order<String> actual = stack.completeOrder();
		Order<String> expected = (Order<String>) lastOrder;
		Assert.assertEquals(expected, actual);
		
		int actualRemaining = stack.numberRemainingOrder();
		int expectedRemaining = 2;
		Assert.assertEquals(expectedRemaining, actualRemaining);
	}
	
	
	public void testNumberRemainingOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		
		int expected = 3;
		int actual = stack.numberRemainingOrder();
		Assert.assertEquals(expected, actual);
	}
	

	public void testCheckNextCompletedOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		Order<T> expected = lastOrder;
		Order<String> actual = stack.checkNextCompletedOrder();
		Assert.assertEquals(expected, actual);
	}
}

