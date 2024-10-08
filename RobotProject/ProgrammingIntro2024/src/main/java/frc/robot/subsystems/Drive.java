// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Drive extends SubsystemBase {
  Motor left;
  Motor right;

  DoubleSupplier leftSupplier;
  DoubleSupplier rightSupplier;
  Field2d field = new Field2d();
  DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(0), 0, 0);

  /** Creates a new Drive. */
  public Drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    left = new Motor();
    right = new Motor();

    this.leftSupplier = leftSupplier;
    this.rightSupplier = rightSupplier;

    SmartDashboard.putData(field);
  }

  /**
   * Example command factory method.
   *
   * @return a command
   */
  public Command driveCommand() {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(() -> drive(leftSupplier, rightSupplier));
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Left Motor Position", Util.getLeftDistance());
    SmartDashboard.putNumber("Right Motor Position", Util.getRightDistance());

  }

  public void drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    left.set(-leftSupplier.getAsDouble() + rightSupplier.getAsDouble());
    right.set(-leftSupplier.getAsDouble() - rightSupplier.getAsDouble());
  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    Util.update(left.getAppliedVoltage(), right.getAppliedVoltage());
    odo.update(Util.getHeading(), Util.getLeftDistance(), Util.getRightDistance());
    field.setRobotPose(Util.getPose());
    left.update(0.02);
    right.update(0.02);
  }
}
