package org.usfirst.team3467.robot.subsystems.Catapult.commands;

import org.usfirst.frc.team3467.robot.Robot;

import edu.wpi.first.wpilibj.command.Subsystem;;

public class Shoot {
	
	public Shoot() {
		requires(Subsystem.Shooter);
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void end() {
	}

}
