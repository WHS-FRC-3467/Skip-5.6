package org.usfirst.frc.team3467.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;
import org.usfirst.frc.team3467.robot.subsystems.Brownout.Brownout;
import org.usfirst.frc.team3467.robot.subsystems.Brownout.PowerConsumer;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.commands.ShooterReset;

/*
	How the Shooter works:
	
	Manual mode:  Holding left bumper on gamepad, left stick Y axis controls
	the reset bar.
	
	PID mode: PID loop runs continuously and responds to changes in setpoint 
	made by calls to latch() and clear()
 
 */

public class Shooter extends PIDSubsystem implements PowerConsumer {

	// Controls display to SmartDashboard
	private static final boolean debugging = true;
	
	// Talon PDP channel number
	private static final int WINCH_PDP_CHANNEL = 0;
	
	// Brownout power level
	private Brownout.PowerLevel powerlevel = Brownout.PowerLevel.Normal;
	private double maxWinchSpeed = 1.0;
	
	//Catapult Objects
	public CANTalon resetBar;
	public DoubleSolenoid catLatch;
	public AnalogPotentiometer resetAngle;
	
	//PID Constants
	private static final double SHOOT_P = 20.0;
	private static final double SHOOT_I = 0.5;
	private static final double SHOOT_D = 0.0;
	
	private static final double TOLERANCE = 0.05;
	
	// PID variables
	double m_resetBarSetpoint;
	boolean m_usePID;

	// Reset bar setpoints
	private double clearPoint = 0.69;  // bar is out of the way of catapult
	private double latchPoint = 0.30; // bar is holding catapult so it can be latched

	// The roboRio Preferences
	Preferences prefs = Preferences.getInstance();
	
	// If true, reverse solenoid outputs (3 is release, 4 is latch)
	boolean isCompBot = true;
	
	// Has the robot been calibrated
	boolean hasBeenCalibrated = false;
	
	//Shooter Constructor
	public Shooter(boolean IScompBot) {
	
		super("Shooter", SHOOT_P, SHOOT_I, SHOOT_D);

		isCompBot = IScompBot;
		
		resetAngle = new AnalogPotentiometer(new AnalogInput(RobotMap.catapult_potentiometer_port));
		resetBar = new CANTalon(RobotMap.catapult_Talon);
		
		if (isCompBot) {
			catLatch = new DoubleSolenoid(RobotMap.catapult_solenoid_latch, RobotMap.catapult_solenoid_release);
		}
		else {
			catLatch = new DoubleSolenoid(RobotMap.catapult_solenoid_release, RobotMap.catapult_solenoid_latch);
		}
		
		// Start with setpoint at the current potentiometer reading 
		m_resetBarSetpoint = resetAngle.get();
		m_usePID = false;
		this.setAbsoluteTolerance(TOLERANCE);
		
		// Update reset bar setpoints from Preferences
		double cp = clearPoint; double lp = latchPoint;
		clearPoint = prefs.getDouble("Shooter Clear Point", cp);
		latchPoint = prefs.getDouble("Shooter Latch Point", lp);
		
		// Update PID gains from Preferences
		double p, i, d;
		p = prefs.getDouble("Shooter P Gain", SHOOT_P);
		i = prefs.getDouble("Shooter P Gain", SHOOT_I);
		d = prefs.getDouble("Shooter P Gain", SHOOT_D);
		this.getPIDController().setPID(p, i, d);		
		
		// Register with Brownout subsystem
		Brownout.getInstance().registerCallback(this);		
	}
		
	protected void initDefaultCommand() {
		this.setDefaultCommand(new ShooterReset());	// Drive Manually by default
	}
	
	public void SetPoint(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	public boolean isOnSetPoint() {
		double error = this.getPIDController().getError();
		if (error >= 0 && error <= TOLERANCE) {
			return true;
		}
		else {
			return false;
		}
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
		
		SmartDashboard.putNumber("Latch Point", latchPoint);
		
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

	// PowerConsumer
	public void callbackAlert(Brownout.PowerLevel level) {
		switch (level) {
		case Chill:
			break;
			
		case Critical:
			break;
			
		default:
			break;
		}
	}
	
	//Is called during init
	public void cataCalibrate() {
		
		clearPoint = resetAngle.get();
		latchPoint = clearPoint - 0.4;
		hasBeenCalibrated = true;
	}
	
	//Has the robot been calibrated before?
	public boolean HasBeenCalibrated() {
		return hasBeenCalibrated;
	}
	
	// Check Clear catapult limit switch
	public boolean checkClearLimit() {
		return resetBar.isFwdLimitSwitchClosed();
	}
	
	// Check Latch catapult limit switch
	public boolean checkLatchLimit() {
		return resetBar.isRevLimitSwitchClosed();
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
			SmartDashboard.putNumber("Shooter Setpoint", this.getSetpoint());
			SmartDashboard.putNumber("Shooter Current",
					Brownout.getInstance().getCurrent(WINCH_PDP_CHANNEL));			
		}
		resetBar.set(check4Endpoints(output));
	}

	private double check4Endpoints(double speed) {
		SmartDashboard.putBoolean("Shooter Out of Calibration", false);
		// If trying to drive and a limit switch is hit, then stop...
		if(checkClearLimit() && speed > 0.0) {
			speed = 0.0;
			if (Math.abs(resetAngle.get() - clearPoint) > .2)
				SmartDashboard.putBoolean("Shooter Out of Calibration", true);
		}
		else if(checkLatchLimit() && speed < 0.0) {
			speed = 0.0;
			if (Math.abs(resetAngle.get() - latchPoint) > .2)
				SmartDashboard.putBoolean("Shooter Out of Calibration", true);
		}
		return(speed);
	}
}
