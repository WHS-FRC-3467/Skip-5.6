package org.usfirst.frc.team3467.robot.subsystems.NavX_MXP;

import org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.command.AHRS_Update;

import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.SPI;

public class MXP_AHRS extends Subsystem {
		
	//Create AHRS instance
	private AHRS ahrs;
	private static MXP_AHRS instance;
	
	//AHRS constructor
	public MXP_AHRS() {
		
		instance = this;
		
		try {
			//Instantiate AHRS, if there is no MXP, or this cannot happen, it will report an error
			ahrs = new AHRS(SPI.Port.kMXP);
			SmartDashboard.putBoolean("AHRS Good", ahrs != null);
		} catch (RuntimeException ex) {
				DriverStation.reportError("Error Instantiating NavX MXP: " + ex.getMessage(), true);
		}
		
	}
	
	//Get AHRS instance method
	public MXP_AHRS getInstance() {
		return instance;
	}
	
	protected void initDefaultCommand() {
		this.setDefaultCommand(new AHRS_Update());
	}

	public void gyroReset() {
		ahrs.reset();
	}
	
	public double getGyroAngle() {
		return ahrs.getAngle();
	}

	public double getGyroYaw() {
		SmartDashboard.putBoolean("Calibrating?", ahrs.isCalibrating());
		return ahrs.getYaw();
	}
}
