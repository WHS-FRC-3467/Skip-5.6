package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AutoRotateToAngle extends CommandBase {

	double degrees;
	double speed;
	
	public AutoRotateToAngle(double degree, double speed) {
		requires (driveBase);
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
		
		SmartDashboard.putNumber("Rotating: ", degrees);
	}

	protected void execute() {
		driveBase.driveArcade(0, ahrs.turnController.get(), false);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		ahrs.turnController.disable();
		driveBase.driveArcade(0, 0, false);
	}

	protected void interrupted() {
		driveBase.driveArcade(0, 0, false);
	}
}
