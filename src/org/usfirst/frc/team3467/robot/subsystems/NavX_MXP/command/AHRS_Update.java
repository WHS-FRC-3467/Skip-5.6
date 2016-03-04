package org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.command;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class AHRS_Update extends CommandBase {

	private int counter;
	
	public AHRS_Update() {
		requires(ahrs);
		this.setInterruptible(true);
	}
	
	protected void initialize() {
		counter = 0;
	}

	protected void execute() {
		if (counter < 50) {
			counter++;
		}
		else {
			SmartDashboard.putNumber("Gyro Angle", ahrs.getGyroAngle());
			SmartDashboard.putNumber("Gyro Yaw", ahrs.getGyroYaw());
			counter = 0;
		}
	}

	protected boolean isFinished() {
		return false;
	}

	protected void end() {
		
	}

	protected void interrupted() {
		end();
	}
}
