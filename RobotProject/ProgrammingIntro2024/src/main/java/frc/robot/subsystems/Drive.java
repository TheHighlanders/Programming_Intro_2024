// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.kinematics.DifferentialDriveOdometry;
import edu.wpi.first.units.Units;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.Field2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drive extends SubsystemBase {
  // TODO: Declare some Motor Objects, one for each side of the robot drivetrain
  CANSparkMax leftMotor;
  CANSparkMax rightMotor;
  DoubleSupplier leftSupplier;
  DoubleSupplier rightSupplier;

  RelativeEncoder leftEncoder;
  RelativeEncoder rightEncoder;

  Field2d field = new Field2d();

  public final double kGearRatio = 8.46;

  DifferentialDriveOdometry odo;
  /** Creates a new Drive. */
  public Drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // TODO: Initialize Motor Objects
    leftMotor = new CANSparkMax(0,MotorType.kBrushless);
    rightMotor = new CANSparkMax(1, MotorType.kBrushless);
    
    this.leftSupplier = leftSupplier;
    this.rightSupplier = rightSupplier;
    
    leftEncoder = leftMotor.getEncoder();
    rightEncoder = rightMotor.getEncoder();

    leftEncoder.setPositionConversionFactor(Units.Inches.of(6).in(Units.Meters) * Math.PI * 2 * kGearRatio);
    rightEncoder.setPositionConversionFactor(Units.Inches.of(6).in(Units.Meters) * Math.PI * 2 * kGearRatio);

    leftEncoder.setPosition(0);
    rightEncoder.setPosition(0);

    odo = new DifferentialDriveOdometry(new Rotation2d(), Units.Meters.of(0), Units.Meters.of(0));

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
    SmartDashboard.putNumber("Left Motor Position", leftEncoder.getPosition());
    SmartDashboard.putNumber("Right Motor Position", rightEncoder.getPosition());

  }

  public void drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // TODO: Implement this method, to set the motors to the throttle values from
    // the joystick
    double l = -leftSupplier.getAsDouble();
    double r = rightSupplier.getAsDouble();
    leftMotor.set(l + r);
    rightMotor.set(l - r);
    // TODO: (Optional) Implement Arcade (One Stick) Driving
    // Y Axis controls forward motion, X Axis controls rotation
    

  }

  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation
    Util.update(leftMotor.getAppliedOutput() * RobotController.getInputVoltage(), rightMotor.getAppliedOutput() * RobotController.getInputVoltage());
    odo.update(Util.getHeading(), leftEncoder.getPosition(), rightEncoder.getPosition());
    // field.setRobotPose(Util.getPose());
    // leftMotor.update(0.02);
    // rightMotor.update(0.02);
  }
}
