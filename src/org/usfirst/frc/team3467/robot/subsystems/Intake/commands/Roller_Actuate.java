package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Roller_Actuate extends CommandBase {

	private boolean EXTEND;
	
	public Roller_Actuate(boolean Extend) {
		requires(INTAKE);
		EXTEND = Extend;
	}
	
	protected void initialize() {

	}

	protected void execute() {
		if (EXTEND) {
			INTAKE.extend();
		}
		else {
			INTAKE.retract();
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
