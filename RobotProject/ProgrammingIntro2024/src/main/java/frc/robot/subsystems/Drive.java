// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import java.util.function.DoubleSupplier;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;
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
  // TODO: Declare some Motor Objects, one for each side of the robot drivetrain

  CANSparkMax right1;
  CANSparkMax left1;
  CANSparkMax right2;
  CANSparkMax left2;

//  RelativeEncoder leftEncoder;
//  RelativeEncoder rightEncoder;

  DoubleSupplier leftSupplier;
  DoubleSupplier rightSupplier;
  Field2d field = new Field2d();
  DifferentialDriveOdometry odo = new DifferentialDriveOdometry(new Rotation2d(0), 0, 0);

  RelativeEncoder endoder1;

  SparkPIDController pid1;

  /** Creates a new Drive. */
  public Drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // TODO: Initialize Motor Objects
    left1 = new CANSparkMax(2, MotorType.kBrushed);
    right1 = new CANSparkMax(1, MotorType.kBrushed);
    left2.follow(left1);
    right2.follow(right1);
    //RelativeEncoder leftEncoder = left1.getEncoder(); // used for brushless motors
   // RelativeEncoder rightEncoder = right1.getEncoder();

    this.leftSupplier = leftSupplier;
    this.rightSupplier = rightSupplier;

    pid1 = left1.getPIDController();
    pid1.setP(Math.PI); // set p to pi

    endoder1 = left1.getEncoder();


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

  public Command drivebackCommand(double speedys, double spinnys) {
    // Inline construction of command goes here.
    // Subsystem::RunOnce implicitly requires `this` subsystem.
    return run(() -> driveback(speedys, spinnys)); // (speed foward/back, right/left rotation)
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("Left Motor Position", leftEncoder.getPosition());  // puts the motors position using the encoder position on the dash board
    //SmartDashboard.putNumber("Right Motor Position", rightEncoder.getPosition());  // puts the motors position using the encoder position on the dash board

  }

  public void drive(DoubleSupplier leftSupplier, DoubleSupplier rightSupplier) {
    // TODO: Implement this method, to set the motors to the throttle values from
    // the joystick
    // left.set(leftSupplier.getAsDouble());
    // right.set(rightSupplier.getAsDouble());
    left1.set(-leftSupplier.getAsDouble() + rightSupplier.getAsDouble());
    right1.set(-leftSupplier.getAsDouble() - rightSupplier.getAsDouble());
    // TODO: (Optional) Implement Arcade (One Stick) Driving
    // Y Axis controls forward motion, X Axis controls rotation

  }
    public void driveback(double left, double right) {
    // TODO: Implement this method, to set the motors to the throttle values from
    // the joystick
    // left.set(leftSupplier.getAsDouble());
    // right.set(rightSupplier.getAsDouble());
    left1.set(-left + right);
    right1.set(-left - right);
    // TODO: (Optional) Implement Arcade (One Stick) Driving
    // Y Axis controls forward motion, X Axis controls rotation

  }


  @Override
  public void simulationPeriodic() {
    // This method will be called once per scheduler run during simulation

  }
}
