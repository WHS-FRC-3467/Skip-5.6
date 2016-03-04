package org.usfirst.frc.team3467.robot.subsystems.Brownout;

import java.util.Vector;

import org.usfirst.frc.team3467.robot.subsystems.Brownout.PowerConsumer;
import org.usfirst.frc.team3467.robot.subsystems.Brownout.commands.checkPower;

import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Brownout extends Subsystem {

	public static final double CHILLVOLTAGE = 9.0;
	public static final double CRITICALVOLTAGE = 6.9;

	// Brownout is a singleton
	private static Brownout instance = new Brownout();

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

	// Get an instance of Brownout
	public static Brownout getInstance() {
	    return Brownout.instance;
	}

	/*
	 * Brownout Class Constructor
	 *
	 * The singleton instance is created statically with
	 * the instance static member variable.
	 */
	protected Brownout() {
		
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
	
	public double getTotalCurrent() {
		return pdp.getTotalCurrent();
	}
	
	public double getCurrent(int channel) {
		return pdp.getCurrent(channel);
	}
	
	public PowerLevel getLevel() {
		return batteryLevel;
	}
		
	public void checkLevel() {
		PowerLevel oldLevel = batteryLevel;

		double voltage = pdp.getVoltage();

		// If voltage is "Chill" level or above, then we're cool
		if (voltage >= CHILLVOLTAGE) {
			batteryLevel = PowerLevel.Normal;
			SmartDashboard.putString("Brownout Subsystem", "Normal");
		}
			
		// If voltage has dropped but is still above "Critical" level,
		// then set a warning
		else if (voltage < CHILLVOLTAGE && voltage >= CRITICALVOLTAGE) {
			batteryLevel = PowerLevel.Chill;
			SmartDashboard.putString("Brownout Subsystem", "Warning");
		}
			
		// If voltage below "Critical" level...
		else if (voltage < CRITICALVOLTAGE) {
			batteryLevel = PowerLevel.Critical;
			SmartDashboard.putString("Brownout Subsystem", "Critical");
		}
		
		
		// If level has changed, then let everyone who cares know about it
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
