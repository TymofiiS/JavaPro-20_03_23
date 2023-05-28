package ua.ithillel.hw15;

import java.text.MessageFormat;

public class ProductNotFoundException extends RuntimeException {

	private Product.ProductType type;
	
	public ProductNotFoundException(Product.ProductType type) {
		this.type = type;
	}
	
	public String getMessage() {
		return MessageFormat.format(
				"Product [type: {0} ] not found", type);
	}
}
