// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;
public class louncher extends SubsystemBase {
  /** Creates a new louncher. */
  Motor Motor1;
  Motor Motor3;
  public louncher() {
    Motor1 = new Motor ();
  Motor3 = new Motor ();
  }

  @Override
  public void periodic() {
    Motor1.update(0.02);
    Motor3.update(0.02);
    SmartDashboard.putNumber("Motor1", Motor1.getAngularVelocityRPM());
    Motor1.getAngularVelocityRPM();
    SmartDashboard.putNumber("Motor3", Motor3.getAngularVelocityRPM());
        Motor3.getAngularVelocityRPM();

  }
  public Command launchCommand(){
    return new RunCommand(
      ()->{
      startFlywheel1();
      startFlywheel2();
  })
  .finallyDo(() -> stop());
  }
  public void stop(){
    Motor1.set(0);
    Motor3.set(0);
  }
    public void intake(){
    Motor1.set(-0.5);
    Motor3.set(-0.5);
  }
public void startFlywheel1() {
 Motor1.set(1);
}
public void startFlywheel2() {
 Motor3.set(1);
}}