package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends CommandBase {
	
	public TankDrive() {
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void initialize() {

	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		driveBase.driveTank(oi.getSecondaryY(), oi.getPrimeY(), true);
		SmartDashboard.putString("TankDrive", "Executing");
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
