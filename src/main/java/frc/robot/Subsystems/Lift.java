// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.SparkMaxAbsoluteEncoder.Type;
import edu.wpi.first.wpilibj.smartdashboard.*;

import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.AbsoluteEncoder;
public class Lift extends SubsystemBase {
  /** Creates a new Lift. */
 public CANSparkMax liftmotor1 = new CANSparkMax(9, MotorType.kBrushless);
  private MotorControllerGroup liftControllerGroup = new MotorControllerGroup(liftmotor1);
  public RelativeEncoder relliftencoder = liftmotor1.getEncoder();
  //public AbsoluteEncoder Absliftencoder = liftmotor1.getAbsoluteEncoder(Type.kDutyCycle);
  public Lift() {}

public void liftspeed(double speed){
  liftControllerGroup.set(speed);
  relliftencoder = liftmotor1.getEncoder();
  //Absliftencoder = liftmotor1.getAbsoluteEncoder(Type.kDutyCycle);
  SmartDashboard.putNumber("relative lift Encoder Position in Units of Revolutions", relliftencoder.getPosition());
  //SmartDashboard.putNumber("absolute lift Encoder Position in Units of Revolutions", Absliftencoder.getPosition());
} 

public double lifttravel(){
  double liftticks = relliftencoder.getPosition();

  return liftticks;
}

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
