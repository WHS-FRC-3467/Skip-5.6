package org.usfirst.frc.team3467.robot.subsystems.Brownout;

import org.usfirst.frc.team3467.robot.subsystems.Brownout.Brownout;


public interface PowerConsumer {

	  /**
	   * Receive a callback alert
	   *$
	   * @param newLevel The new power alert level
	   */
	  public void callbackAlert(Brownout.PowerLevel newLevel);

}
