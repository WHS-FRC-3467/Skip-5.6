package org.usfirst.frc.team3467.robot.subsystems.utilitybar;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team3467.robot.Robot;
import org.usfirst.frc.team3467.robot.RobotMap;

public class Pnumatic_system extends Subsystem {
	
	//Constants used for OI
	public static final Value kOut = Value.kForward;
	public static final Value kIn = Value.kReverse;
	public static final Value kOff = Value.kOff;
	
	//Objects in Pnumatic_system
	public static DoubleSolenoid scorpionsolenoid;
	public static Compressor scorpioncompressor;
	private static Pnumatic_system instance; 
	
	//Variables in Pnumatic_system
	public float CompressorCurrent = 0;
	public boolean CompressorSwitch = false;
	
	//Gets instnace of Pnumatic System
	public Pnumatic_system getInstance() {
		return instance;
	}
	
	//Constructor method for Pnumatic_system class
	public Pnumatic_system() {
		instance = this;
		scorpionsolenoid = new DoubleSolenoid(RobotMap.utilitybar_solenoid_deploy,
											RobotMap.utilitybar_solenoid_retract);
		
		scorpioncompressor = new Compressor();
		scorpioncompressor.start();
		SmartDashboard.putString("UtilityBar", "Compressor is on");
	}
	
	//Sets value of solenoid
	public void setsolenoid(Value actuate) {
		scorpionsolenoid.set(actuate);
	}
	
	//Turns compressor on or off based on a boolean
	public void setCompressorEnabled() {
		scorpioncompressor.start();
	}
	
	//Gets value of compressor (Is it on?)
	public boolean getcompressor(){
		return scorpioncompressor.enabled();
	}
	
	public boolean getpressureSwitch(){
		CompressorSwitch = scorpioncompressor.getPressureSwitchValue();
		return CompressorSwitch;
	}
	
	public float getcurrent() {
		CompressorCurrent = scorpioncompressor.getCompressorCurrent();
		return CompressorCurrent;
	}

	protected void initDefaultCommand() {
	}
}