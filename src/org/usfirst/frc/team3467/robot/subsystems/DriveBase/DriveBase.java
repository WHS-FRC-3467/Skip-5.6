package org.usfirst.frc.team3467.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.TankDrive;

public class DriveBase extends Subsystem {
	
		//Default Ramp Rate
	private final double ramp_Rate = 2;
	
		//CANTalons objects and RobotDrive object
	private static CANTalon leftTalon, rightTalon;
	private static RobotDrive t_drive;
	
		//Field Centric state (true = on) (false = off)
	private static boolean t_fieldcentricON = false;
	
		//Control mode of current instance
	private CANTalon.ControlMode t_controlMode;
	
		//Instance of the DriveBase Class
	private static DriveBase instance;
	
		//SetAngle
	private double t_AngleDrive;
	
		//DriveBase get instance method
	public DriveBase getInstance() {
		return instance;
	}

		//Initializing the Default Command
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TankDrive());
	}
	
		//DriveBase class constructor
	public DriveBase() {
		//Accesses the constructor method from the PIDSubsystem Class
		
		//DriveBase instance = the current instance
		instance = this;
		
		//Create instances of CANTalon motor controllers
		leftTalon = new CANTalon(RobotMap.drivebase_LeftTalon);
		rightTalon = new CANTalon(RobotMap.drivebase_RightTalon);
		
	}
	
	//Set up for Tank Drive
	
	//Use Standard Tank Drive method
	public void driveTank (double LeftTalon, double RightTalon){
		leftTalon.set(LeftTalon);
		rightTalon.set(RightTalon);
	}
}
