package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class ShooterCalibrate extends CommandGroup {
    
    public  ShooterCalibrate() {

    	addSequential(new ShooterOneWayCalibrate(true));
    	addSequential(new ShooterOneWayCalibrate(false));
    }
}
