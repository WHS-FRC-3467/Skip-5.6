package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class ArcadeDrive extends CommandBase {
	
	public ArcadeDrive() {
		requires(driveBase);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
		driveBase.initArcade();
	}

	@Override
	protected void execute() {
		driveBase.driveArcade(oi.getPrimeY(), oi.getPrimeX(), true);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
