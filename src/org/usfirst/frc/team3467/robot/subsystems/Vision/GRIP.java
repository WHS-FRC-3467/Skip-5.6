package org.usfirst.frc.team3467.robot.subsystems.Vision;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

public class GRIP {
	
	public NetworkTable table;
	
	
//Vision Processing Constants
	//Is the goal on target
	public boolean imageOnTarget = false;
	
	//Height of of the top of the Top Target
	public static final int TOP_TARGET_HEIGHT = 97;
	
	//Camera angles are different for different camera
	public static final int
	
	final double targetx = 150.1;
	final double targety = 0.0;
	
	private final double TOLERANCEx = 0.0;
	private final double TOLERANCEy = 0.0;
	
	//is the center of the goal, within the target ranges?
	boolean onTargetx = false;
	boolean onTargety = false;
			
	double[] functionx = new double [0];
	double[] functiony = new double [0];
	double[] defaultValue = new double[0];
	
	
	public void createImage () {
		
		while (true) {
			double[] centerx = table.getNumberArray("centerX", defaultValue);
			double[] centery = table.getNumberArray("centerY", defaultValue);
			
			for (int i = 0; i <= centerx.length; i++) {
				functionx[i] = centerx[i];
				functiony[i] = centery[i];
				
				if(functionx[i] >= targetx - TOLERANCEx && functionx[i] <= targetx + TOLERANCEx) {
					onTargetx = true;
				}
				
				if (functiony[i] >= targety - TOLERANCEy && functiony[i] <= targety + TOLERANCEy) {
					onTargety = true;
				}
				System.out.println("Centery" + functiony[j]);
				
				System.out.println("Centerx" + functionx[i]);
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
