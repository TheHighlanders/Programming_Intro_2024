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
public class moduloe {
    CANSparkMax drive;  //move
    CANSparkMax rotate;  //spin(angle)
    SparkPIDController drivePID;
    SparkPIDController rotatePID;

    public moduloe () {                           //method that defines the peramiters of the module
        drive = new CANSparkMax(1, MotorType.kBrushless); //Note:when recreating dont type deviceId, VS code will automaticially put it in
        rotate = new CANSparkMax(2, MotorType.kBrushless); 

        drivePID = drive.getPIDController();
        rotatePID = rotate.getPIDController();

        drivePID.setP(0);                       //PID i think
        drivePID.setI(0);
        drivePID.setD(0);

        rotatePID.setP(0);
        rotatePID.setI(0);
        rotatePID.setD(0);
        
        drive.getEncoder().setPositionConversionFactor(0.468675);
        rotate.getEncoder().setPositionConversionFactor(28.125);
    }

    public void setModuleState(SwerveModuleState state) {               //swerveModuleState example (see 12/12/24 notes for more info)
        double speed = state.speedMetersPerSecond;
        double rotation = state.angle.getDegrees();

        drivePID.setReference(speed, ControlType.kVelocity);
        rotatePID.setReference(rotation, ControlType.kPosition);
    }

}