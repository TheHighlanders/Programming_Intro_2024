// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class launcherSubsystem extends SubsystemBase {
  /** Creates a new launcherSubsystem. */
  CANSparkMax motorUp;
  CANSparkMax motorDown;
  RelativeEncoder encoderUp;
  RelativeEncoder encoderDown;
  public launcherSubsystem() {
    motorUp = new CANSparkMax(5,MotorType.kBrushless);
    motorDown = new CANSparkMax(6,MotorType.kBrushless);
    encoderUp = motorUp.getEncoder();
    encoderDown = motorDown.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("motorUp RPM", encoderUp.getVelocity());
    SmartDashboard.putNumber("motorDown RPM", encoderDown.getVelocity());
  }

//flywheel 
public void startFlywheel1() {
motorUp.set(1);
}
public void startFlywheel2() {
motorDown.set(1);
}
public void stop() {
motorUp.set(0);
motorDown.set(0);
}
public void intake(){
motorUp.set(-0.5);
motorDown.set(-0.5);
}
public Command getIntakeCommand(){
  return new RunCommand(()->{
    intake();
  }).finallyDo(()-> stop ());
}
public Command getSpinUpCommand(){
  return new RunCommand(()->{
    startFlywheel1();
  }).finallyDo(()-> stop ());
}
public Command getLaunchCommand(){
return new RunCommand(()->{
  startFlywheel1();
  startFlywheel2();
}

).finallyDo(()-> stop ());
}
  
}