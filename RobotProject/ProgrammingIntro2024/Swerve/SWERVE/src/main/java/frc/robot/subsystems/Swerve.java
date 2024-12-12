// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swerve extends SubsystemBase {
  /** Creates a new Swerve. */
  Modulito[] modulitos = {
    new Modulito(0,1), 
    new Modulito(2,3), 
    new Modulito(4,5), 
    new Modulito(6,7)
  };

  public Swerve() {}

  public void drive() {
    modulitos[0].setThisModuleState(new SwerveModuleState(3, new Rotation2D.fromDegrees(200)))
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
