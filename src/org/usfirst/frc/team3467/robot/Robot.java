
package org.usfirst.frc.team3467.robot;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;








//Import subsystem classes from subsystem packages
import org.usfirst.frc.team3467.robot.commands.CommandBase;
	
import org.usfirst.frc.team3467.robot.commands.autonomous.AutoCheval;
//Import robot commands from command packages
import org.usfirst.frc.team3467.robot.commands.autonomous.AutoDriveStraight;
import org.usfirst.frc.team3467.robot.commands.autonomous.AutoLowBar;
import org.usfirst.frc.team3467.robot.commands.autonomous.AutoNon;
import org.usfirst.frc.team3467.robot.commands.autonomous.JustDriveFor5;
import org.usfirst.frc.team3467.robot.subsystems.DriveBase.commands.AutoRotateToAngle;
import org.usfirst.frc.team3467.robot.subsystems.Shooter.commands.ShooterOneWayCalibrate;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

    Command autonomousCommand;
	SendableChooser autoChooser;
    CameraServer cServer;
	
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {

     	// Init camera and start camera server instance
/*        cServer = CameraServer.getInstance();
        cServer.setQuality(50);
        cServer.setSize(1);
        //the camera name (ex "cam0") can be found through the roborio web interface
        cServer.startAutomaticCapture("cam0");
*/     

        // Initialize all subsystems
    	CommandBase.init();

    	
    	
    	// Add autonomous selector
		autoChooser = new SendableChooser();
		autoChooser.addDefault("Default Auto", new AutoNon());
		autoChooser.addObject("Drive Straight", new AutoDriveStraight());
		autoChooser.addObject("Turn 45", new AutoRotateToAngle(45));
		autoChooser.addObject("Turn 90", new AutoRotateToAngle(90));
		autoChooser.addObject("Drive for 5 secs", new JustDriveFor5());
		autoChooser.addObject("Auto Cheval", new AutoCheval());
		autoChooser.addObject("Auto Low Bar", new AutoLowBar());
		
		SmartDashboard.putData("Auto", autoChooser);
    }
	
    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){

    }

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

    public void autonomousInit() {

    	// schedule the autonomous command
		autonomousCommand = (Command) autoChooser.getSelected();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		
    	/* This makes sure that the autonomous stops running when
        	teleop starts running. If you want the autonomous to 
        	continue until interrupted by another command, remove
         	this line or comment it out.
         */
    	SmartDashboard.putString("Robot", "Teleop Inabled");
        if (autonomousCommand != null) autonomousCommand.cancel();
    
        if(CommandBase.pultaCat != null) {
        	//If the Shooter has not been calibrated, will calibrate
        	if (CommandBase.pultaCat.HasBeenCalibrated() == false) {
        	//	Scheduler.getInstance().add(new ShooterOneWayCalibrate());
        	}
        }
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        SmartDashboard.putString("Robot", "Teleop Periodic");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
