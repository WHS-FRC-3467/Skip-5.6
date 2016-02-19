package org.usfirst.frc.team3467.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.RobotMap;

public class Shooter extends PIDSubsystem{

	//Catapult Objects
	public CANTalon can;
	public Solenoid sun;
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
		
		ai = new AnalogInput(RobotMap.catapult_AnalogIn);
		pot = new AnalogPotentiometer(ai);
		can = new CANTalon(RobotMap.catapult_Talon);
		sun = new Solenoid(RobotMap.catpult_Solenoid);
	}
		
	//Returns instance of Shooter Subsystem
	public Shooter getInstance() {
		return instance;
	}
	
	//Gets solenoid value
	public boolean getSun() {
		return sun.get();
	}
	
	//Set solenoid value
	public void setSun(boolean extend) {
		sun.set(extend);
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
