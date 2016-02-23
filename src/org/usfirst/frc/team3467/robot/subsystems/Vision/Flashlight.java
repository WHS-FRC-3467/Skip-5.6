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
		m_lightMode = (m_lightMode + 1) % 3;
		switch (m_lightMode) {
		case 0:
				flashSpike.set(Value.kOff);
				Thread.sleep(100);
				flashSpike.set(Value.kOn);
				break;
		case 1:
				flashSpike.set(Value.kOff);
				Thread.sleep(100);
				flashSpike.set(Value.kOn);
				break;
		case 2:
				flashSpike.set(Value.kOff);
				Thread.sleep(100);
				flashSpike.set(Value.kOn);
				break;
		}
	}
	
	protected void initDefaultCommand() {

	}
}
