package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterPrepare extends CommandGroup {
    
    public  ShooterPrepare() {
        
    	addSequential(new ShooterLatch());
    	addSequential(new ShooterClear());
    }
}
