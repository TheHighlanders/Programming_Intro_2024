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

public class launcherSubsystem extends SubsystemBase {
  /** Creates a new launcherSubsystem. */
  CANSparkMax motorUp;
  CANSparkMax motorDown;
  RelativeEncoder upEncoder;
  RelativeEncoder downEncoder;
  public launcherSubsystem() {
    motorUp = new CANSparkMax(51, MotorType.kBrushed );
    motorDown = new CANSparkMax(52, MotorType.kBrushed );
    upEncoder = motorUp.getEncoder();
    downEncoder = motorDown.getEncoder();
  }


  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("motorUp RPM", upEncoder.getVelocity());
    SmartDashboard.putNumber("motorDown RPM", downEncoder.getVelocity());

  }

//flywheel 
public void startFlyWheel1() {
motorUp.set(1);
}
public void startFlyWheel2() {
motorDown.set(1);
}
public void stop() {
motorUp.set(0);
motorDown.set(0);
}
public void intake(){
motorUp.set(0.5);
motorDown.set(0.5);
}
public Command getLaunchCommand(){
return new RunCommand(()->{
  startFlyWheel1();
  startFlyWheel2();
}
).finallyDo(()-> stop ());

}
//intake feed wheel command

public Command getIntakeCommand() {
return new RunCommand(
  ()->{
    intake();
  })
  .finallyDo(()-> stop());
} 
public Command getSpinUpCommand() {
return new RunCommand(
  ()->{
    startFlyWheel1();
  })
  .finallyDo(()-> stop());
}   
}