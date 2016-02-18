package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Roll_In extends CommandBase {

	private boolean FAST;
	
	public Roll_In(boolean fast) {
		requires(INTAKE);
		FAST = fast;
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		if (FAST) {
			INTAKE.intakeFast();
		}
		else {
			INTAKE.intakeSlow();
		}
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
