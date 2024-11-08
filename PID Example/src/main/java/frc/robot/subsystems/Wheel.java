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
  private double p = 1;
  private double i = 0;
  private double d = 0;
  // private double tolerance = 1;
  private double setpoint = 0;

  RelativeEncoder wheelEncoder;
  public Wheel() {
    // Populates the wheelMotor field by creating a new CANSparkMax
    wheelMotor = new CANSparkMax(51, MotorType.kBrushless);

    // Populates the wheelPID field by getting the PID Controller of the motor controller
    wheelPID = wheelMotor.getPIDController();
  
    wheelPID.setP(p);
    wheelPID.setI(i);
    wheelPID.setD(d);

    wheelEncoder = wheelMotor.getEncoder();
    wheelEncoder.setPositionConversionFactor(1);
    wheelEncoder.setVelocityConversionFactor(1);
    wheelEncoder.setPosition(0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Velocity", wheelEncoder.getVelocity());
    SmartDashboard.putNumber("Setpoint", setpoint);
    
    // SmartDashboard.putBoolean("Condition", Math.abs(wheelEncoder.getPosition()-setpoint) <= tolerance);
    // if(Math.abs(wheelEncoder.getPosition()-setpoint) <= tolerance) {
    //   wheelPID.setP(0);
    //   wheelPID.setI(0);
    //   wheelPID.setD(0);
    //   wheelPID.setReference(0,ControlType.kVoltage);
    // }

  }

  public Command setpointCMD(double setpointMPS){
    return new RunCommand(()->{
      // wheelPID.setP(p);
      // wheelPID.setI(i);
      // wheelPID.setD(d);
      wheelPID.setReference(setpointMPS, ControlType.kVelocity);
      setpoint = setpointMPS;
      }
    );
  }
}
