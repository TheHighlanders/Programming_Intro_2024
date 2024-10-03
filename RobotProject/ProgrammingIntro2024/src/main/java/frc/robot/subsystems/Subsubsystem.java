// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Subsubsystem extends SubsystemBase {
  /** Creates a new Subsubsystem. */

  Motor ri = new Motor();
  Motor le = new Motor();

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

  public Subsubsystem() {
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    ri.update(0.02);
    le.update(0.02);
    SmartDashboard.putNumber("right RPM", ri.getAngularVelocityRPM());
    SmartDashboard.putNumber("left RPM", le.getAngularVelocityRPM());
  }
}