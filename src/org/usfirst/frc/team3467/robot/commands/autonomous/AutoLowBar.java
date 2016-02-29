package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;

public class AutoLowBar extends CommandGroup {
	
	public AutoLowBar() {
		addSequential(new DriveStraight(5.0));
		addSequential(new AutoRotateToAngle(50));
	}
}
