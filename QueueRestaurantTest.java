/**
 * Lab 9
 *
 * Test suite for the QueueRestaurant class.
 *
 * @author Em Evans
 * @version 2019-10-14
 *
 */
public class QueueRestaurantTest {

	private QueueRestaurant<String> queue;
	
	public void initialize() throws AssertException
	{
		queue = new QueueRestaurant<String>();
	}
	/**
	 * test addOrder()
	 * @throws AssertException
	 */
	public void testAddOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Order<String> order = new Order<String>("Sandwich", 5);
		Assert.assertTrue(queue.addOrder(order));
		Assert.assertEquals(order,queue.completeOrder());
	}
	/**
	 * test completeOrder() using at least three orders
	 * show the ordering specific to queue
	 * 
	 * @throws AssertException
	 */
	public void testCompleteOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Assert.assertNull(queue.checkNextCompletedOrder());
		Order<String> order1 = new Order<String>("Sandwich", 2);
		Order<String> order2 = new Order<String>("Sandwich", 3);
		Order<String> order3 = new Order<String>("Sandwich", 1);
		queue.addOrder(order1);
		queue.addOrder(order2);
		queue.addOrder(order3);
		Assert.assertEquals(order1, queue.completeOrder());
		Assert.assertEquals(order2, queue.completeOrder());
		Assert.assertEquals(order3, queue.completeOrder());
	}
	/**
	 * test numberRemainingOrder() with at least 2 orders
	 * 
	 * @throws AssertException
	 */
	public void testNumberRemainingOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Order<String> order1 = new Order<String>("Mac", 1);
		Order<String> order2 = new Order<String>("Cheese", 1);
		queue.addOrder(order1);
		queue.addOrder(order2);
		Assert.assertEquals(2, queue.numberRemainingOrder());
		queue.completeOrder();
		queue.completeOrder();
	}
	/**
	 * test both cases of completeOrder
	 * @throws AssertException
	 */
	public void testCheckNextCompletedOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Assert.assertNull(queue.checkNextCompletedOrder());
		Order<String> order = new Order<String>("Sandwich", 5);
		queue.addOrder(order);
		Assert.assertEquals(order, queue.checkNextCompletedOrder());
		queue.completeOrder();
	}
}
