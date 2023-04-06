package hw3_1;

public class Car 
{
	private void startElectricity()
	{
		System.out.println("startElectricity Boobryded");
	};

	private void startCommand() 
	{
		System.out.println("startCommand Boobryded");
	};

	private void startFuelSystem() 
	{
		System.out.println("startFuelSystem Boobryded");
	};
	
	public void start() 
	{
		this.startCommand();
		this.startElectricity();
		this.startFuelSystem();
	}
}
