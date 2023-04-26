package ua.ithillel.hw8;

public class Obstacle {
	
	private String _name;
	private Integer _value;
	
	public Obstacle(
			String name, 
			Integer value) {
		_name = name;
		_value = value;
	}

	public String get_name() {
		return _name;
	}

	public Integer get_value() {
		return _value;
	}
	

}
