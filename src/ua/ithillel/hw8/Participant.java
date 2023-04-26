package ua.ithillel.hw8;

import java.util.List;

public class Participant {
	
	public List<Skill> _skills;
	private String _name;
	
	public Participant(
			String name,
			List<Skill> skills) {
		_name = name;
		_skills = skills;
	}
	
	public Boolean Overcome(Obstacle obs) {
		
		// Find skill which deal with the obstacle
		Skill skill = null;
		for (var entry : _skills) {
			
			if(obs.typeName() != entry.get_dealWith())
			{continue;}
			
			// Get skill value
			skill = entry;
			break;
		}
		
		// Check if skill exist
		if(skill == null) {
			System.out.println(
					_name + " have no skill for overcome this obstacle: " 
					+ obs.get_name());
			return false;
		}
	
		// Pass obstacle
		if(skill.get_limit() >= obs.get_value() ) {
			System.out.println(
					_name + " overcomed " + obs.get_name() 
					+ " with value " + obs.get_value() 
					+ " using skill: " + skill.getClass().getSimpleName() );
			return true;
		}else {
			System.out.println(
					_name + " did not overcome " + obs.get_name() 
					+ " with value " + obs.get_value()
					+ ". Passed only " + skill.get_limit());
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
