package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Roller_Actuate extends CommandBase {

	private boolean EXTEND;
	
	public Roller_Actuate(boolean Extend) {
		requires(intake);
		EXTEND = Extend;
	}
	
	protected void initialize() {

	}

	protected void execute() {
		if (EXTEND) {
			intake.extend();
		}
		else {
			intake.retract();
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
	
	

}
