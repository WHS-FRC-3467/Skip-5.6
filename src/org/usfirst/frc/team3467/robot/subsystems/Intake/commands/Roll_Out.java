package org.usfirst.frc.team3467.robot.subsystems.Intake.commands;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.commands.CommandBase;

public class Roll_Out extends CommandBase {
	
	boolean FASTORSLOW;
	
	public Roll_Out(boolean fastORslow){
		requires(intake);
		FASTORSLOW = fastORslow;
	}
	
	protected void end() {
		// TODO Auto-generated method stub
	}

	protected void execute() {
		if(FASTORSLOW == true){
			intake.outtakeFast();
		} 
		else {
			intake.outtakeSlow();
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
