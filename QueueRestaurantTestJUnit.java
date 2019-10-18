import static org.junit.Assert.*;

import org.junit.Test;


public class QueueRestaurantTestJUnit {

	private QueueRestaurant<String> queue;
	
	public void initialize() throws AssertException
	{
		queue = new QueueRestaurant<String>();
	}
	@Test
	public void testAddOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Order<String> order = new Order<String>("Sandwich", 5);
		assertTrue(queue.addOrder(order));
		assertEquals(order,queue.completeOrder());
	}
	@Test
	public void testCompleteOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		assertNull(queue.checkNextCompletedOrder());
		Order<String> order1 = new Order<String>("Sandwich", 2);
		Order<String> order2 = new Order<String>("Sandwich", 3);
		Order<String> order3 = new Order<String>("Sandwich", 1);
		queue.addOrder(order1);
		queue.addOrder(order2);
		queue.addOrder(order3);
		assertEquals(order1, queue.completeOrder());
		assertEquals(order2, queue.completeOrder());
		assertEquals(order3, queue.completeOrder());
	}
	@Test
	public void testNumberRemainingOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		Order<String> order1 = new Order<String>("Mac", 1);
		Order<String> order2 = new Order<String>("Cheese", 1);
		queue.addOrder(order1);
		queue.addOrder(order2);
		assertEquals(2, queue.numberRemainingOrder());
		queue.completeOrder();
		queue.completeOrder();
	}
	@Test
	public void testCheckNextCompletedOrder() throws AssertException 
	{
		queue = new QueueRestaurant<String>();
		assertNull(queue.checkNextCompletedOrder());
		Order<String> order = new Order<String>("Sandwich", 5);
		queue.addOrder(order);
		assertEquals(order, queue.checkNextCompletedOrder());
		queue.completeOrder();
	}

}
