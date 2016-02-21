package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flashlight extends Subsystem{

	public Relay flashSpike;
	public DigitalOutput flashOutput;
	
	public Flashlight() {
		
		flashSpike = new Relay(0);
		flashOutput = new DigitalOutput(0);
	}
	
	public void lightOn() {
		flashSpike.set(Value.kOn);
		}
	
	public void lightOff() {
		flashSpike.set(Value.kOff);
		}

	@Override
	protected void initDefaultCommand() {

	}
}
