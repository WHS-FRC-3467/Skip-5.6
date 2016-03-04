package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.*;

public class AutoCheval extends CommandGroup {
	
	/*
	 * Autonomous for cheval de Freeze
	 * 		-Utilitybar in
	 * 		-Moves Forward
	 * 		-Utilitybar out
	 *		-Moves Forward Again
	 *		-Finger in
	 *		-Turns and shoots
	 *		-Stops
	 */
	
	public AutoCheval() {
		addSequential(new Bar_actuate(Pnumatic_system.kIn));
		addSequential(new DriveStraight(3500, 0.2));
		
		if (new DriveStraight(0).hasStalled()) {
			addSequential(new DriveStraight(-100));
		}
		addSequential(new Bar_actuate(Pnumatic_system.kOut));
		//addSequential(new DriveStraight(6000, 0.4));
		addSequential(new Bar_actuate(Pnumatic_system.kOff));
		addParallel(new Finger_actuate(Pnumatic_system.kOff));
	}
}
