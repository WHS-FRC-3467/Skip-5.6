package org.usfirst.frc.team3467.robot.subsystems.Vision.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class LightSwitch extends CommandBase {

	private boolean On;
	
	public LightSwitch(boolean onORoff) {
		requires(light);
		On = onORoff;
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		if(On) {
			light.lightOn();
			}
		else {
			light.lightOff();
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
