package org.usfirst.frc.team3467.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;

import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.TankDrive;
import org.usfirst.frc.team3467.robot.RobotMap;

public class DriveBase extends Subsystem {

		//CANTalokn and DriveBase objects
	public static CANTalon leftTalon;
	public static CANTalon rightTalon;
	public static DriveBase instance;
	
		//Important Class objects
	private CANTalon.ControlMode t_controlMode;
	
		//PID position constants
	private static final double KP_P = 0.0;
	private static final double KI_P = 0.0;
	private static final double KD_P = 0.0;
	
		//Gets the current DriveBase instance
	public static DriveBase getinstance() {
		return instance;
	}
		
		//DriveBase constructor
	public DriveBase() {
		instance = this;
		leftTalon = new CANTalon(RobotMap.DriveBase_leftTalon);
		rightTalon = new CANTalon(RobotMap.DriveBase_rightTalon);
		
			//Set Default parameters for CANTalons
		leftTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		rightTalon.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
		
			//Set ecnoders and encoder types
		leftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rightTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
		SmartDashboard.putString("DriveBase", "Constructor complete");
	}
		
		//Initiating default cpommand
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TankDrive());
		SmartDashboard.putString("DriveBase", "Default Method Set");
	}
	
		//Initiating Tank drive parameters
	public void initTanks() {
		if (t_controlMode != CANTalon.TalonControlMode.PercentVbus) {
			leftTalon.changeControlMode(TalonControlMode.PercentVbus);
			rightTalon.changeControlMode(TalonControlMode.PercentVbus);
			
			t_controlMode = TalonControlMode.PercentVbus;
		}
		SmartDashboard.putString("DriveBase", "Initiated Tank");
	}
	
	public void driveTank(double left, double right) {
		leftTalon.set(left);
		rightTalon.set(right);
	}
}
