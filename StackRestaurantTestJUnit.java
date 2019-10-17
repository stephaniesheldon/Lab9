import static org.junit.Assert.*;

import org.junit.Test;


public class StackRestaurantTestJUnit<T> {

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

	@Test
	public void testCompleteOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		
		Order<String> actual = stack.completeOrder();
		Order<String> expected = (Order<String>) lastOrder;
		assertEquals(expected, actual);
		
		int actualRemaining = stack.numberRemainingOrder();
		int expectedRemaining = 2;
		assertEquals(expectedRemaining, actualRemaining);
	}
	
	@Test
	public void testNumberRemainingOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		
		int expected = 3;
		int actual = stack.numberRemainingOrder();
		assertEquals(expected, actual);
	}
	
	@Test
	public void testCheckNextCompletedOrder() throws AssertException 
	{
		initialize();
		stack.addOrder((Order<String>) firstOrder);
		stack.addOrder((Order<String>) secondOrder);
		stack.addOrder((Order<String>) lastOrder);
		Order<T> expected = lastOrder;
		Order<String> actual = stack.checkNextCompletedOrder();
		assertEquals(expected, actual);
	}

}
