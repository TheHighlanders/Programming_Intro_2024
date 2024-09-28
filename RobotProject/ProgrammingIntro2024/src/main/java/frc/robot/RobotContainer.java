// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Launcher;

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
  private final Drive drive = new Drive(controller::getLeftY, controller::getLeftX);

  private final Launcher launcher = new Launcher(); // allows you to bea ble to refer to Launcher() as launcher


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
    controller.rightBumper().whileTrue(launcher.getlaunchCommand());
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
    return new PrintCommand("Auton");
  }
}
