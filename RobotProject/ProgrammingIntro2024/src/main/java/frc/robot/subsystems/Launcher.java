// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Motor;

public class Launcher extends SubsystemBase {
  /** Creates a new Launcher. */
  //DCMotorSim topFly;
  //DCMotorSim bottomFly;
  CANSparkMax topFly;
  CANSparkMax bottomFly;
  
  public Launcher() {
    //topFly = new DCMotorSim(DCMotor.getNEO(1),1,0.1);
    //bottomFly = new DCMotorSim(DCMotor.getNEO(1),1,0.1); // motor, gear ratio, moment of intertia
    topFly = new CANSparkMax(51, MotorType.kBrushless);
    bottomFly = new CANSparkMax(52, MotorType.kBrushless);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //SmartDashboard.putNumber("Top flywheel RPM", topFly.getAngularVelocityRPM());
    //SmartDashboard.putNumber("Bottom flywheel RPM", bottomFly.getAngularVelocityRPM());
    ///topFly.update(.02);
    //bottomFly.update(.02);
  }

  public void startFlyheeltopFly(){
    topFly.setVoltage(12);
  }

  public void startFlyheelbottomFly(){
    bottomFly.setVoltage(12);
  }

  public void intake(){
    topFly.setVoltage(-6);
    bottomFly.setVoltage(-6);
  }
  public void stop(){
    topFly.setVoltage(0);
    bottomFly.setVoltage(0);
  }
  public void startLaunchWheel(){
    topFly.setVoltage(10);
    bottomFly.setVoltage(10);
  }
  
  public Command getlaunchCommand(){

      return new RunCommand( () -> { startLaunchWheel(); })                     //Both of these lines start spiing the wheels and once completed it stops the wheels
      .finallyDo(() -> stop()); // stops the wheels at the end of the Command   //Both of these lines start spiing the wheels and once completed it stops the wheels


  }



}


