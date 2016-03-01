package org.usfirst.frc.team3467.robot.subsystems.Vision.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class LightSwitch extends CommandBase {

	private boolean On;
	
	public LightSwitch(boolean onORoff) {
		requires(light);
		On = onORoff;
		this.setTimeout(6);
	}
	
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}
	
	protected void execute() {
		if(On) {
			light.lightOn();
		}
		else {
			light.lightOff();
		}
	}
	
	protected boolean isFinished() {
		return isTimedOut();
	}

	protected void end() {
		light.lightOff();
	}

	protected void interrupted() {
	}
}
