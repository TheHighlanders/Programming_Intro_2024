// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Launcher;
import frc.robot.subsystems.Intake;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final CommandXboxController controller = new CommandXboxController(0);

  // The robot's subsystems and commands are defined here...
  private final Drive drive = new Drive(controller::getLeftY, controller::getRightX);

  private final Launcher launcher = new Launcher(); // allows you to bea ble to refer to Launcher() as launcher

  private final Intake intake = new Intake();
  

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    // TODO: Set Default command for the Drive method, to the drive.driveCommand() command
    drive.setDefaultCommand(drive.driveCommand());
  }

  /**
   * Use this method to define your trigger->command mappings. 
   */
  private void configureBindings() {
    //controller.a().whileTrue(Launcher.getlaunchCommand());
    //controller.rightTrigger(.5).whileTrue(Launcher.getlaunchCommand());
    //controller.rightBumper().whileTrue(launcher.getlaunchCommand());
    controller.rightTrigger(.5).whileTrue(launcher.getintakeShooterCommand());
    //controller.rightTrigger(.5).whileTrue(launcher.getspinTopCommand());
    controller.rightBumper().whileTrue(launcher.spinUpAndShootCommand());
    controller.x().whileTrue(intake.getIntakeCommand());
    controller.a().whileTrue(intake.getExhaustNoteCommand());
    // to do the b button you would do .b()
    // for a trigger you would replace .a() with .rightTrigger("threash hold maybe .5 for example")
 
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //goreturn launcher.getspinTopCommand().andThen(Commands.waitSeconds(2)).andThen(launcher.getlaunchCommand().withTimeout(1)).andThen(drive.drivebackCommand(.8,0).withTimeout(4)); //standard auto command that we made for kitbot
    final double coolDownTime = 1;

    return launcher.spinUpAndShootCommand() // launch
    .withTimeout(coolDownTime) // wait for launch to be completed
    .andThen(drive.drivebackCommand(.8,0)
    .withTimeout(3)) // go back at 80% power for 3 seconds, back up
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime)) // cool down for 1 second
    .andThen(drive.drivebackCommand(0,-.4) //spin at + 30% power for 1.5 seconds, turn right a bit
    .withTimeout(.5)) //spinnytime
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime)) // cool down for 1 second
    .andThen(drive.drivebackCommand(.8,0) // go back a bit
    .withTimeout(3)) // go back at 80% power for 3 seconds
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime)) // cool down for 1 second
    .andThen(drive.drivebackCommand(0,+.4) //spin back to original orientationat + 30% power for 1.5 seconds // spin left a bit
    .withTimeout(.5)) //spinnytime
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime)) // cool down for 1 second
    .andThen(drive.drivebackCommand(.8,0) // go back a bit
    .withTimeout(3)) // go back at 80% power for 3 seconds
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime)) // cool down for 1 second
    .andThen(drive.drivebackCommand(0,1) // go back a bit
    .withTimeout(.8)) // go back at 80% power for 3 seconds
    .andThen(drive.drivebackCommand(0,0) // cool down
    .withTimeout(coolDownTime));
    
    //goofy go twords sorce auto positive spin is turn to right and positive go is ? so far
  }
}
