package org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

/**
 * Turn the robot to a given heading (in degrees relative to last reset heading;
 * negative values go counterclockwise).
 * Uses a local PID controller to run a simple PID loop that is only
 * enabled while this command is running. The input is the yaw() value from AHRS.
 */
public class AutoRotateToAngle extends CommandBase {

	private static final double TOLERANCE = 10;
	
	private PIDController m_pid;
	private double m_maxSpeed = 0.3;
	private double m_degrees = 0.0;
	
	private double KP = 1.0;
	private double KI = 0.0;
	private double KD = 0.0;
    	
    public AutoRotateToAngle(double degrees, double maxSpeed, double kp, double ki, double kd) {
                
    	requires(driveBase);
    	KP = kp; KI = ki; KD = kd;
    	m_maxSpeed = maxSpeed;
    	m_degrees = degrees;
    	buildController();
    }

	public AutoRotateToAngle(double degrees, double maxSpeed) {
                
		requires(driveBase);
    	m_maxSpeed = maxSpeed;
    	m_degrees = degrees;
    	buildController();
	}
    	
	public AutoRotateToAngle(double degrees) {
    	        
    	requires(driveBase);
    	m_degrees = degrees;
    	buildController();
	}
    	
    private void buildController() {
    		
       m_pid = new PIDController(KP, KI, KD,
                new PIDSource() {
                    PIDSourceType m_sourceType = PIDSourceType.kDisplacement;

                    public double pidGet() {
                        return ahrs.getGyroYaw();
                    }

                    public void setPIDSourceType(PIDSourceType pidSource) {
                      m_sourceType = pidSource;
                    }

                    public PIDSourceType getPIDSourceType() {
                        return m_sourceType;
                    }
                },
                new PIDOutput() {
                	
                	public void pidWrite(double d) {
                		// Spin with the magnitude returned by the PID calculation, 
                		driveBase.driveArcade(0, d, false);
                }});
		m_pid.setAbsoluteTolerance(TOLERANCE);
		m_pid.setOutputRange((m_maxSpeed * -1.0), m_maxSpeed);
        m_pid.setSetpoint(m_degrees);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Get everything in a safe starting state.
    	m_pid.reset();
        m_pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	double e = Math.abs(m_pid.getError());
    	return (e > 0 && e < TOLERANCE);
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop PID and the wheels
    	m_pid.disable();
        driveBase.driveArcade(0, 0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
