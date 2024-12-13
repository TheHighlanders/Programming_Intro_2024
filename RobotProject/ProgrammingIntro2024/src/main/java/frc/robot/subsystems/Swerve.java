// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swerve extends SubsystemBase {
  /** Creates a new Swerve. */

  Module[] modules = {
    new Module(0,1),
    new Module(2,3),
    new Module(4,5),
    new Module(6,7)}; // makes 4 new swerve modules. each mdoule can be called bu using a number with in the square brakets "[]"


  public Swerve() {}

  public void drive(){
    modules[0].setThisModuleState(new SwerveModuleState(1, Rotation2d.fromDegrees(180)));// meters, angle in radians   you could use rotation2d.fromDegrees(number that is degrees)

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
