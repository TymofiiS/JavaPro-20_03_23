package ua.ithillel.hw8;

public class Obstacle {
	
	private Integer _value;
	
	public Obstacle(
			Integer value) {
		_value = value;
	}

	public Integer get_value() {
		return _value;
	}
	
	public String name() {
		return this.getClass().getSimpleName();
	}
	
	private String parentName() {
		return this.getClass().getSuperclass().getSimpleName();
	}
	
	public Boolean canDealWith(Obstacle obstacle) {
		
		if(obstacle == null) {return false;}
		
		return this.parentName() == obstacle.name();
	}
	
	public Boolean canOverCome(Obstacle obstacle) {
		
		if(obstacle == null) {return true;}
		
		return this.get_value() >= obstacle.get_value();
	}
}
