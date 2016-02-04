package org.usfirst.frc.team3467.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
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
	
	//Sets Default tolerance for closed-loop error
	private final double Tolerance = 20;
	
	//Sets the Izone, the zone
	//The iZone is the zone around the target setpoint in which the I term
	//is actually used. This number defines the size of the iZone ON EACH SIDE
	//of the desired setpoint.
	private final int IZone = 20;
	
		//CANTalons objects and RobotDrive object
	private static CANTalon 		leftTalon, rightTalon;
	private static RobotDrive 		t_drive;
	private CANTalon.ControlMode 	t_controlMode;
	private double 					t_positionDistance;
	//Instance of the DriveBase Class
	private static DriveBase 		instance;
	
		//Field Centric state (true = on) (false = off)
	private static boolean t_fieldcentricON = false;

		//DriveBase get instance method
	public DriveBase getInstance() {
		return instance;
	}

		//Initializing the Default Command
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TankDrive());
	}
	
		//Positional Pid Constants
	private final double KP_P = 0.0;
	private final double KI_P = 0.0;
	private final double KD_P = 0.0;
	private final double KF_P = 0.0;
	
		//DriveBase class constructor
	public DriveBase() {
		//DriveBase instance = the current instance
		instance = this;
		
		//Create instances of CANTalon motor controllers
		leftTalon = new CANTalon(RobotMap.drivebase_LeftTalon);
		rightTalon = new CANTalon(RobotMap.drivebase_RightTalon);
		
		//Set default control Modes for CANTalons
		leftTalon.changeControlMode(TalonControlMode.PercentVbus);
		rightTalon.changeControlMode(TalonControlMode.PercentVbus);
	}
	
	//Set up Distance Drive
	public void initDistance (double distance) {
		t_positionDistance = distance;
		if (t_controlMode != TalonControlMode.Position) {
			leftTalon.changeControlMode(TalonControlMode.Follower);
			rightTalon.changeControlMode(TalonControlMode.Position);
			
			t_controlMode = TalonControlMode.Position;
		
			//Set PID parameters for master Talon
			rightTalon.setIZone(IZone);
			rightTalon.setCloseLoopRampRate(ramp_Rate);
			
			//Initialize Encoder and distance
			rightTalon.setPosition(0);
			rightTalon.set(0);
		}
	}
	
	//Distance Drive
	public void Distance () {
		
	}
	
	//Set up for Tank Drive
	public void initTank () {
		if (t_controlMode != TalonControlMode.PercentVbus);
			leftTalon.changeControlMode(TalonControlMode.PercentVbus);
			rightTalon.changeControlMode(TalonControlMode.PercentVbus);
			t_controlMode = TalonControlMode.PercentVbus;
	}
	
	//Use Standard Tank Drive method
	public void driveTank (double LeftTalon, double RightTalon){
		leftTalon.set(LeftTalon);
		rightTalon.set(RightTalon);
	}
}
