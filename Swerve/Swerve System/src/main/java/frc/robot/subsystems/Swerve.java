// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;



import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Swerve extends SubsystemBase {
 Module[] moduler = {
  new Module(0,1), 
  new Module(2,3), 
  new Module(4,5), 
  new Module(6,7)};
public Swerve() {

}
public void drive() {
  moduler[0].setCoolestModulestate(new SwerveModuleState(1,  Rotation2d.fromDegrees(360)));
}

  @Override
  public void periodic() {

  }
}
