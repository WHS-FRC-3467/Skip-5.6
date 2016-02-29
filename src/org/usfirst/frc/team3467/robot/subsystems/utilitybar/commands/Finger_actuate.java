package org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Finger_actuate extends CommandBase {

	Value INorOUT;
	
	public Finger_actuate(Value inORout) {
		requires(utilitybar);
		INorOUT = inORout;
	}
	
	protected void initialize() {
		
	}

	protected void execute() {
		utilitybar.setFinger(INorOUT);
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		utilitybar.setFinger(Value.kOff);
	}

	protected void interrupted() {
		end();
	}
}
