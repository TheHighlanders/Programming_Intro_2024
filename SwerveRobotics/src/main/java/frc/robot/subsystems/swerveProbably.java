// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class swerveProbably extends SubsystemBase {
  moduloe[] muchosModulitos = {                                 //creating new modules
    new moduloe(0,1),
     new moduloe(2,3),                        //muchosModulitos.length tells us how many items are in an aray
      new moduloe(4,5),
       new moduloe(6,7)};           //creating new modules


  public swerveProbably() {}

  public void drive() {
      muchosModulitos[0].setModuleState(new SwerveModuleState(100,Rotation2d.fromDegrees(10)));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
