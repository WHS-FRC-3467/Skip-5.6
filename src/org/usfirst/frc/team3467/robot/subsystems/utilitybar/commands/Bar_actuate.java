package org.usfirst.frc.team3467.robot.subsystems.utilitybar.commands;

import org.usfirst.frc.team3467.robot.commands.CommandBase;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

// Command base is being extended from public class Bar_out
public class Bar_actuate extends CommandBase {
	
	private Value INorOUT;
	
	public Bar_actuate(Value inORout) {
	 requires(utilitybar);
	 INorOUT = inORout;
	}
	
	public Bar_actuate() {
		requires(utilitybar);
	}

	protected void initialize() {
		// TODO Auto-generated method stub
	}

	protected void execute() {
		utilitybar.setBar(INorOUT);
	}

	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}

	protected void end() {
		utilitybar.setBar(Value.kOff);
	}

	@Override
	protected void interrupted() {
		// TODO Auto-generated method stub
		
	}

}
