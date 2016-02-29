package org.usfirst.frc.team3467.robot.commands.autonomous;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 *
 */
public class JustDriveFor5 extends CommandBase {

    public JustDriveFor5() {
        requires(driveBase);
        setTimeout(5.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	driveBase.initTank();
    	driveBase.resetEncoders();
    	ahrs.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Need to give negative values to simulate sticks in forward direction
    	driveBase.driveTank(-0.5, -0.5, true);
    	ahrs.getGyroAngle();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
