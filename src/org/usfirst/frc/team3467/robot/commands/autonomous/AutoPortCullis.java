package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;

public class AutoPortCullis extends CommandGroup {
	
	public AutoPortCullis() {
	addSequential(new DriveStraight(5.0));
	addSequential(new Bar_actuate(true));
	addSequential(new AutoRotateToAngle(0.0, 0.0));
	}
}
