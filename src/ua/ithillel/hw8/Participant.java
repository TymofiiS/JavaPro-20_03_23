package ua.ithillel.hw8;

import java.util.Map;

public class Participant {
	
	public Map<String, Integer> _limits;
	private String _name;
	
	public Participant(
			Map<String, Integer> limits, 
			String name) {
		_name = name;
		_limits = limits;
	}
	
	public Boolean Overcome(Obstacle obs) {
		
		// Find limit value base on obstacle type
		var limitValue = 0;	
		for (Map.Entry<String, Integer> entry : _limits.entrySet()) {
			if(obs.getClass().getSimpleName() != entry.getKey()) {continue;}
			
			limitValue = entry.getValue();
			break;
		}
	
		// Pass obstacle
		if(limitValue >= obs.get_value() ) {
			System.out.println(
					_name + " overcomed " + obs.get_name() 
					+ " with value " + obs.get_value());
			return true;
		}else {
			System.out.println(
					_name + " did not overcome " + obs.get_name() 
					+ " with value " + obs.get_value()
					+ ". Passed only " + limitValue);
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
