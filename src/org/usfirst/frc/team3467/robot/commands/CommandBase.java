package org.usfirst.frc.team3467.robot.commands;

import java.util.Vector;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team3467.robot.OI;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.DriveBase;
import org.usfirst.frc.team3467.robot.subsystems.Brownout.Brownout;
import org.usfirst.frc.team3467.robot.subsystems.NavX_MXP.MXP_AHRS;
import org.usfirst.frc.team3467.robot.subsystems.utilitybar.Pnumatic_system;
import org.usfirst.frc.team3467.robot.subsystems.Intake.Intake;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.Shooter;
import org.usfirst.frc.team3467.robot.subsystems.Vision.Flashlight;
import org.usfirst.frc.team3467.robot.subsystems.Vision.Video;

public abstract class CommandBase extends Command {
	
		//Create universal examples of subsystems
	public static CommandBase commandBase;
	public static OI oi;
	public static MXP_AHRS ahrs;
	public static DriveBase driveBase;
	public static Brownout brownout;
	public static Pnumatic_system utilitybar;
	public static Shooter pultaCat;
	public static Intake intake;
	public static Flashlight light;
	public static Video video;
	
	public static boolean ISCompBot = true;
	
		//Create vector with subsystemss as elements for global subsystem commands
	public static Vector <Subsystem> subsystemList;
	
	
	public static void init() {
		System.out.println("Command Base Initialized");
		
		//Make instance of vector known as subsystemList
		subsystemList = new Vector<Subsystem>();
		
		//Add instances of subsystems
		driveBase = new DriveBase();
		subsystemList.addElement(driveBase);
		brownout = Brownout.getInstance();
		subsystemList.addElement(brownout);
		ahrs = new MXP_AHRS();
		subsystemList.addElement(ahrs);
		utilitybar = new Pnumatic_system();
		subsystemList.addElement(utilitybar);
		pultaCat = new Shooter(ISCompBot);
		subsystemList.addElement(pultaCat);
		intake = new Intake();
		subsystemList.addElement(intake);
		light = new Flashlight();
		subsystemList.addElement(light);
		
		video = new Video();
		oi = new OI();
//		oi.BindCommands(oi.getUserlogin());
//		oi.getUserlogin();
		oi.BindCommands();
	}
	
	public CommandBase() {
		super();
		commandBase = this;
	}
	public CommandBase (String name) {
		super(name);
	}
}