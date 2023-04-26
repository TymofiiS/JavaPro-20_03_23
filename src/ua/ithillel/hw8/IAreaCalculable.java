package ua.ithillel.hw8;

public interface IAreaCalculable {
	Double Area();
	
	static Double TotalArea(IAreaCalculable[] arr) {
		var res = 0.0;
		
		for (IAreaCalculable iAreaCalculable : arr) {
			res += iAreaCalculable.Area();
		}
		
		return res;
	}
}
