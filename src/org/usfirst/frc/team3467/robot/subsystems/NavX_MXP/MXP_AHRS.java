package org.usfirst.frc.team3467.robot.subsystems.NavX_MXP;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.SPI;

public class MXP_AHRS extends Subsystem implements PIDOutput {
		
		//Create AHRS and PIDController
	public static AHRS ahrs;
	private static MXP_AHRS instance;
	public static PIDController turnController;
	
	private static final boolean 	DEBUGGING = false;
	
		//Rotate to the angle
	public double rotateToAngle;
	
		//Set PID constants
	static final double kP = 0.0;
	static final double kI = 0.0;
	static final double kD = 0.0;
	static final double kF = 0.0;
	
		//Tolerance
	static final double t_tolerance = 0.0;
	
	public MXP_AHRS() {
		
		instance = this;
		
		try {
				//Instantiate AHRS, if there is no MXP, or this cannot happen, it will report an error
			ahrs = new AHRS(SPI.Port.kMXP);
		} catch (RuntimeException ex) {
				DriverStation.reportError("Error Instantiating NavX MXP: " + ex.getMessage(), true);
			}
		
			//Instantiate PID Controller
		turnController = new PIDController(kP, kI, kD, kF, ahrs, this);
	
			//Set Default Parameters
		turnController.setInputRange(-180.0f, 180.0f);
		turnController.setOutputRange(-1.0, 1.0);
		turnController.setAbsoluteTolerance(t_tolerance);
		turnController.setContinuous(true);
	}
	
		//Get AHRS instance method
	public MXP_AHRS getInstance() {
		return instance;
	}
	
	public double getGyroAngle() {
		return ahrs.getAngle();
		
	}
	
	public void operatorControl() {
		
	}
	
	@Override
	protected void initDefaultCommand() {
		this.setDefaultCommand(null);
	}

	public void pidWrite(double output) {
		rotateToAngle = output;
		SmartDashboard.putNumber("Angle", rotateToAngle);
	}

}
