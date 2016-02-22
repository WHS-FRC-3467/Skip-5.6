package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 *
 */
public class ShooterClear extends CommandBase {

    public ShooterClear() {
        requires(pultaCat);
        setInterruptible(false);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	pultaCat.initPIDMode();
    	pultaCat.clear();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (pultaCat.onTarget() || pultaCat.checkClearLimit());
    }

    // Called once after isFinished returns true
    protected void end() {
    	pultaCat.cataStop();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
