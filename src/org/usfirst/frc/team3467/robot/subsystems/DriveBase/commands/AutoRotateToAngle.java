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

	private PIDController pid;

    public AutoRotateToAngle(double degrees) {
    
    	requires(driveBase);
    	
        pid = new PIDController(2, 0, 0,
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
        pid.setAbsoluteTolerance(2.0);
        pid.setSetpoint(degrees);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	// Get everything in a safe starting state.
    	pid.reset();
    	ahrs.gyroReset();
        pid.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {}

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return (pid.onTarget() || (pid.getError() >= 0 && pid.getError() <= 0.1));
    }

    // Called once after isFinished returns true
    protected void end() {
    	// Stop PID and the wheels
    	pid.disable();
        driveBase.driveArcade(0, 0, false);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
        end();
    }
}
