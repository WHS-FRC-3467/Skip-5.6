package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class RotateToAngle extends CommandBase {

	boolean precissionMode;
	double degrees;
	double speed;
	
	
	public RotateToAngle(double degree, double speed, boolean precise) {
		requires (driveBase);
		this.precissionMode = precise;
		this.degrees = degree;
		this.speed = speed;
		this.setInterruptible(false);
	}
	
	protected void initialize() {
		ahrs.GyroReset();
		ahrs.turnController.reset();
		ahrs.turnController.setSetpoint(degrees);
		ahrs.turnController.reset();
		ahrs.turnController.enable();
		
		SmartDashboard.putNumber("Rotating", degrees);
	}

	@Override
	protected void execute() {
		driveBase.driveArcade(0, ahrs.turnController.get(), false);
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
