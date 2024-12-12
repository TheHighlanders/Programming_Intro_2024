// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.kinematics.SwerveModuleState;


/** Add your docs here. */
public class Module {
    CANSparkMax coolestDriving;
    CANSparkMax coolestRotation;
    SparkPIDController coolestDrivingPID;
    SparkPIDController coolestRotationPID;



public Module(int driveID, int rotateID) {
    coolestDriving = new CANSparkMax(driveID, MotorType.kBrushless);
    coolestRotation = new CANSparkMax(rotateID, MotorType.kBrushless);

    coolestDrivingPID = coolestDriving.getPIDController();
    coolestRotationPID = coolestRotation.getPIDController();
    
    coolestDrivingPID.setP(0.5);
    coolestDrivingPID.setI(0);
    coolestDrivingPID.setD(0);

    coolestRotationPID.setP(0.5);
    coolestRotationPID.setI(0);
    coolestRotationPID.setD(0);

    coolestDriving.getEncoder().setPositionConversionFactor(0.468675);
    coolestRotation.getEncoder().setPositionConversionFactor(28.125);

}
 public void setCoolestModulestate(SwerveModuleState state) {
    double speed = state.speedMetersPerSecond;
    double rotation = state.angle.getDegrees();
    
    coolestDrivingPID.setReference(speed, ControlType.kVelocity);
    coolestRotationPID.setReference(rotation, ControlType.kPosition);

}




}
