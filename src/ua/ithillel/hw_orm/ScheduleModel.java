package ua.ithillel.hw_orm;

import java.util.Date;

public class ScheduleModel{
	
	@Column(name = "id")
	private int scheduleId;

	@Column(name = "name")
	private String scheduleName;
	
	@Column(name = "updatedAt")
	private Date updatedDate;

	@Override
	public String toString() {
		return "Schedule [scheduleId=" + scheduleId 
				+ ", scheduleName=" + scheduleName 
				+ ", updatedDate=" + updatedDate
				+ "]";
	}
}
