// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.simulation.FlywheelSim;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;
import edu.wpi.first.math.system.plant.LinearSystemId;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;
import edu.wpi.first.wpilibj2.command.Command;

public class Flywheel extends SubsystemBase {
  /** Creates a new Flywheel. */
  double setPoint = 1000;
  CANSparkMax flywheelMotor1;
  SparkPIDController PID;
  public Flywheel() {
    flywheelMotor1 = new CANSparkMax(51,MotorType.kBrushless);
    PID = flywheelMotor1.getPIDController();
    PID.setP(0.0002);
    PID.setI(0.00000048);
    PID.setD(0);
  }

  public Command spin() {
    return run(()-> PID.setReference(setPoint,ControlType.kVelocity));
  }

  public void setSetPoint(double newSetPoint) {
    setPoint = newSetPoint;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("setPoint", setPoint);
    SmartDashboard.putNumber("velocity",flywheelMotor1.getEncoder().getVelocity());
  }
}
