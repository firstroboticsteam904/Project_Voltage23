// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

public class Turntable extends SubsystemBase {
  /** Creates a new Turntable. */

  private CANSparkMax turntablemotor1 = new CANSparkMax(17, MotorType.kBrushless);



  public Turntable() {}

  public void turntablespeed(double speed){
  turntablemotor1.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
