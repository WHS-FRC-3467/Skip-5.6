package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;
import org.usfirst.frc.team3467.robot.subsystems.Intake.commands.AutoIntake;
import org.usfirst.frc.team3467.robot.subsystems.Intake.commands.Roller_Actuate;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.commands.Shoot;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.commands.ShooterPrepare;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Finger_actuate;

public class AutoLowBar extends CommandGroup {
	
	public AutoLowBar() {
		addSequential(new Roller_Actuate(true));
		
		if (CommandBase.utilitybar.getFingerState() == Pnumatic_system.kIn) {
			addSequential(new Finger_actuate(Pnumatic_system.kOut));
		}
		addSequential(new Bar_actuate(Pnumatic_system.kIn));
		addSequential(new Finger_actuate(Pnumatic_system.kOut));
		addSequential(new Bar_actuate(Pnumatic_system.kOut));
		addSequential(new DriveStraight(10000, 0.6));
		addSequential(new Roller_Actuate(false));
		addSequential(new AutoIntake(false));
		//addSequential(new TurnAndShoot(1));
		addSequential(new Shoot());
		addSequential(new ShooterPrepare());
		end();
	}
}
