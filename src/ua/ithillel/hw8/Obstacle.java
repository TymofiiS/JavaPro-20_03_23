package ua.ithillel.hw8;

public class Obstacle {
	
	private Integer _value;
	
	public Obstacle(
			Integer value) {
		_value = value;
	}

	public String get_name() {
		return typeName().toLowerCase();
	}

	public Integer get_value() {
		return _value;
	}
	
	public String typeName() {
		return this.getClass().getSimpleName();
	}
	
	public String parentName() {
		return this.getClass().getSuperclass().getSimpleName();
	}
}
