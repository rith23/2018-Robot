package org.usfirst.frc.team670.robot.commands.drive;

import org.usfirst.frc.team670.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class Vision_Drive extends Command {

	private final double speed;

	public Vision_Drive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		speed = 0.3;
		requires(Robot.driveBase);
	}

	// Called just before this Command runs the first time
	protected void initialize() {

	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		Robot.driveBase.drive(speed, speed);
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return Robot.sensors.isCubeInIntake();
	}

	// Called once after isFinished returns true
	protected void end() {
		Robot.driveBase.drive(0, 0);
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
		end();
	}
}