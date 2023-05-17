package ua.ithillel.hw14.coffee.order;

import java.util.LinkedList;

public class CoffeeOrderBoard {

	private LinkedList<Order> queue;
	private Integer currentNumber;
	
	public CoffeeOrderBoard(Integer initialNumber) {
	    queue = new LinkedList<Order>();
	    currentNumber = initialNumber;
	}
	
	public void add(String clientName) {
		if(clientName == null) {return;}
		queue.add(
				new Order(
						currentNumber++,
						clientName));
	}
	
	public Order deliver() {
		return queue.poll();
	}
	
	public Order deliver(Integer number) {
		if(number == null) {return null;}
		
        var list_Iter = 
        		queue.listIterator(0);
        
        while(list_Iter.hasNext()){     	
        	Order order = list_Iter.next();
        	
        	if(!order.getNumber().equals(number))
				{continue;}
        	
        	queue.remove(order);
        	return order;
        }
		
		return null;
	}
	
	public void draw() {
		System.out.println("\n======================");
		System.out.println("Num\t|\tName");
		System.out.println("======================");
		for (Order order : queue) {
			System.out.println(
					order.getNumber() + "\t|\t" + order.getClientName());
		}
	}

}
