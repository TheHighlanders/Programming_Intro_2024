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
public class Modulito {
    CANSparkMax drive; //move
    CANSparkMax rotate; //change wheel direction (angle)
    SparkPIDController drivePID;
    SparkPIDController rotatePID;

    public Modulito(int driveID, int rotateID) {   //the method that defines the parameters of the module
        drive = new CANSparkMax(3, MotorType.kBrushless);
        rotate = new CANSparkMax(2, MotorType.kBrushless);
        drivePID = drive.getPIDController();
        rotatePID = rotate.getPIDController();

        drivePID.setP(0.5);
        drivePID.setI(0);
        drivePID.setD(0);

        rotatePID.setP(0.5);
        rotatePID.setI(0);
        rotatePID.setD(0);

        drive.getEncoder().setPositionConversionFactor(0.46875);
        rotate.getEncoder().setPositionConversionFactor(28.125);
    }

    public void setThisModuleState (SwerveModuleState state) {
        double speed = state.speedMetersPerSecond;
        double rotation = state.angle.getDegrees();

        drivePID.setReference(speed, ControlType.kVelocity);
        rotatePID.setReference(rotation, ControlType.kPosition);
    }
}
