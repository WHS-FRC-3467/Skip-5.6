package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIP {
	
	NetworkTable table;
	
	public void createImage () {
		double[] defaultValue = new double[0];
		while (true) {
			double[] centerx = table.getNumberArray("centerX", defaultValue);
			
			double center = 150.1;
			double[] difference;
			
			for (double centers : centerx){
	//			difference = center + centerx;
			}
		}
	}	
}
	
