import java.util.ArrayList;
/**
 * Implementation of the Restaurant abstract class. Stores and completes tickets based on a stack data structure.
 * Tickets are treated in a LIFO manner. That is, the last ticket (most recent) to be added to the restaurant is
 * the first ticket to be completed. This is in contrast to the QueueRestaurant which operates how a restaurant
 * normally would.
 * 
 * @author Stephen  
 * @version 2018-10-10
 * 
 * @modified by Em Evans
 * @version 2019-09-30
 * Lab7
 * 
 * @modified by Em Evans
 * @version 2019-10-12
 * Lab9
 */
public class StackRestaurant<T> extends Restaurant<T> {

	private static final int ORDER_LIST_SIZE = 10;
	private ArrayList<Order<T>> orderList;
	private int topOfStack;
	
    /**
     * Create the stack restaurant. Initializes the Order storage variables.
     */
	public StackRestaurant()
	{
		orderList = new ArrayList<Order<T>>(ORDER_LIST_SIZE);
		topOfStack = -1;
	}
    /**
     * Add an order to the restaurant.
     * 
     * @param firstOrder The order to be added.
     * @return True. Because the StackRestaurant should resize if it runs out of room to store tickets, a ticket
     * should always be added, and this method should always return true.
     */
	@Override
	public boolean addOrder(Order<T> firstOrder)
	{
		orderList.add(firstOrder);
		topOfStack ++;
		return true;
	}
    /**
     * [Internal Code - This is not required by the specification but can be a useful construct.]
     */
	@Override
	protected Order<T> completeOrder()
	{
		Order<T> completedOrder;
		if(topOfStack > -1){
			completedOrder = orderList.get(topOfStack);
			orderList.remove(topOfStack);
			topOfStack --;
			return completedOrder;
		}
		else{
			return null;
		}
	}
    /**
     * Computes the number of orders in the restaurant that have not been completed.
     * 
     * @return the number of orders to complete.
     */
	@Override
	public int numberRemainingOrder()
	{
		return topOfStack + 1;
	}
	
	@Override
	protected Order<T> checkNextCompletedOrder()
	{
		return orderList.get(topOfStack);
	}
}