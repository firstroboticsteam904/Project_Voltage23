// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.revrobotics.RelativeEncoder;
import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;

public class Turntable extends SubsystemBase {
  /** Creates a new Turntable. */

  public CANSparkMax turntablemotor1 = new CANSparkMax(10, MotorType.kBrushless);
  public RelativeEncoder turntable_Encoder = turntablemotor1.getEncoder();
  public AbsoluteEncoder turnAbs_Encoder = turntablemotor1.getAbsoluteEncoder(Type.kDutyCycle);

  public Turntable() {}

  //set the speed on the turntable
  public void turntablespeed(double speed){
  turntablemotor1.set(speed); //set the turntable speed
    //get encoder value from turns
    turntable_Encoder = turntablemotor1.getEncoder();
    turnAbs_Encoder = turntablemotor1.getAbsoluteEncoder(Type.kDutyCycle);
    SmartDashboard.putNumber("relative turntable Encoder Position in Units of Revolutions", turntable_Encoder.getPosition());
    SmartDashboard.putNumber("absolute turntable Encoder Position in Units of Revolutions", turnAbs_Encoder.getPosition());
  }

  

  //get the encoder values from the SparkMax motors
  
  /*public void GetEncoderValue(){
    turntable_Encoder = turntablemotor1.getEncoder();
    turntable_Encoder.getPosition();
  }*/



  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
