package org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// Command base is being extended from public class Bar_out
public class Bar_actuate extends CommandBase {
	
	private Value INOROUT;
	
	public Bar_actuate(Value inORout) {
	 requires(utilitybar);
	 INOROUT = inORout;
	}
	
	public Bar_actuate() {
		requires(utilitybar);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
	}

	protected void execute() {
		utilitybar.setBar(INOROUT);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected void end() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
