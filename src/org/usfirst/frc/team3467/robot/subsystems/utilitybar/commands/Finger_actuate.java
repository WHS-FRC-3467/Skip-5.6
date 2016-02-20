package org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Finger_actuate extends CommandBase {

	Value INOROUT;
	
	public Finger_actuate(Value inORout) {
		requires(utilitybar);
		INOROUT = inORout;
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		utilitybar.setFinger(INOROUT);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {

	}

	protected void interrupted() {

	}
}
