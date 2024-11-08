package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class intake extends SubsystemBase {
    CANSparkMax intakeMotor;

    public intake() {
        intakeMotor = new CANSparkMax(8, MotorType.kBrushless);
    }

    public void intakingNote() {
        intakeMotor.set(1);
    }

    public void intakeExhaustion() {
        intakeMotor.set(-1);
    }

    public void stop() {
        intakeMotor.set(0);
    }

    public Command getIntakeCommand() {
        return new RunCommand(
                () -> {
                    intakingNote();
                })
                .finallyDo(() -> stop());
    }

    public Command getExhaustionCommand() {
        return new RunCommand(
                () -> {
                    intakeExhaustion();
                })
                .finallyDo(() -> stop());
    }

}
