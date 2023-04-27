package ua.ithillel.hw8;

public interface ISkillable {
	Boolean canDealWith(Obstacle obstacle);
	Boolean canOverCome(Obstacle obstacle);
	String typeName();
	Integer get_value();
}
