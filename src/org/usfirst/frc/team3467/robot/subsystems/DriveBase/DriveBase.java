package org.usfirst.frc.team3467.robot.subsystems.DriveBase;

import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.TankDrive;
import org.usfirst.frc.team3467.robot.commands.CommandBase;
import org.usfirst.frc.team3467.robot.pid.PIDF_CANTalon;

public class DriveBase extends PIDSubsystem {
	//Debugging?
	public static final boolean t_debugging = false;
	
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
	
		//Private PID wraps
	private PIDF_CANTalon 		leftPIDFtalon;
	private PIDF_CANTalon		rightPIDFtalon;
	
		//Field Centric state (true = on) (false = off)
	private static boolean t_fieldcentricON = false;
	
		//DriveBase get instance method
	public DriveBase getInstance() {
		return instance;
	}

		//Initializing the Default Command
	protected void initDefaultCommand() {
		this.setDefaultCommand(new TankDrive());
		SmartDashboard.putString("DriveBase", "Default command set");
	}
	
		//Positional Pid Constants
	private final double KP_P = 0.0;
	private final double KI_P = 0.0;
	private final double KD_P = 0.0;
	private final double KF_P = 0.0;
	
		//DriveBase class constructor
	public DriveBase() {
			//Call PIDSubsystem constructor for using Gyro with PID to rotate
		super("DriveBase", 0.0, 0.0, 0.0);
		
		//DriveBase instance = the current instance
		instance = this;
		
		//Create instances of CANTalon motor controllers
		leftTalon = new CANTalon(RobotMap.drivebase_LeftTalon);
		rightTalon = new CANTalon(RobotMap.drivebase_RightTalon);
		
		//Set default control Modes for CANTalons
		leftTalon.changeControlMode(TalonControlMode.PercentVbus);
		rightTalon.changeControlMode(TalonControlMode.PercentVbus);
		t_controlMode = CANTalon.TalonControlMode.PercentVbus;
		
			//Set SIM encoders as feedback devices
		leftTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		rightTalon.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
		
			//Instantiate RobotDrive
		t_drive = new RobotDrive(leftTalon, rightTalon);
		
			//RobotDrive Parameters
		t_drive.setSafetyEnabled(true);
		t_drive.setExpiration(1.0);
		t_drive.setSensitivity(0.5);
		t_drive.setMaxOutput(1.0);
		t_drive.setInvertedMotor(MotorType.kFrontLeft, false);
		t_drive.setInvertedMotor(MotorType.kFrontRight, false);
		
			//Set Izones
		leftTalon.setIZone(IZone);
		rightTalon.setIZone(IZone);
		
			//Set Voltage ramp rates
		leftTalon.setCloseLoopRampRate(ramp_Rate);
		rightTalon.setCloseLoopRampRate(ramp_Rate);
		
			//Create PID Management wrappers
		leftPIDFtalon = new PIDF_CANTalon("Left CANTalon", leftTalon, Tolerance, true, t_debugging);
		rightPIDFtalon = new PIDF_CANTalon("Right CANTalon", rightTalon, Tolerance, true, t_debugging);
	}
	
	//Set up Distance Drive
	public void initDistance (double distance) {
		t_positionDistance = distance;
		
			//Check if CANTalons are on position mode
		if (t_controlMode != TalonControlMode.Position) {
			leftTalon.changeControlMode(TalonControlMode.Follower);
			rightTalon.changeControlMode(TalonControlMode.Position);
			
			leftTalon.set(RobotMap.drivebase_LeftTalon);
			
			//Reversing Motor Direction?
				leftTalon.reverseOutput(false);
				rightTalon.reverseOutput(false);
		
			//Set PID parameters for master Talon
			rightTalon.setIZone(IZone);
			rightTalon.setCloseLoopRampRate(ramp_Rate);
			
			//Initialize Encoder and setPoint (distance)
			rightTalon.setPosition(0);
			rightTalon.set(0);
			
			//Turn off Motor Safety until we tune the system
			rightTalon.setSafetyEnabled(false);
			
			//Set PID Constants
			rightPIDFtalon.setPID(KP_P, KI_P, KD_P, KF_P);
		
			t_controlMode = TalonControlMode.Position;
		}
	}
	
	//Distance Drive
	public void distanceDrive () {
		rightPIDFtalon.setSetpoint(t_positionDistance);
	}
	
	//Have we driven the specified distance
	public boolean onPosition() {
		return rightPIDFtalon.onTarget();
	}
	
	//Set up for Tank Drive
	public void initTank () {
		if (t_controlMode != TalonControlMode.PercentVbus); {
				leftTalon.changeControlMode(TalonControlMode.PercentVbus);
				rightTalon.changeControlMode(TalonControlMode.PercentVbus);
				
				t_controlMode = TalonControlMode.PercentVbus;
		}
		leftTalon.reverseOutput(true);
	}
	
	//Use Standard Tank Drive method
	public void driveTank (double LeftTalon, double RightTalon, boolean squared){
		t_drive.tankDrive(LeftTalon, RightTalon, squared);
	}

	//Initiate Arcade Drive with PercentVBus
	public void initArcade() {
			//Check if Control mode is not PercentVbus
		if (t_controlMode != TalonControlMode.PercentVbus) {
			leftTalon.changeControlMode(TalonControlMode.PercentVbus);
			rightTalon.changeControlMode(TalonControlMode.PercentVbus);
		
			t_controlMode = TalonControlMode.PercentVbus;
		}
	}
	
	public void driveArcade(double move, double rotate, boolean square) {
		t_drive.arcadeDrive(move, rotate, square);
	}
	
	public double pidTurnToAngleInput(double angle, boolean clockwise) {
		double correctAngle = CommandBase.ahrs.getGryoAngle() + 180;
		boolean wrapAround = ((clockwise = true 
				&& correctAngle < angle 
				&& angle - correctAngle > 180) || (clockwise == true
				&& correctAngle > angle
				&& angle - correctAngle <=180));
			
		if (wrapAround) {
				if (clockwise == true) {
					angle = angle + 360;
				}
					else {
						angle = angle - 360;
					}
				}
		
		double pidInValue = (angle - correctAngle)/180;
		return pidInValue;
	}
	
	public boolean shortestTurnDirection(double angle) {
		boolean turnClockwise = true;
		double currentGyroAngle = CommandBase.ahrs.getGryoAngle();
		
		if ((angle >= currentGyroAngle && currentGyroAngle - angle <= 180) || (angle < currentGyroAngle && angle - currentGyroAngle > 180)) {
			turnClockwise = false;
		}
		
		return turnClockwise;
		
	}
	
	protected double returnPIDInput() {
		boolean bClockwise = shortestTurnDirection(this.getSetpoint());
		return pidTurnToAngleInput(this.getSetpoint(), bClockwise);
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}
}
