// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkPIDController;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Wheel extends SubsystemBase {
  /** Creates a new Wheel. */

  // Creates the wheelMotor field, the motor controller
  private CANSparkMax wheelMotor;
  //Creates the wheelPID field, a PID controller to control the wheel
  private SparkPIDController wheelPID;

  //PID Controller constants!
  private double p = 0;
  private double i = 0;
  private double d = 0;

  private double setpoint = 0;

  RelativeEncoder wheelEncoder;
  public Wheel() {
    // Populates the wheelMotor field by creating a new CANSparkMax
    wheelMotor = new CANSparkMax(2, MotorType.kBrushless);

    // Populates the wheelPID field by getting the PID Controller of the motor controller
    wheelPID = wheelMotor.getPIDController();

    wheelPID.setP(p);
    wheelPID.setI(i);
    wheelPID.setD(d);

    wheelEncoder = wheelMotor.getEncoder();
    wheelEncoder.setPositionConversionFactor(28.125);
    wheelEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Position", wheelEncoder.getPosition());
    SmartDashboard.putNumber("Setpoint", setpoint);
  }

  public Command setpointCMD(double setpointDeg){
    return new RunCommand(()->{
      wheelPID.setReference(setpointDeg, ControlType.kPosition);
      setpoint = setpointDeg;
      }
    );
  }
}
