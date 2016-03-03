package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;
import org.usfirst.frc.team3467.robot.subsystems.Intake.commands.Roller_Actuate;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;

public class AutoLowBar extends CommandGroup {
	
	/* Auto Low Bar
	 * 		-Intakes Down
	 * 		-Utility Bar Out
	 * 		-Drive Straight
	 * 		-stop
	 */
	
	public AutoLowBar() {
		addSequential(new Roller_Actuate(true));
		addSequential(new Bar_actuate(Pnumatic_system.kOut));
		addSequential(new DriveStraight(4000, 0.7));
		end();
	}
}
