package org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;
// Command base is being extended from public class Bar_out
public class Bar_actuate extends CommandBase {

	boolean INOROUT;
	
	public Bar_actuate(boolean inORout) {
	 requires(utilitybar);
	 INOROUT = inORout;
	}
	
	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if (INOROUT == true) {
		utilitybar.setsolenoid(true);
		}
		else {
			utilitybar.setsolenoid(false);
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
