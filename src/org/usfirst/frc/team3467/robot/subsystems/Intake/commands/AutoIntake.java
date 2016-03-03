package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class AutoIntake extends CommandBase {

	boolean Out;
	
	public AutoIntake(boolean driveOut) {
		requires(intake);
		Out = driveOut;
		setTimeout(1);
	}
	
	protected void initialize() {
	}
	
	protected void execute() {
		if (Out) {
			intake.driveManual(intake.kIntakeFast);
		}
		else {
			intake.driveManual((intake.kEjectFast));
		}
	}

	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		intake.driveManual(0.0);
	}

	protected void interrupted() {
	}
}
