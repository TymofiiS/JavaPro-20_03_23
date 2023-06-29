package ua.ithillel.hw19;

public class IncorrectStructure extends RuntimeException {
	
	private String message;

	public IncorrectStructure(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
}
