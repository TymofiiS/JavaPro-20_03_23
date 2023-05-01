package ua.ithillel.hw8;

public class Rectangle implements IAreaCalculable {

	private Double _a;
	private Double _b;
	public Rectangle(Double a, Double b) {
		_a = a;
		_b=b;
	}
	
	@Override
	public Double Area() {
		return _a*_b;
	}

}