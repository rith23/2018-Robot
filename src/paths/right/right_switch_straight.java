package paths.right;

import org.usfirst.frc.team670.robot.Robot;
import org.usfirst.frc.team670.robot.commands.auto_specific.Delay;
import org.usfirst.frc.team670.robot.commands.drive.Drive;
import org.usfirst.frc.team670.robot.commands.drive.Pivot;
import org.usfirst.frc.team670.robot.commands.drive.Time_Drive;
import org.usfirst.frc.team670.robot.commands.elevator.Encoders_Elevator;
import org.usfirst.frc.team670.robot.commands.intake.Deploy;
import org.usfirst.frc.team670.robot.commands.intake.DropCube;
import org.usfirst.frc.team670.robot.commands.intake.SpinIntake;
import org.usfirst.frc.team670.robot.constants.Field;
import org.usfirst.frc.team670.robot.constants.RoboConstants;
import org.usfirst.frc.team670.robot.constants.enums.ElevatorState;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *@pre Line up Robot with the switch
 */
public class right_switch_straight extends CommandGroup {

	/**
	 * 
	 * @pre Line up Robot with the switch
	 */
	public right_switch_straight() {
		// Add Commands here:
		// e.g. addSequential(new Command1());
		// addSequential(new Command2());
		// these will run in order.

		// To run multiple commands at the same time,
		// use addParallel()
		// e.g. addParallel(new Command1());
		// addSequential(new Command2());
		// Command1 and Command2 will run in parallel.

		// A command group will require all of the subsystems that each member
		// would require.
		// e.g. if Command1 requires chassis, and Command2 requires arm,
		// a CommandGroup containing them would require both the chassis and the
		// arm.
		addParallel(new Deploy(true));
		addSequential(new Drive(Field.DS_TO_SWITCH - Robot.length - 18));
		addSequential(new Encoders_Elevator(ElevatorState.SWITCH));
		addSequential(new Drive(12));
		addSequential(new Time_Drive(1, 0.6));
    	addSequential(new DropCube());
    	addSequential(new Drive(-Robot.length));
    	addParallel(new Encoders_Elevator(ElevatorState.EXCHANGE));
    	addSequential(new Pivot(90));
    	addSequential(new Drive(Field.SIDE_TO_SWITCH + Robot.width));
    	addSequential(new Drive(Robot.length - Field.SIDE_TRIANGLE_WIDTH));
    	addSequential(new Pivot(-90));
    	addSequential(new Drive(Robot.length + Field.SWITCH_WIDTH + (Field.DS_TO_PLATFORM - Field.DS_TO_SWITCH)/2));
    	addSequential(new Pivot(90));
	}
}
