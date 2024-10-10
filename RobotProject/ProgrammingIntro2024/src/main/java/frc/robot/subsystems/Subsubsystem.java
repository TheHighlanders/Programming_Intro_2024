// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Subsubsystem extends SubsystemBase {
  /** Creates a new Subsubsystem. */

  CANSparkMax le = new CANSparkMax(5, MotorType.kBrushless);
  CANSparkMax ri = new CANSparkMax(6, MotorType.kBrushless);

  public void rStartFlywheel() {
    ri.set(1);
  }

  public void lStartFlywheel() {
    le.set(1);
  }

  public void stop() {
    ri.set(0);
    le.set(0);
  }

  public void intake() {
    ri.set(-0.5);
    le.set(-0.5);
  }

  public Command intakeCMD() {
    return new RunCommand(
        () -> {
          intake();
        })
        .finallyDo(() -> stop());
  }

  public Command launchCMD() {
    return new RunCommand(
        () -> {
          rStartFlywheel();
          lStartFlywheel();
        })
        .finallyDo(() -> stop());
  }

  public Command spinUpCMD() {
    return new RunCommand(
        () -> {
          rStartFlywheel();
        });
       
  }

  RelativeEncoder leftEncoder;
  RelativeEncoder rightEncoder;

  public Subsubsystem() {
    leftEncoder = le.getEncoder();
    rightEncoder = ri.getEncoder();
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("Left Motor Position", leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Motor Position", rightEncoder.getPosition());
  }
}