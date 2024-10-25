package frc.robot.subsystems;


    // Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;
public class Intake extends SubsystemBase {
  /** Creates a new Intake. */
    public Intake () {
    MotorB = new Motor ();
    } 
      Motor MotorB; 
  @Override
  public void periodic() {
    MotorB.update(0.02);
    SmartDashboard.putNumber("Motor1", MotorB.getAngularVelocityRPM());
    MotorB.getAngularVelocityRPM();
  }
  public Command SuccCommand(){
    return new RunCommand(
      ()->{
      intake();
  })
  .finallyDo(() -> stop());
  }
   public Command EXCommand(){
    return new RunCommand(
      ()->{
      intake();
  })
  .finallyDo(() -> stop());
  }

public void stop(){
    MotorB.set(0);
  }
    public void intake(){
    MotorB.set(-1);
  }

    public void exausht(){
    MotorB.set(1);
  }
  
}
