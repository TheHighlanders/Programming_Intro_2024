// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class FlywheelPID extends SubsystemBase {
  
  CANSparkMax m1;
  SparkPIDController pidc;
  
  public FlywheelPID() 
  {
  
  m1 = new CANSparkMax(51, MotorType.kBrushless);
  
  pidc = m1.getPIDController();
  
  pidc.setP(0.445);
  pidc.setI(0);
  pidc.setD(0);
  
  }

  public Command setPoint(double pointSetter) {
    return new RunCommand(() -> pidc.setReference(pointSetter, ControlType.kVelocity), this);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
