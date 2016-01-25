package org.usfirst.frc.team3467.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.Joystick;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.TankDrive;
import org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.*;

public class OI {

	public static Joystick leftDrive;
	public static Joystick rightDrive;
	
	public void OI(){
		leftDrive = new Joystick(0);
		rightDrive = new Joystick(1);
	}
	
	//Get method for leftDrive Joystick instance
	public Joystick getleftDrive() {
		return leftDrive;
	}
	
	//Get method for rightDrive Joystick instance
	public Joystick getrightDrive() {
		return rightDrive;
	}
	
	//Joystick Methods that return values for left and right joysticks
	public double getLeft(){
		return leftDrive.getY();
	}
	
	public double getRight(){
		return rightDrive.getY();
	}
	
	//Method that binds certain commands to certain buttons
	public void BindCommands() {
		
	}
}

