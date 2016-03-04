package org.usfirst.frc.team3467.robot.subsystems.Brownout.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

/**
 * Command that runs continuously to check power levels at PDB
 */
public class checkPower extends CommandBase {

	private int counter;

	public checkPower() {
    	requires(brownout);
    	this.setInterruptible(true);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	counter = 0;
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	// Only run the update on every 25th pass (about once per half second)
    	if (counter < 25)
    		counter++;
    	else {
        	brownout.checkLevel();
        	counter = 0;
    	}
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

