package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 * Move the shooter latch in an attempt to free a stuck latch or just
 * shoot regardless of potentiometer position.
 * Should only be used as a LAST RESORT
 */
public class ShooterRetryUnlatch extends CommandBase {

    public ShooterRetryUnlatch() {
        requires(pultaCat);
        setTimeout(1.0);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//Try to relatch...
    	pultaCat.cataLatch();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Try to unlatch...
    	pultaCat.cataShoot();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
