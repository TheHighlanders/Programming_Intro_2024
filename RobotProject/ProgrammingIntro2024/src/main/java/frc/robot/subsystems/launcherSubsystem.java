// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class launcherSubsystem extends SubsystemBase {
  /** Creates a new launcherSubsystem. */
  Motor motorUp;
  Motor motorDown;
  public launcherSubsystem() {
    motorUp = new Motor();
    motorDown = new Motor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    motorUp.update(0.02);
    motorDown.update(0.02);
    SmartDashboard.putNumber("motorUp RPM", motorUp.getAngularVelocityRPM());
    SmartDashboard.putNumber("motorDown RPM", motorDown.getAngularVelocityRPM());
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
motorUp.set(0.5);
motorDown.set(0.5);
}
public Command getLaunchCommand(){
return new RunCommand(()->{
  startFlywheel1();
  startFlywheel2();
}
).finallyDo(()-> stop ());

}
  
}