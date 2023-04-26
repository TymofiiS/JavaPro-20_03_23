package ua.ithillel.hw8;

public class Skill {
	private Integer _limit;
	private String _dealWith;
	
	public Skill(
			Integer limit, 
			String dealWith) {
		_limit = limit;
		_dealWith = dealWith;
	}
	
	public Integer get_limit() {
		return _limit;
	}

	public String get_dealWith() {
		return _dealWith;
	}
	
}
