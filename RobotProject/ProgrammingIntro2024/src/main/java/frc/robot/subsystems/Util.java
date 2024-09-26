// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;

/** Add your docs here. */
public class Util {
    private static AnalogGyro gyro = new AnalogGyro(1);
    private static AnalogGyroSim gyroSim = new AnalogGyroSim(gyro);


    static DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kSingleNEOPerSide,
            KitbotGearing.k10p71, KitbotWheelSize.kSixInch, 7.5,   null);
    static double lastTimestamp;

    public static void update(double left, double right) {
        sim.setInputs(left, right);
        // if (lastTimestamp != 0) {
        //     sim.update(RobotController.getFPGATime() / 1000000 - lastTimestamp);
        // }

        sim.update(0.02);
        // lastTimestamp = RobotController.getFPGATime() / 1000000;

        gyroSim.setAngle(-sim.getHeading().getDegrees());
    }

    public static double getLeftDistance() {
        return sim.getLeftPositionMeters();
    }

    public static double getRightDistance() {
        return sim.getRightPositionMeters();
    }

    public static Rotation2d getHeading() {
        return sim.getHeading();
    }

    public static Pose2d getPose() {
        return sim.getPose();
    }

}
