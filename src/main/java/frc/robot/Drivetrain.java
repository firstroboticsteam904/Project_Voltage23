// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.CAN;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Drivetrain extends SubsystemBase {
  /** Creates a new Drivetrain. */
  
  private CANSparkMax leftmotor1 = new CANSparkMax(2, MotorType.kBrushless);
  private CANSparkMax leftmotor2 = new CANSparkMax(3, MotorType.kBrushless);
  private CANSparkMax leftmotor3 = new CANSparkMax(4, MotorType.kBrushless);
  private MotorControllerGroup leftmotorgroup = new MotorControllerGroup(leftmotor1, leftmotor2, leftmotor3);
  private CANSparkMax rightmotor1 = new CANSparkMax(5, MotorType.kBrushless);
  private CANSparkMax rightmotor2 = new CANSparkMax(6, MotorType.kBrushless);
  private CANSparkMax rightmotor3 = new CANSparkMax(7, MotorType.kBrushless);
  private MotorControllerGroup rightmotorgroup = new MotorControllerGroup(rightmotor1, rightmotor2, rightmotor3);
  public RelativeEncoder drivetrainencoder_right = rightmotor2.getEncoder();
  public RelativeEncoder drivetrainencoder_left = leftmotor2.getEncoder();
  double offset;


  private DifferentialDrive m_MyDrivetrain = new DifferentialDrive(leftmotorgroup, rightmotorgroup);
  //private DifferentialDrive m_MyDrivetrain = new DifferentialDrive(leftmotor1, rightmotor1);

  public void arcadeDrive(double throttle, double turnrate){
    m_MyDrivetrain.arcadeDrive(-throttle, -turnrate, false);
  }

  public void resetdistancetraveled(){
    drivetrainencoder_right.setPosition(0);
    offset = drivetrainencoder_right.getPosition();

    SmartDashboard.putNumber("encoder", offset);
  }


  public double getdistancetravled(){
    double realencoderticks = -drivetrainencoder_right.getPosition();

    double inches = realencoderticks * 0.004601;
    SmartDashboard.putNumber("Inches", inches);
    return inches;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
