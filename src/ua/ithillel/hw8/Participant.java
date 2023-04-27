package ua.ithillel.hw8;

import java.util.List;

public class Participant {
	
	public List<ISkillable> _skills;
	
	public Participant(
			List<ISkillable> skills) {
		_skills = skills;
	}
	
	public String get_name() {
		return this.getClass().getSimpleName();
	}
	
	public Boolean Overcome(Obstacle obstacle) {
		
		// Find skill which deal with the obstacle
		ISkillable skill = null;
		for (var entry : _skills) {
			
			if(!entry.CanDealWith(obstacle)){continue;}
			
			// Get skill value
			skill = entry;
			break;
		}
		
		// Check if skill exist
		if(skill == null) {
			System.out.println(
					get_name() 
					+ " has no skill for overcome "
					+ obstacle.get_name() 
					+ " obstacle");
			return false;
		}
	
		// Pass obstacle
		if(skill.CanOverCome(obstacle)) {
			System.out.println(
					get_name() + " overcomed " + obstacle.get_name() 
					+ " with value " + obstacle.get_value() 
					+ " using skill: " + skill.typeName() );
			return true;
		}else {
			System.out.println(
					get_name() + " did not overcome " + obstacle.get_name() 
					+ " with value " + obstacle.get_value()
					+ ". Passed only " + skill.get_value());
			return false;
		}

	}
	
	public static void Competition(
			Obstacle[] obstacles, 
			Participant[] participants ) {
		
		for (Participant participant : participants) {
			for (Obstacle obstacle : obstacles) {
				var overcome = participant.Overcome(obstacle);
				if(!overcome) {break;}
			}
		}

	}
}
