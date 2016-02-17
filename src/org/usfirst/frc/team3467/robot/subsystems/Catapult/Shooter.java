package org.usfirst.frc.team3467.robot.subsystems.Catapult;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Shooter extends PIDSubsystem{

	//Catapult Objects
	public CANTalon can;
	public Solenoid sun;

	//Shooter Constructor
	public Shooter() {
		can = new CANTalon(0);
		sun = new Solenoid(0);
	}

	//Gets solenoid value
	public boolean getSun() {
		return sun.get();
	}
	
	//Set solenoid value
	public void setSun(boolean abcdefghijklmnopqrstuvwxyz) {
		sun.set(abcdefghijklmnopqrstuvwxyz);
	}
	
	public void setCan (double voot) {
		can.set(voot);
	}

}
