// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkLowLevel.MotorType;
import com.revrobotics.CANSparkMax;

public class Intake extends SubsystemBase {
  /** Creates a new Intake. **/
  CANSparkMax intakeMotor;
  public Intake() {
     intakeMotor = new CANSparkMax(8,MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void forward(){
  intakeMotor.set(1);
  }

  public void backwards(){
  intakeMotor.set(-0.5);
  }

  public void stop(){
  intakeMotor.set(0);
  }

  public Command getStartCommand(){
    return new RunCommand(()->{
       forward();
    }).finallyDo(()-> stop ());
  }

  public Command getBackwardsCommand(){
  return new RunCommand(()->{
    backwards();
  }).finallyDo(()-> stop ());
  }

  public Command getStopCommand(){
    return new RunCommand(()->{
      stop();
    });
  }
}