// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Launcher extends SubsystemBase {
  /** Creates a new Launcher. */
  Motor topFly;
  Motor bottomFly;
  public Launcher() {
    topFly = new Motor();
    bottomFly = new Motor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Top flywheel RPM: ", topFly.getAngularVelocityRPM());
    SmartDashboard.putNumber("Bottom flywheel RPM: ", bottomFly.getAngularVelocityRPM());
  }

  public void startFlyheeltopFly(){
    topFly.set(1);
  }

  public void startFlyheelbottomFly(){
    bottomFly.set(1);
  }

  public void stop(){
    topFly.set(0);
    bottomFly.set(1);
  }

  public void intake(){
    topFly.set(-.5);
    bottomFly.set(-.5);
  }
  public void stop(){
    topFly.set(0);
    bottomFly.set(0);
  }
  public void startLaunchWheel(){
    topFly.set(.85);
    bottomFly.set(.85);
  }
  
  public Command getlaunchCommand(){

      return new RunCommand( () -> { startLaunchWheel(); })                     //Both of these lines start spiing the wheels and once completed it stops the wheels
      .finallyDo(() -> stop()); // stops the wheels at the end of the Command   //Both of these lines start spiing the wheels and once completed it stops the wheels


  }



}


