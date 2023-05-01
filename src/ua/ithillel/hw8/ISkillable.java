package ua.ithillel.hw8;

public interface ISkillable {
	Boolean canDealWith(Obstacle obstacle);
	Boolean canOverCome(Obstacle obstacle);
	String name();
	Integer get_value();
}
