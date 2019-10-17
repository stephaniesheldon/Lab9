/**	
 * Class representing a restaurant. Food orders may be added to a restaurant as Orders and will be
 * stored in some way (how they are stored is up to the subclasses). The order in which Orders are
 * completed is also dependent on the subclass' implementation of the abstract methods.
 * 
 * @author Stephen
 * @version 2018-10-10
 * 
 * @modified by Em Evans
 * @version 2019-09-27
 * Lab 9
 */

public class Order<T> implements Comparable<Order<T>>
{
	/**
	 * The description of the order. i.e. what food was ordered.
	 */
	private T description;
	/**
	 * The time (represented as an int) that the customers ordered it.
	 */
	private int timeOrdered;
	
    /**
     * Create an Order. Set all attributes. 
     * 
     * @param description 
     * @param timeOrdered
     */
	public Order(T description, int timeOrdered)
	{
		this.description = description;
		this.timeOrdered = timeOrdered;
	}
	/**
	 * @return description
	 */
	public T getDescription()
	{
		return description;
	}
	/**
	 * @return timeOrdered
	 */
	public int getTimeOrdered()
	{
		return timeOrdered;
	}
	/**
	 * toString override. 
	 * @return a String of the format "Description: <<description>>"
	**/
	@Override
	public String toString()
	{
		return description.toString();
	}
    /**
     * Comparison override. Comparison for Orders sorts the orders in order of when the order
     * was created.
     * 
     * @param other The other ticket to compare this one to.
     * @return -1 if this ticket was created before the other ticket
     *          0 if this ticket was created at the same time as the other ticket
     *          1 if this ticket was created after the other ticket
     *          */
	@Override
	public int compareTo(Order<T> order)
	{
		if (this.timeOrdered < order.timeOrdered )
			return -1;
		else if(this.timeOrdered == order.timeOrdered)
			return 0;
		else
			return 1;
	}
}
