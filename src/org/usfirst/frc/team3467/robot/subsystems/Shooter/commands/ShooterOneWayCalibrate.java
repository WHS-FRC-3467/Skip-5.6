package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 *
 */
public class ShooterOneWayCalibrate extends CommandBase {

	boolean gotoLatch = false;
	
	public ShooterOneWayCalibrate(boolean latch) {
        requires(pultaCat);
        gotoLatch = latch;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pultaCat.initManualMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// TODO: Add code to call Shooter calibration routine 
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
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
