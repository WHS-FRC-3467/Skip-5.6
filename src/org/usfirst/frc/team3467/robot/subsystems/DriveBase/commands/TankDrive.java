package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.Robot;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.DriveBase;

public class TankDrive extends CommandBase {

	//private DriveBase db;
	public TankDrive() {
		requires(driveBase);
		SmartDashboard.putString("TankDrive", "Instantiated");
	}
	
	@Override
	protected void initialize() {
		//db = DriveBase.getinstance();
		//requires(db);
		SmartDashboard.putString("TankDrive", "Command init complete");
		
	}

	@Override
	protected void execute() {
		//Robot.driveBase.driveTank(CommandBase.oi.getleft(), CommandBase.oi.getRight());
		driveBase.driveTank(oi.getLeft(), oi.getRight());
		SmartDashboard.putString("TankDrive", "Executing");
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
