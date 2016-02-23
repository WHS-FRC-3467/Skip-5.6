package org.usfirst.frc.team3467.robot.subsystems.Intake;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.DoubleSolenoid;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.subsystems.Intake.commands.IntakeDrive;

public class Intake extends Subsystem {
	
	// Controls display to SmartDashboard
	private static final boolean debugging = true;

	// Constants for some useful speeds
	public static final double kIntakeFast = -0.8;
	public static final double kIntakeSlow = -0.4;
	public static final double kStop = 0;
	public static final double kEjectSlow = 0.8;
	public static final double kEjectFast = 0.4;

	//Roller Class objects
	public CANTalon rollerTalonX, rollerTalonY;
	public DoubleSolenoid rollerSolenoid;
	
	//Roller Class constructor
	public Intake() {

		//Instantiate objects
		rollerTalonX = new CANTalon(RobotMap.roller_TalonX);
		rollerTalonY = new CANTalon(RobotMap.roller_TalonY);
		rollerSolenoid = new DoubleSolenoid(RobotMap.intake_solenoid_extend,
										RobotMap.intake_solenoid_retract);
		
		//Set Up CANTalon ControlMode
		rollerTalonX.changeControlMode(TalonControlMode.PercentVbus);
		rollerTalonX.reverseOutput(false);

		rollerTalonY.changeControlMode(TalonControlMode.PercentVbus);
		rollerTalonY.reverseOutput(false);
	}

	protected void initDefaultCommand() {
		this.setDefaultCommand(new IntakeDrive());
	}
	
	public void driveManual(double speed) {

		if (debugging) {
	    	SmartDashboard.putNumber("Intake Speed", speed);
		}
		rollerTalonY.set(speed);
		rollerTalonX.set(Math.abs(speed));
	}
	
	// Extend or Retract Intake
	public void extend() {
		rollerSolenoid.set(DoubleSolenoid.Value.kForward);
	}
	
	public void retract() {
		rollerSolenoid.set(DoubleSolenoid.Value.kReverse);
	}
	
	public void hold() {
		rollerSolenoid.set(DoubleSolenoid.Value.kOff);		
	}
	
	
}
