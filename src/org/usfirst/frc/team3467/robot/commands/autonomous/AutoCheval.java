package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.*;

public class AutoCheval extends CommandGroup {
	
	/*
	 * Autonomous for cheval de Freeze
	 * 		-UtilityBar in
	 * 		-Moves Forward
	 * 		-UtilityBar out
	 *		-Drives Forward Again
	 *		-Finger in
	 *		-Stops
	 */
	
	public AutoCheval() {
		addSequential(new Bar_actuate(Pnumatic_system.kIn));
		//addSequential(new Finger_actuate(Pnumatic_system.kOut));
		addSequential(new DriveStraight(3500));
		if (new DriveStraight(0).hasStalled()) {
			addSequential(new DriveStraight(-50));
		}
		addSequential(new Bar_actuate(Pnumatic_system.kOut));
		addSequential(new DriveStraight(6000, 0.4));
	}

}
