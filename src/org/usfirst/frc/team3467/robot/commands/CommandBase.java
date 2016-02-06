package org.usfirst.frc.team3467.robot.commands;

import java.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.OI;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.DriveBase;
import org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.MXP_IMU;

public abstract class CommandBase extends Command {
	
		//Create universal examples of subsystems
	public static CommandBase commandBase;
	public static OI oi;
	public static MXP_IMU imu;
	public static DriveBase driveBase;
	//public static MXP_IMU imu;
	
		//Create vector of with subsystems as elements
	public static Vector <Subsystem> subsystemList;
	
	
	public static void init() {
		SmartDashboard.putString("Yo", "Sup");
		
		//Make instance of vector known as subsystemList
		subsystemList = new Vector<Subsystem>();
		
		//Add instances of subsystems
		driveBase = new DriveBase();
		subsystemList.addElement(driveBase);
		imu = new MXP_IMU();
		subsystemList.addElement(imu);
		
		//Make instance of operator interface
		oi = new OI();
	}
	
	public CommandBase() {
		super();
		commandBase = this;
	}
	public CommandBase (String name) {
		super(name);
	}
	
}
