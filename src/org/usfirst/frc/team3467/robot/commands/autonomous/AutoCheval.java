package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.*;

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
		addSequential(new Bar_actuate(Pnumatic_system.kOut));
		addParallel(new Finger_actuate(Pnumatic_system.kOut));
		addSequential(new DriveStraight(5.0));
		addSequential(new Bar_actuate(Pnumatic_system.kOff));
		addParallel(new Finger_actuate(Pnumatic_system.kOff));
	}

}
