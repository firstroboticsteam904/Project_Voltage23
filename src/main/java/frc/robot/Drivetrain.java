// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  private DifferentialDrive drivetrain;
  private static final int leftmotorID = 2; // varible for motorcont 1
  private static final int rightmotorID = 3; /* varible for motorcont 2*/
  private CANSparkMax sam; //sam the motor controller
  private CANSparkMax tom; //tom the motor controller


  public void Drivetrain2() {

    tom = new CANSparkMax(leftmotorID, MotorType.kBrushless);
    sam =new CANSparkMax(rightmotorID, MotorType.kBrushless);
    drivetrain = new DifferentialDrive(tom, sam); //drivetrain name
    }
  
  
 public void arcadeDrive(double throttle, double turnrate)
  {
    drivetrain.arcadeDrive(throttle, -turnrate, false);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
