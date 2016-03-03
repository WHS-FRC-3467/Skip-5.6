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
	public static final double FOVx= 47.0;
	
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
		
		double[] centerx = table.getNumberArray("centerX", defaultValue);
		double[] centery = table.getNumberArray("centerY", defaultValue);
		
		if (centerx.length == 1) {
		
				functionx[0] = centerx[0];
				functiony[0] = centery[0];
				
				if(functionx[0] >= targetx - TOLERANCEx && functionx[0] <= targetx + TOLERANCEx) {
					onTargetx = true;
				}
				
				if (functiony[0] >= targety - TOLERANCEy && functiony[0] <= targety + TOLERANCEy) {
					onTargety = true;
				}
				System.out.println("Centery" + functiony[0]);
				
				System.out.println("Centerx" + functionx[0]);
			}
			
			if (onTargetx && onTargety) {
				imageOnTarget = true;
			}
		}
	
	public double CalcAngle() {
		return 0.0;
	}
	
	public double getVisionAngle() {
		double amgle;
		return 0.0;
	}
	
	public double getCenterX() {
		return functionx[0];
	}
	
	public double getCenterY() {
		return functiony[0];
	}
	
	public boolean onGoalx() {
		return onTargetx;
	}
	
	public boolean onGoaly() {
		return onTargety;
	}
}	
