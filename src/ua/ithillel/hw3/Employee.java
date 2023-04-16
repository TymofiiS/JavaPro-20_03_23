package ua.ithillel.hw3;

public class Employee {
	
	private String fullName;
	private String position;
	private String email;
	private String phoneNumber;
	private Integer age;
	
	public Employee(
			String fullName,
			String position,
			String email,
			String phoneNumber,
			Integer age) {
		
		this.fullName = fullName;
		this.position = position;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.age = age;
		
		System.out.println("Employee created");
	}
}


