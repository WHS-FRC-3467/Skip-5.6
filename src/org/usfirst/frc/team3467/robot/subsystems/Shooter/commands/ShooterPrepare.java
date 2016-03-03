package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class ShooterPrepare extends CommandGroup {
    
    public  ShooterPrepare() {
        
    	addSequential(new ShooterLatch());
    	SmartDashboard.putString("Prepare", "Finished Latch");
    	addSequential(new ShooterClear());
    	SmartDashboard.putString("Prepare1", "Finished Clear");
    }
}
