// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
//import frc.robot.subsystems.intake;
////////import frc.robot.subsystems.launcherSubsystem;

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
 // private final Drive drive = new Drive(controller::getLeftY, controller::getRightY);
 ///////////// private final launcherSubsystem launcher = new launcherSubsystem();
  // private final intake intake = new intake();
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
  //  drive.setDefaultCommand(drive.driveCommand());
  }

  /**
   * Use this method to define your trigger->command mappings.
   */
  private void configureBindings() {
 //////////////   controller.a().whileTrue(launcher.getLaunchCommand());
  //  controller.b().whileTrue(Intake.getIntakeCommand());
 //   controller.x().whileTrue(Intake.getExhaustionCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    //return Commands.sequence(new PrintCommand(" A&B"), Commands.waitSeconds(5), new PrintCommand("C"), Commands.waitSeconds(2), new PrintCommand("D"));
    //return new raceCommandGroup();
    return Commands.race(new PrintCommand("nye"), new PrintCommand("lex").withTimeout(100000));
  }
}
