// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.SparkPIDController;
import com.revrobotics.CANSparkBase.ControlType;

import edu.wpi.first.math.kinematics.SwerveModuleState;

import com.revrobotics.CANSparkLowLevel.MotorType;

/** Add your docs here. */
public class Module {
    CANSparkMax drive;
    CANSparkMax rotate;
    SparkPIDController drivePID;
    SparkPIDController rotatePID;

    public Module() {
        drive = new CANSparkMax(1, MotorType.kBrushless);
        rotate = new CANSparkMax(2, MotorType.kBrushless);

        drivePID = drive.getPIDController();
        rotatePID = rotate.getPIDController();

        drivePID.setP(1);
        drivePID.setI(0);
        drivePID.setD(0);

        rotatePID.setP(1);
        rotatePID.setI(0);
        rotatePID.setD(0);

        drive.getEncoder().setPositionConversionFactor(0.468675);
        rotate.getEncoder().setPositionConversionFactor(28.125);
    }

    public void setModuleState(SwerveModuleState state) {
        double speed = state.speedMetersPerSecond;
        double rotation = state.angle.getDegrees();

        drivePID.setReference(speed, ControlType.kVelocity);
        rotatePID.setReference(rotation, ControlType.kPosition);
    }
}
