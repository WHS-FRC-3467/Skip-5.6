package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Roll_Out extends CommandBase {

	private boolean FAST;
	
	public Roll_Out(boolean fast) {
		requires(INTAKE);
		FAST = fast;
	}
	
	protected void initialize() {

	}

	protected void execute() {
		if (FAST) {
			INTAKE.outakeFast();
		}
		else {
			INTAKE.outakeSlow();
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
