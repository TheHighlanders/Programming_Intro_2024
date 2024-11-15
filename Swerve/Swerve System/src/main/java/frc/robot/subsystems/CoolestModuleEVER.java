// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;
import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.units.Angle;

/** Add your docs here. */
public class CoolestModuleEVER {
    CANSparkMax coolestDriving;
    CANSparkMax coolestRotation;
    SparkPIDController coolestDrivingPID;
    SparkPIDController coolestRotationPID;



public CoolestModuleEVER() {
    coolestDriving = new CANSparkMax(1, MotorType.kBrushless);
    coolestRotation = new CANSparkMax(2, MotorType.kBrushless);

    coolestDrivingPID = coolestDriving.getPIDController();
    coolestRotationPID = coolestRotation.getPIDController();
    
    coolestDrivingPID.setP(1);
    coolestDrivingPID.setI(1);
    coolestDrivingPID.setD(1);

    coolestRotationPID.setP(1);
    coolestRotationPID.setI(1);
    coolestRotationPID.setD(1);

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
