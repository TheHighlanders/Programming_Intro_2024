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
public class yabbaDabba {

    CANSparkMax robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrive;; 
    CANSparkMax robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotate;;
    SparkPIDController robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID;;
    SparkPIDController robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID;;

    public yabbaDabba() {
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrive = new CANSparkMax(1, MotorType.kBrushless);;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotate = new CANSparkMax(2, MotorType.kBrushless);;

        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID = robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrive.getPIDController();;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID = robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotate.getPIDController();;
        
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID.setP(1);;
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID.setI(0);;
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID.setD(0);;

        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID.setP(1);;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID.setI(0);;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID.setD(0);;
    
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrive.getEncoder().setPositionConversionFactor(0.46875);;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotate.getEncoder().setPositionConversionFactor(28.125);
    }
    public void setTheStateOfTheModule(SwerveModuleState state) {
        double theSpeedOfASingleWheel = state.speedMetersPerSecond;;
        double theRotationAxisOfASingleWheel = state.angle.getDegrees();;
    
        robotWheelVerticalAxisRotationHandlerWhichSummedUpMeansDrivePID.setReference(theSpeedOfASingleWheel, ControlType.kVelocity);;
        robotWheelHorizontalAxisRotationHandlerWhichSummedUpMeansRotatePID.setReference(theRotationAxisOfASingleWheel, ControlType.kPosition);;
    }
}
