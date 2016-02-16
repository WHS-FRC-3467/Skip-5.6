package org.usfirst.frc.team3467.robot.subsystems.Intake;

import org.usfirst.frc.team3467.robot.RobotMap;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Solenoid;
public class Rollers extends Subsystem {

	private CANTalon rollerTalonSRXX;
	private CANTalon rollerTalonSRXY;
	private Solenoid rollerSolenoid;
//	public rollerTalonSRX; //Define control method
	
	public Rollers(){
		//Instantiates CANTalons
		rollerTalonSRXX = new CANTalon(RobotMap.roller_TalonX);
		rollerTalonSRXY = new CANTalon(RobotMap.roller_TalonY);
		rollerSolenoid = new Solenoid(RobotMap.roller_solenoid);
		
		//Set control method to PercentVBus
		rollerTalonSRXX.changeControlMode(TalonControlMode.PercentVbus); 
		rollerTalonSRXY.changeControlMode(TalonControlMode.PercentVbus); 
	}
	
	//Sets value of Solenoid
	public void setSolenoid(boolean state){
		rollerSolenoid.set(state);
	}
	
	//Gets value of the Solenoid
	public boolean getSolenoid(){
		return rollerSolenoid.get();
	}
	
	public void intakeSlow(){
		//Turn motor on to medium setting
		rollerTalonSRXX.set(0.7);
		rollerTalonSRXY.set(0.7);
	}
	
	public void intakeFast() {
		//Turn motor on to maximum setting
		rollerTalonSRXX.set(1);
		rollerTalonSRXY.set(1);
	}
	
	public void lowShot() {
		//Turn motor on to maximum setting backwards
		rollerTalonSRXX.set(-1);
		rollerTalonSRXY.set(-1);
	}
	public void stopIntake(){
		//Turn motor off
		rollerTalonSRXX.set(0);
		rollerTalonSRXY.set(0);
	}

	@Override
	protected void initDefaultCommand() {
		// TODO Auto-generated method stub
		
	}
}
