package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIP {
	
	public NetworkTable table;
	private double TOLERANCE = 0.0;
	
	//is the center of the goal, within the target ranges?
	boolean onTargetx;
	boolean onTargety;
	
	//Is the goal on target
	public boolean imageOnTarget;
				
	double targetx = 150.1;
	double targety = 0.0;
			
	double[] functionx = new double [0];
	double[] functiony = new double [0];
	
	double[] defaultValue = new double[0];
	
	public void createImage () {
		
		while (true) {
			double[] centerx = table.getNumberArray("centerX", defaultValue);
			double[] centery = table.getNumberArray("centerY", defaultValue);
			
			for (int i = 0; i <= centerx.length; i++) {
				functionx[i] = centerx[i];
				
				if(functionx[i] >= targetx - TOLERANCE && functionx[i] <= targetx + TOLERANCE) {
					onTargetx = true;
				}
				System.out.println("Centerx" + functionx[i]);
			}
			
			for (int j = 0; j <= centery.length; j++) {
				functiony[j] = centery[j];
				
				if (functiony[j] >= targety)
				System.out.println("Centery" + functiony[j]);
			}
			
			if (onTargetx && onTargety) {
				imageOnTarget = true;
			}
		}
	}
	
	public double[] getCenterX() {
		return functionx;
	}
	
	public double[] getCenterY() {
		return functiony;
	}
	
	public boolean onGoalx() {
		return onTargetx;
	}
	
	public boolean onGoaly() {
		return onTargety;
	}
}	
