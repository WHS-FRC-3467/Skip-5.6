package org.usfirst.frc.team3467.robot.triggers;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;

/**
 * Gamepad DPadUp support
 */
public class DPadDown extends Trigger {
	private Joystick joy;
	
	public DPadDown(Joystick joy) {
		this.joy = joy;
	}	

	public boolean get() {
        return (joy.getPOV(0) == 180);
    }
}
