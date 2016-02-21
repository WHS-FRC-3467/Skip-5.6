package org.usfirst.frc.team3467.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.commands.ShooterReset;

/*
	How the Shooter works:
	
	Manual mode:  Holding left bumper on gamepad, left stick Y axis controls
	the reset bar.
	
	PID mode: PID loop runs continuously and responds to changes in setpoint 
	made by calls to latch() and clear()
 
 */


public class Shooter extends PIDSubsystem {

	// Controls display to SmartDashboard
	private static final boolean debugging = true;

	//Catapult Objects
	public CANTalon resetBar;
	public DoubleSolenoid catLatch;
	public AnalogPotentiometer resetAngle;
	
	//PID Constants
	private static final double SHOOT_P = 0.0;
	private static final double SHOOT_I = 0.0;
	private static final double SHOOT_D = 0.0;
	
	private static final double TOLERANCE = 0.1;
	
	// PID variables
	double m_resetBarSetpoint;
	boolean m_usePID;

	// Reset bar setpoints
	private double clearPoint = 0.70;  // bar is out of the way of catapult
	private double latchPoint = 0.33; // bar is holding catapult so it can be latched

	private Shooter instance;
	
	//Shooter Constructor
	public Shooter() {

		super("Shooter", SHOOT_P, SHOOT_I, SHOOT_D);

		instance = this;

		resetAngle = new AnalogPotentiometer(new AnalogInput(RobotMap.catapult_potentiometer_port));
		resetBar = new CANTalon(RobotMap.catapult_Talon);
		catLatch = new DoubleSolenoid(RobotMap.catapult_solenoid_latch, RobotMap.catapult_solenoid_release);

		m_resetBarSetpoint = resetAngle.get();
		m_usePID = false;
		this.setAbsoluteTolerance(TOLERANCE);
	}
		
	protected void initDefaultCommand() {
		this.setDefaultCommand(new ShooterReset());	// Drive Manually by default
	}
	
	//Returns instance of Shooter Subsystem
	public Shooter getInstance() {
		return instance;
	}
	
	public void SetPoint(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	public void initManualMode() {

		if (m_usePID) {
			m_usePID = false;
			this.disable();
			
			// Stop motor until we are ready to set speed
			resetBar.set(0);
			
			if (debugging)
		    	SmartDashboard.putBoolean("Shooter PID Enabled", false);
		}
	}
	
	public void driveManual(double speed) {
		
		// Drive reset bar at commanded speed,
		// being sure to check for limit switches
		resetBar.set(check4Endpoints(speed));	

		// Update the reset bar setpoint even while in manual mode
		// to avoid surprises when returning to PID control
		double angle = resetAngle.get();
		if (debugging) {
	    	SmartDashboard.putNumber("Shooter Reset Angle", angle);
		}
		m_resetBarSetpoint = angle;
	}

	public boolean initPIDMode() {

		if (!m_usePID) {
			m_usePID = true;

			this.setSetpoint(m_resetBarSetpoint);
			this.enable();
		
			if (debugging)
		    	SmartDashboard.putBoolean("Shooter PID Enabled", true);
		}
		return true;
		
	}
	
	/*
	 * Methods to move Reset Bar to useful positions
	 */
	public void latch() {

		this.setSetpoint(latchPoint);
		
		// Save the position
		m_resetBarSetpoint = latchPoint;
		
		if (debugging)
			SmartDashboard.putNumber("Shooter Setpoint", m_resetBarSetpoint);
	}
	
	public void clear() {

		this.setSetpoint(clearPoint);
		
		// Save the position
		m_resetBarSetpoint = clearPoint;
		
		if (debugging)
			SmartDashboard.putNumber("Shooter Setpoint", m_resetBarSetpoint);
	}
	
	public boolean resetBarIsClear() {
		// As long as reset angle is less than clearPoint, return false
		return (resetAngle.get() >= clearPoint);
	}
	
	
	// Control the solenoid that latches the catapult
	public void cataLatch() {
		catLatch.set(DoubleSolenoid.Value.kForward);
	}
	
	public void cataShoot() {
		catLatch.set(DoubleSolenoid.Value.kReverse);		
	}

	public void cataStop() {
		catLatch.set(DoubleSolenoid.Value.kOff);		
	}

	// PIDController methods
	protected double returnPIDInput() {
		double angle = resetAngle.get();
		if (debugging) {
	    	SmartDashboard.putBoolean("Shooter PID Enabled", true);
	    	SmartDashboard.putNumber("Shooter Reset Angle", angle);
		}
		return angle;
	}

	protected void usePIDOutput(double output) {
		if (debugging) {
			SmartDashboard.putNumber("Shooter SetPoint", this.getSetpoint());
		}
		resetBar.set(check4Endpoints(output));
	}

	private double check4Endpoints(double speed) {
		// If trying to drive and a limit switch is hit, then stop...
		if(resetBar.isFwdLimitSwitchClosed() && speed > 0.0) {
			speed = 0.0;
		}
		else if(resetBar.isRevLimitSwitchClosed() && speed < 0.0) {
			speed = 0.0;
		}
		return(speed);
	}
}
