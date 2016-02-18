package org.usfirst.frc.team3467.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.PIDSubsystem;

public class Shooter extends PIDSubsystem{

	//Catapult Objects
	public CANTalon can;
	public Solenoid sun;
	
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
		
		can = new CANTalon(0);
		sun = new Solenoid(0);
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
	public void setSun(boolean abcdefghijklmnopqrstuvwxyz) {
		sun.set(abcdefghijklmnopqrstuvwxyz);
	}
	
	//Sets 
	public void setCan (double voot) {
		can.set(voot);
	}

	protected double returnPIDInput() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	protected void usePIDOutput(double output) {
		// TODO Auto-generated method stub
		
	}

	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}

}
