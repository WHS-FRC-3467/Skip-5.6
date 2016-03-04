package org.usfirst.frc.team3467.robot.subsystems.Shooter.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;


/**
 *
 */
public class ShooterReset extends CommandBase {

	private double m_speed;
	
    public ShooterReset() {
        requires(pultaCat);
        setInterruptible(true);
		m_speed = 0;
    }

	public ShooterReset(double speed) {
		requires(pultaCat);
		m_speed = speed;
	}
	
	protected void initialize() {
		pultaCat.initManualMode();
	}
	
	protected void execute() {
		double speed = 0;
    	
		if (m_speed == 0)
		{
			speed = (oi.getGamepad().getLeftStickY());

			// Deadband
			if (speed > -0.08 && speed < 0.08) speed = 0;

	        // Square the inputs (while preserving the sign) to increase
			// fine control while permitting full power
	        if (speed >= 0.0)
	            speed = (speed * speed);
	        else
	            speed = -(speed * speed);
		}
		else
		{
			speed = m_speed;		
		}
		
		pultaCat.driveManual(speed);
		
		
	}
	
	protected boolean isFinished() {
		// TODO: put current sensing code here to know when to stop
		return false;
	}
	
	protected void end() {
		pultaCat.driveManual(0);
	}
	
	protected void interrupted() {
		end();
	}
}
