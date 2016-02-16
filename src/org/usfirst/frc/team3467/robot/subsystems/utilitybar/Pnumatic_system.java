package org.usfirst.frc.team3467.robot.subsystems.utilitybar;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;

import org.usfirst.frc.team3467.robot.Robot;
import org.usfirst.frc.team3467.robot.RobotMap;

public class Pnumatic_system extends Subsystem {
	
	//Objects in Pnumatic_system
	public static Solenoid scorpionsolenoid;
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
		scorpionsolenoid = new Solenoid(RobotMap.pnumatic_solenoid);
		scorpioncompressor = new Compressor();
	}
	
	//Sets value of solenoid
	public void setsolenoid(boolean yes) {
		scorpionsolenoid.set(yes);
	}
	
	//Gets value of solenoid
	public boolean getsolenoid() {
		return scorpionsolenoid.get();	
	}
	
	//Turns compressor on or off based on a boolean
	public void setCompressorEnabled(boolean compressorenabled) {
		if(compressorenabled == true) {
		scorpioncompressor.start();
	}
		else {
		scorpioncompressor.stop();
		}
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
		this.setDefaultCommand(null);
	}
}