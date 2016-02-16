package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;

public class AutoCheval extends CommandGroup {
	
	/*
	 * Autonomous for cheval de Freeze
	 * 		-Moves Forward
	 * 		-Lowers Cheval De Freeze
	 *		-Drives Forward Again
	 *		-Stops
	 */
	
	public AutoCheval() {
		addSequential(new DriveStraight(5.0));
		addSequential(null);
	}

}
