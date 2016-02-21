package org.usfirst.frc.team3467.robot.subsystems.Brownout;

import java.util.Vector;

import org.usfirst.frc.team3467.robot.subsystems.Brownout.PowerConsumer;
import org.usfirst.frc.team3467.robot.subsystems.Brownout.commands.checkPower;

import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Brownout extends Subsystem {

	public int CHILLVOLTAGE = 9;
	public int CRITICALVOLTAGE = 7;

	public PowerDistributionPanel pdp; 

	//Sets PowerLevel as am enumeration
	public enum PowerLevel {
		//Sets the levels of power
	    Normal(1), Chill(2), Critical(3);
	    public int value;

	    //Sets the number received to a level
	    public static PowerLevel valueOf(int value) {
	      for (PowerLevel mode : values()) {
	        if (mode.value == value) {
	          return mode;
	        }
	      }
	      return null;
	    }

	    //Constructor for enumeration
	    private PowerLevel(int value) {
	      this.value = value;
	    }

	}
	
	// The current Power Level
	private PowerLevel	batteryLevel = PowerLevel.Normal;
	
	// Create vector of consumers to callback
	public static Vector <PowerConsumer> callbackList;

	//Brownout Class Constructor
	public Brownout() {
		//Instantiate PowerDistributionPanel
		pdp = new PowerDistributionPanel();
		
		// Instantiate power consumer callback list
		callbackList = new Vector<PowerConsumer>();
	}

	public void registerCallback(PowerConsumer consumerSubsys)
	{
		// Add power consumer subsystem to list
		callbackList.addElement(consumerSubsys);
	}

	// Initialize the Default Command
	protected void initDefaultCommand() {
		this.setDefaultCommand(new checkPower());
	}

	public double getVoltage() {
		return pdp.getVoltage();
	}
	
	public PowerLevel getLevel() {
		
		return batteryLevel;
	}
		
	public void checkLevel() {
		PowerLevel oldLevel = batteryLevel;

		//double voltage = pdp.getVoltage();
		double voltage = 12;
		//Sets first battery level to above 9 volts
		if (voltage >= CHILLVOLTAGE) {
			batteryLevel = PowerLevel.Normal;
		}
			
		//Sets second level to between 7 and 9 volts
		else if (voltage < CHILLVOLTAGE && voltage >= CRITICALVOLTAGE) {
			batteryLevel = PowerLevel.Chill;
		}
			
		//Sets third and final level to below 7 volts
		else if (voltage < CRITICALVOLTAGE) {
			batteryLevel = PowerLevel.Critical;
		}
		
		if (batteryLevel!= oldLevel) {
			notifyConsumers();
		}
	}
	
	public void notifyConsumers() {
		for (int i = 0; i < callbackList.size(); i++) {
			PowerConsumer consumer = (PowerConsumer) callbackList.elementAt(i);
			consumer.callbackAlert(batteryLevel);
		}
	}
}
