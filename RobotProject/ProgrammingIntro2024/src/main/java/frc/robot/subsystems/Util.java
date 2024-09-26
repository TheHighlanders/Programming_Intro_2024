// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.math.VecBuilder;
import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.RobotController;
import edu.wpi.first.wpilibj.simulation.AnalogGyroSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotGearing;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotMotor;
import edu.wpi.first.wpilibj.simulation.DifferentialDrivetrainSim.KitbotWheelSize;
import edu.wpi.first.wpilibj.simulation.EncoderSim;

/** Add your docs here. */
public class Util {
    private static AnalogGyro gyro = new AnalogGyro(1);
    private static AnalogGyroSim gyroSim = new AnalogGyroSim(gyro);

    // These represent our regular encoder objects, which we would
    // create to use on a real robot.
    private static Encoder m_leftEncoder = new Encoder(0, 1);
    private static Encoder m_rightEncoder = new Encoder(2, 3);

    // These are our EncoderSim objects, which we will only use in
    // simulation. However, you do not need to comment out these
    // declarations when you are deploying code to the roboRIO.
    private static EncoderSim m_leftEncoderSim = new EncoderSim(m_leftEncoder);
    private static EncoderSim m_rightEncoderSim = new EncoderSim(m_rightEncoder);

    static DifferentialDrivetrainSim sim = DifferentialDrivetrainSim.createKitbotSim(KitbotMotor.kSingleNEOPerSide,
            KitbotGearing.k10p71, KitbotWheelSize.kSixInch, 7.5,   null);
    static double lastTimestamp;

    public static void update(double left, double right) {
        m_leftEncoder.setDistancePerPulse(2 * Math.PI * Units.inchesToMeters(3) / 42);
        m_rightEncoder.setDistancePerPulse(2 * Math.PI * Units.inchesToMeters(3) / 42);

        sim.setInputs(left, right);
        // if (lastTimestamp != 0) {
        //     sim.update(RobotController.getFPGATime() / 1000000 - lastTimestamp);
        // }

        sim.update(0.02);
        // lastTimestamp = RobotController.getFPGATime() / 1000000;

        gyroSim.setAngle(-sim.getHeading().getDegrees());

        m_leftEncoderSim.setDistance(sim.getLeftPositionMeters());
        m_leftEncoderSim.setRate(sim.getLeftVelocityMetersPerSecond());
        m_rightEncoderSim.setDistance(sim.getRightPositionMeters());
        m_rightEncoderSim.setRate(sim.getRightVelocityMetersPerSecond());
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
