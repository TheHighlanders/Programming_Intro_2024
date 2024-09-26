// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.system.plant.DCMotor;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.DCMotorSim;

/** Add your docs here. */
public class Motor extends DCMotorSim{
    double appliedVoltage;
    public Motor(DCMotor gearbox, double gearing, double jKgMetersSquared) {
        super(gearbox, gearing, jKgMetersSquared);
    }

    public void set(double throttle){
        setInputVoltage(appliedVoltage = throttle * 4);
    }

    public double getAppliedVoltage(){
        return appliedVoltage;
    }

}
