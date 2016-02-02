package org.usfirst.frc.team3467.robot.subsystems.Brownout;

import java.util.Vector;

import org.usfirst.frc.team3467.robot.subsystems.Brownout.PowerConsumer;

import edu.wpi.first.wpilibj.PowerDistributionPanel;

public class Brownout {

	public PowerDistributionPanel Hera = new PowerDistributionPanel();

	PowerDistributionPanel pdp = new PowerDistributionPanel();
	double current = pdp.getCurrent(1);
	double voltage = Hera.getVoltage();

	public double getVoltage() {
		return voltage;
	}
	
	public enum PowerLevel
	{
	    Normal(1), Chill(2), Critical(3);
	    public int value;

	    public static PowerLevel valueOf(int value) {
	      for (PowerLevel mode : values()) {
	        if (mode.value == value) {
	          return mode;
	        }
	      }
	      return null;
	    }

	    private PowerLevel(int value) {
	      this.value = value;
	    }

	}
	
	// The current Power Level
	private PowerLevel	currentPowerLevel = PowerLevel.Normal;
	
	// Create vector of consumers to callback
	public static Vector <PowerConsumer> callbackList;

	public Brownout() {

		// Instantiate power consumer callback list
		callbackList = new Vector<PowerConsumer>();

	}

	public void registerCallback(PowerConsumer consumerSubsys)
	{
		// Add power consumer subsystem to list
		callbackList.addElement(consumerSubsys);
	}
	public int batteryLevel = 1;
	public int CHILLVOLTAGE = 9;
	public int CRITICALVOLTAGE = 7;

	public int getLevel() {
		
		//Sets first battery level to above 9 volts
		if (voltage >= CHILLVOLTAGE) {
			batteryLevel = 1;
		}
			
		//Sets second level to between 7 and 9 volts
		if (voltage < CHILLVOLTAGE && voltage >= CRITICALVOLTAGE) {
			batteryLevel = 2;
		}
			
		//Sets third and final level to below 7 volts
		if (voltage < CRITICALVOLTAGE) {
			batteryLevel = 3;
		}
		
		return batteryLevel;
	}	
	public void notifyConsumers()
	{
		for (int i = 0; i < callbackList.size(); i++)
		{
			PowerConsumer consumer = (PowerConsumer) callbackList.elementAt(i);
			consumer.callbackAlert(currentPowerLevel);
		}

	}
}
