package ua.ithillel.hw8;

public class Obstacle {
	
	public static enum TypeOverCome{
		Jump,
		Run
	}
	
	private String _name;
	private Integer _value;
	private TypeOverCome _tyTypeOverCome;
	
	public Obstacle(
			String name, 
			Integer value,
			TypeOverCome tOverCome) {
		_name = name;
		_value = value;
		_tyTypeOverCome = tOverCome;
	}

	public String get_name() {
		return _name;
	}

	public Integer get_value() {
		return _value;
	}

	public TypeOverCome get_tyTypeOverCome() {
		return _tyTypeOverCome;
	}
	
}
