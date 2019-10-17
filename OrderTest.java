import static org.junit.Assert.*;

import org.junit.Test;


public class OrderTest<T> {
	private Order<T> firstOrder;
	private Order<T> secondOrder;
	private Order<T> sameOrder;

	private void initialize(){
		
		firstOrder = new Order("Pizza",1);
		secondOrder = new Order("Pasta",2);
		sameOrder = new Order("Pizza",1);
	}
	@Test
	public void gettertest() {
		initialize();
		T expected = (T) "Pizza";
		T actual = firstOrder.getDescription();
		assertEquals(expected, actual);
		
		int actualTime = firstOrder.getTimeOrdered();
		int expectedTime = 1;
		assertEquals(expectedTime, actualTime);

	}
	/*
	  * @param other The other ticket to compare this one to.
	     * @return -1 if this ticket was created before the other ticket
	     *          0 if this ticket was created at the same time as the other ticket
	     *          1 if this ticket was created after the other ticket
	     *          */
	
	@Test
	public void compareToTest(){
		initialize();
		int expected = -1;
		int actual = firstOrder.compareTo(secondOrder);
		assertEquals(expected, actual);
		
		expected = 0;
		actual = firstOrder.compareTo(sameOrder);
		assertEquals(expected, actual);
		
		expected = 1;
		actual = secondOrder.compareTo(firstOrder);
		assertEquals(expected, actual);
		
	}

}
