// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Launcher extends SubsystemBase {
  /** Creates a new Launcher. */
  CANSparkMax one;
  CANSparkMax two;

  public Launcher() {
    one = new CANSparkMax(2, MotorType.kBrushed);
    two = new CANSparkMax(3, MotorType.kBrushed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void startFlyheelOne() {
    one.set(1);
  }

  public void startFlyheelTwo() {
    two.set(1);
  }

  public void stop() {
    one.set(0);
    two.set(1);
  }

  public void intake() {
    one.set(-0.5);
    two.set(-0.5);
  }

  public Command launchCommand() {
    return new RunCommand(() -> {
      startFlyheelOne();
      startFlyheelTwo();
    }).finallyDo(() -> stop());
  }
}
