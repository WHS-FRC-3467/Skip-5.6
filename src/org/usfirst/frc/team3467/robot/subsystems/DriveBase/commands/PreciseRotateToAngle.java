package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class PreciseRotateToAngle extends CommandBase {

	double PreciseInput;
	
	public PreciseRotateToAngle() {
		requires(driveBase);

	}
	
	protected void initialize() {
	}

	protected void execute() {
		PreciseInput = oi.getPrimeTwist()/5;
		//driveBase.driveArcade(0, (ahrs.turnController.get()/90) * 15, false);
		driveBase.driveTank(-PreciseInput, PreciseInput, false);
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		driveBase.driveArcade(0, 0, false);
	}

	protected void interrupted() {
		end();
	}
}
