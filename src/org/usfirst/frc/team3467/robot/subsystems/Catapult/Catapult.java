package org.usfirst.frc.team3467.robot.subsystems.Catapult;

import edu.wpi.first.wpilibj.command.Subsystem;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.AnalogPotentiometer;

public class Catapult extends Subsystem {

	public static CANTalon CatTalon;
	public static Solenoid CatPiston;
	public static AnalogPotentiometer CatPot;

	public Catapult() {
		CatTalon = new CANTalon(3);
		CatPiston = new Solenoid(0);
		
	}
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

