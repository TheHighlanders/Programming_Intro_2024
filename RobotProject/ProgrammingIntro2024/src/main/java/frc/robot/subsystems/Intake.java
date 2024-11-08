package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Intake extends SubsystemBase {
  /** Creates a new intake. */

  CANSparkMax intakeMotor;

  public Intake() {

    intakeMotor = new CANSparkMax(6, MotorType.kBrushless);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }



  public void stop() {
    intakeMotor.setVoltage(0);
  }

  public void intakeGround() {
    intakeMotor.setVoltage(-6); // intake from the ground
  }

  public void exhaustNote() {
    intakeMotor.setVoltage(+6); // rid of note
  }

  public Command getIntakeCommand() {
    return new RunCommand(() -> { intakeGround(); // supplier to send the intake from ground command
    }) .finallyDo(() -> stop());  // when it is not in use it "stops"
  }

  public Command getExhaustNoteCommand(){
      return new RunCommand( () -> { exhaustNote(); })  // supplier to send the "exhaustNote" command
      .finallyDo(() -> stop());  // when it is not in use it "stops"
  }
}