package org.usfirst.frc.team3467.robot.commands.autonomous;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.CommandGroup;

import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.DriveStraight;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;

public class TurnAndShoot extends CommandGroup {
	
	//Position of defense, relative to the dirver Station (1 = Left), (5 = Right)
	int RobotPosition;
	
	//Constructor for TurnAndShoot
	public TurnAndShoot(int Position) {
		
		if (CommandBase.utilitybar.getBarState() == Pnumatic_system.kIn) {
			addSequential(new Bar_actuate(Pnumatic_system.kOut));
		}
		
		RobotPosition = Position;
		switch (Position) {
		//Low Bar Obstacle
		case 1: addSequential(new DriveStraight(0));
				addSequential(new AutoRotateToAngle(60.0));
				break;
		//
		case 2: addSequential(new DriveStraight(5.0));
				addSequential(new AutoRotateToAngle(1.0));
				break;
				
		case 3: addSequential(new DriveStraight(5.0));
				addSequential(new AutoRotateToAngle(1.0));
				break;
				
		case 4: addSequential(new DriveStraight(5.0));
				addSequential(new AutoRotateToAngle(1.0));
				break;
				
		case 5: addSequential(new DriveStraight(5.0));
				addSequential(new AutoRotateToAngle(1.0));
				break;
			
		default: break;
		}		
	}
}