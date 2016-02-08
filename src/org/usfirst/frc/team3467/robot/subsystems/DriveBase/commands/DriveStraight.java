package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveStraight extends CommandBase {

	public DriveStraight() {
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		driveBase.driveTank(oi.getLeft(), oi.getRight());
		SmartDashboard.putString("DriveStraight", "Executing");
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}

	
}
