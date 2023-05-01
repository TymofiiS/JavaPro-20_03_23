package ua.ithillel.hw8;


public class Triangle implements IAreaCalculable {

	private Double _a;
	private Double _ha;
	public Triangle(Double a, Double ha) {
		_a = a;
		_ha=ha;
	}
	
	@Override
	public Double Area() {
		return _a*_ha/2;
	}

}
