package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Relay.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class Flashlight extends Subsystem{

	public Relay flashSpike;
	public DigitalOutput flashOutput;
	private int m_lightMode = 0;
	
	public Flashlight() {
		
		flashSpike = new Relay(0);
		flashOutput = new DigitalOutput(0);
	}
	
	public void lightOn() {
		flashSpike.set(Value.kOn);
		}
	
	public void lightOff() {
		flashSpike.set(Value.kOff);
		m_lightMode = 0;
		}

	public void lightPulse() throws Exception {
		Thread.sleep(500);
		flashSpike.set(Value.kOff);
		Thread.sleep(10);
		flashSpike.set(Value.kOn);
		Thread.sleep(10);
		flashSpike.set(Value.kOff);
		Thread.sleep(10);
		flashSpike.set(Value.kOn);
		Thread.sleep(10);
		//flashSpike.set(Value.kOff);
		//Thread.sleep(15);
		//flashSpike.set(Value.kOn);
		}
	
	protected void initDefaultCommand() {

	}
}
