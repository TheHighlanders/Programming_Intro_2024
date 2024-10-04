// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Shooter extends SubsystemBase {
  /** Creates a new Subsubsystem. */

  CANSparkMax ri = new CANSparkMax(51, MotorType.kBrushless);
  CANSparkMax le = new CANSparkMax(52, MotorType.kBrushless);

  RelativeEncoder leftEncoder;
  RelativeEncoder rightEncoder;

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

  public Command launchCMD() {
    return new RunCommand(
        () -> {
          rStartFlywheel();
          lStartFlywheel();
        })
        .finallyDo(() -> stop());
  }

  public Shooter() {
    leftEncoder = le.getEncoder();
    rightEncoder = ri.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run

    SmartDashboard.putNumber("right RPM", rightEncoder.getVelocity());
    SmartDashboard.putNumber("left RPM", leftEncoder.getVelocity());
  }
  public Command intakeCMD() {
    return new RunCommand(
        () -> {
          intake();
        })
        .finallyDo(() -> stop());
  }  public Command spinupCMD() {
    return new RunCommand(
        () -> {
          rStartFlywheel();
        })
        .finallyDo(() -> stop());
  }}