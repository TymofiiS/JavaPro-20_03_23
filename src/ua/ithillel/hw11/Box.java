package ua.ithillel.hw11;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {

	private List<T> items;
	
	private String name;
	
	public static boolean printLog = true;
	
	public Box(String name){
		items = new ArrayList<T>();
		this.name = name;
	}
	
	public List<T> getItems(){
		return items;
	}
	
	public String getName(){
		return name;
	}
	
	public void add(T item) {
		items.add(item);
		
		printLog("Current count of " + name + " is " + items.size());
	}
	
	public void addMany(List<T> items) {
		this.items.addAll(items);
		
		printLog("Current count of " + name + " is " + items.size());
	}
	
	public Double getWeight() {
		var res = 0.0;
		for (T t : items) {
			res+=t.getWeight();
		}
		
		printLog("Current weight of " + name + " is " + res);
		return res;
	}
	
	public boolean compare(Box<? extends Fruit> seconde) {
		var res = 
				this.getWeight().equals(seconde.getWeight());
		
		printLog(name + " is equal to " + seconde.getName() + " : " + res);
		return res;
	}
	
	public void merge(Box<T> source) {
		this.addMany(source.getItems());
		source.getItems().clear();
		
		printLog("Current count of " + name + " is " + items.size());
		printLog("Current count of " + source.getName() + " is " + source.getItems().size());
	}
	
	private void printLog(String str) {
		if(!printLog) return;
		System.out.println(str);
	}
}
