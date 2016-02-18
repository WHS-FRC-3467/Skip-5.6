package org.usfirst.frc.team3467.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

import org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands.Bar_actuate;
import org.usfirst.frc.team3467.robot.control.Gamepad;

public class OI {
	
	public static Joystick leftDrive;
	public static Joystick rightDrive;
	public static Gamepad operator;
	
	public OI(){
		leftDrive = new Joystick(0);
		rightDrive = new Joystick(1);
		operator = new Gamepad(2);
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
	public double getLeftY(){
		return leftDrive.getY();
	}
	
	public double getRightY(){
		return rightDrive.getY();
	}
	
	public double getRightX(){
		return rightDrive.getX();
	}
	
	public double getRightZ() {
		return rightDrive.getZ();
	}
	
	//Method that binds certain commands to certain buttons
	public void BindCommands() {
		
		//Interupts the previous command
		new JoystickButton(operator, Gamepad.leftBumper)
		.whenPressed(null);
		
		//Rollers
			//Slow Intake
		new JoystickButton(operator, Gamepad.aButton)
		.whileHeld(null);
			//Fast Intake
		new JoystickButton(operator, Gamepad.bButton)
		.whileHeld(null);
			//Slow Spitout
		new JoystickButton(operator, Gamepad.xButton)
		.whileHeld(null);
			//Fast Spitout
		new JoystickButton(operator, Gamepad.yButton)
		.whileHeld(null);
			//Rollers In
		
			//Rollers Out
		
		//Catapult
		
	
		
		//Utility Bar
			//Extend
		new JoystickButton(operator, Gamepad.leftBumper)
		.toggleWhenPressed(new Bar_actuate(true));
			//Retract
		new JoystickButton(operator, Gamepad.leftBumper)
		.toggleWhenActive(new Bar_actuate(false));
		
	}
}

