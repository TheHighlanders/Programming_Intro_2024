// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Drive extends SubsystemBase {
  //TODO: Declare some Motor Objects, one for each side of the robot drivetrain
  CANSparkMax drivetrainLeft;
  CANSparkMax drivetrainRight;
  DoubleSupplier leftSupplier;
  DoubleSupplier rightSupplier;
  Field2d field = new Field2d();
  DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(0), 0, 0);

  /** Creates a new Drive. */
  public Drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    //TODO: Initialize Motor Objects
    drivetrainLeft = new CANSparkMax(5,MotorType.kBrushed);
    drivetrainRight = new CANSparkMax(8,MotorType.kBrushed);
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
    // TODO: Implement this method, to set the motors to the throttle values from
    // the joystick
    leftSupplier.getAsDouble();
    rightSupplier.getAsDouble();
    double leftSupplierDouble = leftSupplier.getAsDouble();
    double rightSupplierDouble = rightSupplier.getAsDouble();
    drivetrainLeft.set(leftSupplierDouble);
    drivetrainRight.set(rightSupplierDouble);
    // TODO: (Optional) Implement Arcade (One Stick) Driving
    // Y Axis controls forward motion, X Axis controls rotation
    drivetrainLeft.set(-leftSupplier.getAsDouble() - -rightSupplier.getAsDouble());
    drivetrainRight.set(-leftSupplier.getAsDouble() + -rightSupplier.getAsDouble());
  }

  @Override
  public void simulationPeriodic() {}
}
