package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TankDrive extends Command {

	protected void initialize() {
		//Makes it so the command will not function when if the there is no specific DriveBase is created
		requires(Robot.Drivebase);
	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		Robot.Drivebase.driveTank(Robot.oi.getLeft(), Robot.oi.getRight());
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
