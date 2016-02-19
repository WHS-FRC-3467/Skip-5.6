package org.usfirst.frc.team3467.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;

public class Shooter extends PIDSubsystem{

	//Catapult Objects
	public CANTalon can;
	public DoubleSolenoid sun;
	public AnalogPotentiometer pot;
	public AnalogInput ai;
	
	//PID Constant
	private final double Shoot_P = 0.0;
	private final double Shoot_I = 0.0;
	private final double Shoot_D = 0.0;
	private final double Shoot_F = 0.0;

	private Shooter instance;
	
	//Shooter Constructor
	public Shooter() {
		super("Shooter", 0.0, 0.0, 0.0);

		instance = this;
		
		ai = new AnalogInput(RobotMap.catapult_analog_input);
		pot = new AnalogPotentiometer(ai);
		can = new CANTalon(RobotMap.catapult_Talon);
		sun = new DoubleSolenoid(RobotMap.catapult_solenoid_latch, 
								RobotMap.catapult_solenoid_release);
	}
		
	//Returns instance of Shooter Subsystem
	public Shooter getInstance() {
		return instance;
	}
	
	//Set solenoid value
	public void setSun(Value actuate) {
		sun.set(actuate);
	}
	
	//Sets CANTalon Value
	public void setCan (double voot) {
		can.set(voot);
	}

	public void SetPoint(double setpoint) {
		this.setSetpoint(setpoint);
	}
	
	
	protected double returnPIDInput() {
		return pot.get();
	}

	protected void usePIDOutput(double output) {
		SmartDashboard.putNumber("Shooter SetPoint", this.getSetpoint());
		can.set(output);
	}

	protected void initDefaultCommand() {
		this.setDefaultCommand(null);
	}

}
