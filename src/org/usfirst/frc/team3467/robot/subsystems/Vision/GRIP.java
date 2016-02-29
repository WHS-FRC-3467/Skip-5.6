package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIP {
	
	public NetworkTable table;
	public boolean imageOnTarget;
	
	public void createImage () {
		double[] defaultValue = new double[0];
		while (true) {
			double[] centerx = table.getNumberArray("centerX", defaultValue);
			
			double center = 150.1;
			double[] difference;
			double[] function = new double [0];
			
			for (double centers : centerx){
				System.out.println(centers + " ");
	//			difference = center + centerx;
			}
			
			for (int i = 0; i <= centerx.length; i++) {
				function[i] = 25 * Math.cos((9/32) * centerx[i]);
				//centers[i] = center;
			}
		}
	}	
}
	
