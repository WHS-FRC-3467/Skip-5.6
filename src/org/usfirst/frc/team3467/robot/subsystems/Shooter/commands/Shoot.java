package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Shoot extends CommandBase {
	
	boolean shotFired = false;
	
	public Shoot() {
		requires(pultaCat);
		setInterruptible(false);
	}
	
	protected void initialize() {
        System.out.println("Shoot initialized");
	}

	protected void execute() {
		// Check to make sure reset bar is out of the way before shooting
		if (pultaCat.resetBarIsClear()) {

			pultaCat.cataShoot();
			shotFired = true;
		}
	}

	public boolean isFinished() {
        System.out.println("Is Shoot finished?");
 		return shotFired;
	}
	
	public void end() {
        System.out.println("Shoot has ended");

	}

	protected void interrupted() {
        System.out.println("Shoot interuppted");
		end();
	}

}
