// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Drive extends SubsystemBase {
  //TODO: Declare some Motor Objects, one for each side of the robot drivetrain
  CANSparkMax left;
  CANSparkMax right;
  DoubleSupplier leftSupplier;
  DoubleSupplier rightSupplier;
  Field2d field = new Field2d();
  DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(0), 0, 0);
RelativeEncoder leftEncoder;
RelativeEncoder rightEncoder;
  /** Creates a new Drive. */
  public Drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    //TODO: Initialize Motor Objects
    left = new CANSparkMax(52, MotorType.kBrushless);
    right = new CANSparkMax(54, MotorType.kBrushless);

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
    SmartDashboard.putNumber("Left Motor Position", leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Motor Position", rightEncoder.getPosition());

  }

  public void drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // TODO: Implement this method, to set the motors to the throttle values from
    // the joystick
   double l =leftSupplier.getAsDouble();
    double r = rightSupplier.getAsDouble();
    
    left.set(l);
    right.set(r);
     leftEncoder = left.getEncoder();
     rightEncoder = right.getEncoder();

    // TODO: (Optional) Implement Arcade (One Stick) Driving
    // Y Axis controls forward motion, X Axis controls rotation
    left.set(-leftSupplier.getAsDouble() + rightSupplier.getAsDouble());
    right.set(-leftSupplier.getAsDouble() - rightSupplier.getAsDouble());

  }

  @Override
  public void simulationPeriodic() {
    
  }
}
