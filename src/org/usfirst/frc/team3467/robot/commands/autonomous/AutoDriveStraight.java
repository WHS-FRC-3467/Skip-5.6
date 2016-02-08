package org.usfirst.frc.team3467.robot.commands.autonomous;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *  Drive straight ahead for specified distance
 */
public class AutoDriveStraight extends CommandGroup {
    
    public  AutoDriveStraight() {

    	addSequential(new DriveStraight());
    }
}
