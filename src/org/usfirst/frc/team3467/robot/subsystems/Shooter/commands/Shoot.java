package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Shoot extends CommandBase {
	
	boolean shotFired = false;
	
	public Shoot() {
		requires(pultaCat);
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		// Check to make sure reset bar is out of the way before shooting
		if (pultaCat.resetBarIsClear()) {

			pultaCat.cataShoot();
			shotFired = true;
		}
	}

	public boolean isFinished() {
		return shotFired;
	}
	
	public void end() {
	}

	protected void interrupted() {
		end();
	}

}
