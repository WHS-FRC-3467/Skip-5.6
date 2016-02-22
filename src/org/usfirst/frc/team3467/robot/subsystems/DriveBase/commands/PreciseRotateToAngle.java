package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class PreciseRotateToAngle extends CommandBase {

	double PreciseInput;
	
	public PreciseRotateToAngle() {
		requires(driveBase);

	}
	
	protected void initialize() {
		/*ahrs.GyroReset();
		ahrs.turnController.reset();
		ahrs.turnController.setSetpoint(oi.getPrimeZ());
		ahrs.turnController.reset();
		ahrs.turnController.enable();
		*/
	}

	@Override
	protected void execute() {
		PreciseInput = oi.getPrimeTwist()/5;
		//driveBase.driveArcade(0, (ahrs.turnController.get()/90) * 15, false);
		driveBase.driveTank(-PreciseInput, PreciseInput, false);
	}

	@Override
	protected boolean isFinished() {
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
