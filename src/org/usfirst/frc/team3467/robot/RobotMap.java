package org.usfirst.frc.team3467.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
	//Important Drivebase Values
	
		//CANTalon Ports
		public static final int drivebase_LeftTalon = 1;
		public static final int drivebase_RightTalon = 2;

		public static final int drivebase_LeftTalon2 = 3;
		public static final int drivebase_LeftTalon3 = 4;
		public static final int drivebase_RightTalon2 = 5;
		public static final int drivebase_RightTalon3 = 6;
		
		
	//Important Intake Variables
		public static final int roller_TalonX = 7;
		public static final int roller_TalonY = 8;
		public static final int intake_solenoid_extend = 1;
		public static final int intake_solenoid_retract = 6;
		
		
	//Important Catapult Variables
		public static final int catapult_Talon = 9;
		public static final int catapult_solenoid_latch = 3;
		public static final int catapult_solenoid_release = 4;
		public static final int catapult_potentiometer_port = 0;
		
		
	//Important Utility Bar Variables
		public static final int utilitybar_solenoid_deploy = 2;
		public static final int utilitybar_solenoid_retract = 5;
		public static final int utilitybar_compressor = 0;
		
	//Important Utility Finger Variables
		public static final int utilityfinger_solenoid_in = 0;
		public static final int utilityfinger_solenoid_out = 7;
		
}
