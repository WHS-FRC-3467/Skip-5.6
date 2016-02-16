package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class RollerActuate extends CommandBase {
	
	boolean INOROUT;
	
	public RollerActuate(boolean inORout){
		requires(intake);
		INOROUT = inORout;
	}
	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	protected void execute() {
		if (INOROUT == true){
			//Sets the solenoid to in
			intake.setSolenoid(false);
		} 
		else {
			//Sets the solenoid to out
			intake.setSolenoid(true);
		}
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initialize() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

}
