package org.usfirst.frc.team3467.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

public class OI {

	public Joystick leftJoystick;
	public Joystick rightJoystick;
	
	public OI() {
		leftJoystick = new Joystick(1);
		rightJoystick = new Joystick(0);
	}
	
	public Joystick getleftJoystick() {
		return leftJoystick;
	}
	
	public Joystick getrightJoystick() {
		return rightJoystick;
	}
	
	public double getRight() {
		SmartDashboard.putString("OI", "Got rightjoystick value");
		return rightJoystick.getY();
	}
	
	public double getLeft() {
		SmartDashboard.putString("OI", "Got leftjoystick value");
		return leftJoystick.getY();
	}
	
	public void BindCommands() {
		
	}
	
}

