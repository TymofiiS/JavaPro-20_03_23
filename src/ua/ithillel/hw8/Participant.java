package ua.ithillel.hw8;

import java.util.Map;

public class Participant {
	
	private Map<Obstacle.TypeOverCome, Integer> _limits;
	private String _name;
	
	public Participant(
			Map<Obstacle.TypeOverCome, Integer> limits,
			String name) {
		_limits = limits;
		_name = name;
	}
	
	public Boolean Overcome(Obstacle obs) {
		
		// Find limit value base on obstacle type
		var limitValue = 0;	
		for (Map.Entry<Obstacle.TypeOverCome, Integer> entry : _limits.entrySet()) {
			if(obs.get_tyTypeOverCome() != entry.getKey()) {continue;}
			
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
