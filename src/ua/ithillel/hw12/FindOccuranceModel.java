package ua.ithillel.hw12;

public class FindOccuranceModel {

	protected String value;
	protected Integer count;
	
	public <T> FindOccuranceModel(
			T obj, Integer occuranceCount) {
		this.value = obj.toString();
		this.count = occuranceCount;
	}
	
	public String toString() {
		return "{name: " + value + ", "
				+ "occurrence: " + count + "}";
	}
	
	public String toStringShort() {
		return value + " : " + count;
	}
}
