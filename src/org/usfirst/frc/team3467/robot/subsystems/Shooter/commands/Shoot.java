package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.Robot;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Shoot extends CommandBase {
	
	public Shoot() {
		requires(pultaCat);
	}
	
	public boolean isFinished() {
		return false;
	}
	
	public void end() {
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void execute() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
