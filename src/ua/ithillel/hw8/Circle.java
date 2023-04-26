package ua.ithillel.hw8;

public class Circle implements IAreaCalculable {

	private Double _radius;
	public Circle(Double radius) {
		_radius = radius;
	}
	
	@Override
	public Double Area() {
		return Math.PI*_radius*_radius;
	}

}
