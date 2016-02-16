package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class PreciseRotateToAngle extends CommandBase {

	public PreciseRotateToAngle() {
		requires(driveBase);
	}
	
	protected void initialize() {
		ahrs.GyroReset();
		ahrs.turnController.reset();
		ahrs.turnController.setSetpoint(oi.getRightZ());
		ahrs.turnController.reset();
		ahrs.turnController.enable();
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
		ahrs.turnController.disable();
		driveBase.driveArcade(0, 0, false);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
