package org.usfirst.frc.team3467.robot.subsystems.utilitybar;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Relay;

public class Pnumatic_system extends Subsystem {
	
	//Objects in Pnumatic_system
	public static Relay scorpionrelay;
	public static Solenoid scorpionsolenoid;
	public static Compressor scorpioncompressor;
	
	//Variables in Pnumatic_system
	public float CompressorCurrent = 0;
	public boolean CompressorSwitch = false;
	
	//Constructor method for Pnumatic_system class
	public Pnumatic_system() {
		scorpionrelay = new Relay(0);
		scorpionsolenoid = new Solenoid(1);
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