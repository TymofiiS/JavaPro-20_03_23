package ua.ithillel.hw15;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


public class Product {

	public static enum ProductType{
		Book,
		Toy,
		Pen
	}
	
	private static int currentId = 1;
	
	public static Map<Product.ProductType, List<Product>> groupProductsByType(
			List<Product> products)
	{
		// Check initial data
		if(products == null ||
			products.size() == 0) 
			{return null;}
		
		return products.stream()
		        .collect(Collectors.groupingBy(x->x.type));
	}
	
	
	public static double getTypesTotalPrice(
			List<Product> products, 
			LocalDate addedAfter,
			double priceLimit,
			Product.ProductType type)
	{
		// Check initial data
		if(products == null ||
			products.size() == 0 ||
			priceLimit == 0 ||
			addedAfter == null) 
			{return 0;}
		
		return products.stream()
				.filter(x -> x.createDate.compareTo(addedAfter) > 0)
				.filter(x -> x.price < priceLimit)
				.filter(x -> x.type == type)
				.mapToDouble(x -> x.price)
				.sum();
	}
	
	public static List<Product> getRecentTypes(
			List<Product> products, 
			int count)
	{
		// Check initial data
		if(products == null ||
			products.size() == 0 ||
			count == 0) 
			{return new ArrayList<Product>();}
		
		return products.stream()
				.sorted((o1, o2)-> 
					o2.createDate.compareTo(o1.createDate))
				.limit(count)
				.collect(Collectors.toList());
	}
	
	public static Product getTypeWithMinPrice(
			List<Product> products, 
			Product.ProductType type)
	{
		// Check initial data
		if(products == null || products.size() == 0) 
			{return null;}
		
		try {
			return products.stream()
					.filter(x -> x.type == type)
					.sorted((o1, o2)-> 
						Double.compare(o1.price, o2.price))
					.collect(Collectors.toList())
					.get(0);
		} catch (Exception e) {
			throw new ProductNotFoundException(type);
		}

	}		
	
	public static List<Product> getTypeWithHighPrice(
			List<Product> products, 
			Product.ProductType type,
			double highPrice)
	{
		// Check initial data
		if(products == null || products.size() == 0) 
			{return new ArrayList<Product>();}
		
		return products.stream()
				.filter(x -> x.type == type)
				.filter(x -> x.price > highPrice)
				.toList();
	}
	
	public static List<Product> getTypeWithApplyedDiscount(
			List<Product> products,
			Product.ProductType type,
			int discountValue)
	{
		// Check initial data
		if(products == null || products.size() == 0) 
			{return new ArrayList<Product>();}
		
		return
				products.stream()
				.filter(x -> x.type == type && x.discount)
				.map(x -> x.cloneWithDiscount(discountValue))
				.collect(Collectors.toList());
	}
	
	
	private int id;
	private ProductType type;
	private double price;
	private boolean discount;
	private LocalDate createDate;
	
	public Product(
			ProductType type, 
			double price, 
			boolean allowDiscount, 
			LocalDate addedDate) {
		this.id = Product.currentId++;
		this.type = type;
		this.price = price;
		this.discount = allowDiscount;
		this.createDate = addedDate;
	}
	
	public Product cloneWithDiscount(int discountValue) {
		discountValue = (discountValue >= 0 && discountValue < 100)
				?discountValue:0;
		return new Product(
						type, 
						price*(100-discountValue)/100, 
						discount, 
						createDate);
	}
	
	
	@Override
	public String toString() {
		return "\n\t{id: " + id +
			    ", type: " + type + 
				", price: " + price + 
				", discount: " + discount + 
				", createDate: " + createDate + "}";
	}
	
}



