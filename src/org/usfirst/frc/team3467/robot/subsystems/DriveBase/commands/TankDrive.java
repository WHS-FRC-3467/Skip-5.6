package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.Robot;
import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.DriveBase;


import edu.wpi.first.wpilibj.Sendable;
//import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class TankDrive extends CommandBase {
	
	protected void initialize() {
		//Makes it so the command will not function when if the there is no specific DriveBase is created
		requires(driveBase);
	}

	protected void execute() {
		//Applies the driveTank method to the driveBase object
		driveBase.driveTank(oi.getLeft(), oi.getRight());
		SmartDashboard.putString("Hello", "Working");
		
		
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
