package org.usfirst.frc.team3467.robot.subsystems.Vision;

import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.Rect;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Timer;

public class Video {

	public static int session;
	public static Image frame;
	public static AxisCamera Camera;
	
	
	
	public Video() {
		frame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		Camera = new AxisCamera("169.254.44.56");
		
		
	}
	public boolean operatorControl() {
		NIVision.Rect rect = new NIVision.Rect(10, 10, 100, 100);
		
		while (operatorControl()) {
			Camera.getImage(frame);
			NIVision.imaqDrawShapeOnImage(frame, frame, rect,
					DrawMode.DRAW_VALUE, ShapeMode.SHAPE_OVAL, 0.0f);
			
			CameraServer.getInstance().setImage(frame);
			
			Timer.delay(0.005);
		}
		return false;

	}
	
}
