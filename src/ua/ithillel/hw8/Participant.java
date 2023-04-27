package ua.ithillel.hw8;

import java.util.List;

public class Participant {
	
	public List<ISkillable> _skills;
	
	public Participant(
			List<ISkillable> skills) {
		_skills = skills;
	}
	
	private String name() {
		return this.getClass().getSimpleName();
	}
	
	public Boolean overcome(Obstacle obstacle) {
		
		// Find skill which deal with the obstacle
		ISkillable skill = null;
		for (var entry : _skills) {
			
			if(!entry.canDealWith(obstacle)){continue;}
			
			// Get skill value
			skill = entry;
			break;
		}
		
		// Check if skill exist
		if(skill == null) {
			System.out.println(
					name() 
					+ " has no skill for overcome "
					+ obstacle.name() 
					+ " obstacle");
			return false;
		}
	
		// Pass obstacle
		if(skill.canOverCome(obstacle)) {
			System.out.println(
					name() + " overcomed " + obstacle.name() 
					+ " with value " + obstacle.get_value() 
					+ " using skill: " + skill.typeName() );
			return true;
		}else {
			System.out.println(
					name() + " did not overcome " + obstacle.name() 
					+ " with value " + obstacle.get_value()
					+ ". Passed only " + skill.get_value());
			return false;
		}

	}
	
	public static void competition(
			Obstacle[] obstacles, 
			Participant[] participants ) {
		
		for (Participant participant : participants) {
			for (Obstacle obstacle : obstacles) {
				var overcome = participant.overcome(obstacle);
				if(!overcome) {break;}
			}
		}

	}
}
