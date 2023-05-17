package ua.ithillel.hw14.coffee.order;

public class Order {
	
	private Integer number;
	private String clientName;

	public Order(
			Integer number, 
			String clientName) {
		this.number = number;
		this.clientName = clientName;
	}

	public Integer getNumber() {
		return number;
	}

	public String getClientName() {
		return clientName;
	}

}
