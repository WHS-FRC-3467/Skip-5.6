package org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.command;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class AHRS_Update extends CommandBase {

	private int counter;
	
	public AHRS_Update() {
		requires(ahrs);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
		counter = 0;
	}

	@Override
	protected void execute() {
		if (counter < 50) {
			counter++;
		}
		else {
		}
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}
}
