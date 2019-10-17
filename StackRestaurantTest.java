/**
 * Lab 9
 *
 * Test suite for the StackRestaurant class.
 *
 * @author Em Evans
 * @version 2019-10-14
 * @param <T>
 *
 */
public class StackRestaurantTest {

	private StackRestaurant<String> stack;
	private Order<String> firstOrder = new Order("Pizza", 1);
	private Order<String> secondOrder = new Order("Pasta", 2);
	private Order<String> lastOrder = new Order("Calzone", 3);
	
	public void initialize() throws AssertException
	{
		stack = new StackRestaurant<String>();
		
	}
	/**
	 * test addOrder()
	 * @throws AssertException
	 */
	public void testAddOrder() throws AssertException 
	{
		initialize();
		Assert.assertTrue(stack.addOrder(firstOrder));
		
		Order<String> expected = new Order("Pizza",1);
		Order<String> actual = stack.checkNextCompletedOrder();
		Assert.assertEquals(expected, actual);
	}
	/**
	 * test completeOrder() using at least three orders
	 * show the ordering specific to stack
	 * 
	 * @throws AssertException
	 */
	public void testCompleteOrder() throws AssertException 
	{
		initialize();
		stack.addOrder(firstOrder);
		stack.addOrder(secondOrder);
		stack.addOrder(lastOrder);
		
		Order<String> actual = stack.completeOrder();
		Order<String> expected = lastOrder;
		Assert.assertEquals(expected, actual);
		
		int actualRemaining = stack.numberRemainingOrder();
		int expectedRemaining = 2;
		Assert.assertEquals(expectedRemaining, actualRemaining);
	}
	/**
	 * test numberRemainingOrder() with at least 2 orders
	 * 
	 * @throws AssertException
	 */
	public void testNumberRemainingOrder() throws AssertException 
	{
		initialize();
		stack.addOrder(firstOrder);
		stack.addOrder(secondOrder);
		stack.addOrder(lastOrder);
		
		int expected = 3;
		int actual = stack.numberRemainingOrder();
		Assert.assertEquals(expected, actual);
	}
	/**
	 * test both cases of completeOrder
	 * @throws AssertException
	 */
	public void testCheckNextCompletedOrder() throws AssertException 
	{
		initialize();
		stack.addOrder(firstOrder);
		stack.addOrder(secondOrder);
		stack.addOrder(lastOrder);
		Order<String> expected = new Order("Calzon",3);
		Order<String> actual = stack.checkNextCompletedOrder();
		Assert.assertEquals(expected, actual);
	}
}

