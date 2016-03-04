package org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.command;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 *
 */
public class ResetGyro extends CommandBase {

    public ResetGyro() {
        requires(ahrs);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	ahrs.gyroReset();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
