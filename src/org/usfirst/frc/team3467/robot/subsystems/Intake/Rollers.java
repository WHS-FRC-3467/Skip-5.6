package org.usfirst.frc.team3467.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.Solenoid;

import org.usfirst.frc.team3467.robot.RobotMap;

public class Rollers extends Subsystem {
	
	//Roller Class objects
	public CANTalon rollerTalonX, rollerTalonY;
	public Solenoid rollerSolenoid;
	
	//Roller Class constructor
	public Rollers() {
		//Instantiate objects
		rollerTalonX = new CANTalon(RobotMap.roller_TalonX);
		rollerTalonY = new CANTalon(RobotMap.roller_TalonY);
		rollerSolenoid = new Solenoid(RobotMap.roller_solenoid);
		
		//Set Up CANTalon ControlMode
		rollerTalonX.changeControlMode(TalonControlMode.PercentVbus);
		rollerTalonY.changeControlMode(TalonControlMode.Follower);
		
		rollerTalonY.set(RobotMap.roller_TalonX);
	}
	
	public void outakeFast() {
		rollerTalonX.set(-1.0);
	}
	
	public void outakeSlow() {
		rollerTalonX.set(-0.5);
	}
	
	public void intakeFast() {
		rollerTalonX.set(1.0);
	}
	
	public void intakeSlow() {
		rollerTalonX.set(0.5);
	}
	
	public void extend() {
		rollerSolenoid.set(true);
	}
	
	public void retract() {
		rollerSolenoid.set(false);
	}
	
	
	protected void initDefaultCommand() {
		this.setDefaultCommand(null);
	}
}
