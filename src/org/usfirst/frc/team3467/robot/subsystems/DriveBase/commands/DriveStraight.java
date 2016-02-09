package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.DriveBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends CommandBase {

	private double travelDistance;
	
	public DriveStraight(double distance) {
		
		requires(driveBase);
		this.setInterruptible(true);
		
		travelDistance = distance;
		
	}
	
	protected void initialize() {
		driveBase.initDistance(travelDistance);
	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		driveBase.distanceDrive();
		SmartDashboard.putString("DriveStraight", "Executing");
	}

	protected boolean isFinished() {
		return (driveBase.onPosition() || isTimedOut());
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}

	
}
