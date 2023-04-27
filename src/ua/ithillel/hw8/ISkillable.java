package ua.ithillel.hw8;

public interface ISkillable {
	Boolean CanDealWith(Obstacle obstacle);
	Boolean CanOverCome(Obstacle obstacle);
	String typeName();
	Integer get_value();
}
