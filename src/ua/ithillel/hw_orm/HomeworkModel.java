package ua.ithillel.hw_orm;

public class HomeworkModel{
	
	@Column(name = "id")
	private int homeworkId;

	@Column(name = "name")
	private String homeworkName;
	
	private String description;

	@Override
	public String toString() {
		return "Homework ["
				+ "homeworkId=" + homeworkId 
				+ ", homeworkName=" + homeworkName 
				+ ", description=" + description
				+ "]";
	}
}
