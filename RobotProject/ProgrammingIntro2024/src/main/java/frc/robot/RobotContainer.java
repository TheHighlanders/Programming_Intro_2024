// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
//import frc.robot.subsystems.launcherSubsystem;
//import frc.robot.subsystems.Intake;
//import frc.robot.subsystems.Flywheel;

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
  /**private final Drive drive = new Drive(controller::getRightY, controller::getRightX); 
  private final launcherSubsystem launcher = new launcherSubsystem();
  private final Intake intake = new Intake();
  */
  //private final Flywheel flywheel = new Flywheel();
  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the trigger bindings
    configureBindings();
    // TODO: Set Default command for the Drive method, to the drive.driveCommand() command
    //drive.setDefaultCommand(drive.driveCommand());
  }

  /**
   * Use this method to define your trigger->command mappings. 
   */
  private void configureBindings() {
    // controller.a().whileTrue(launcher.getLaunchCommand());
    // controller.y().whileTrue(intake.getStartCommand());
    // controller.b().whileTrue(intake.getBackwardsCommand());
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    Command luxembourg = new PrintCommand("WOW!");
    Command red = new PrintCommand("Its a banana!");
    Command green = new PrintCommand("This is tasty");
    Command violet = new PrintCommand("I like bananas");
    Command emerald = new WaitCommand(5);
    Command lithuania = new WaitCommand(2);
    return Commands.sequence(luxembourg.alongWith(red),emerald,green,lithuania,violet);
    
  }
}
