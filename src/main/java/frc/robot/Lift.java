// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

public class Lift extends SubsystemBase {
  /** Creates a new Lift. */
/*  private CANSparkMax liftmotor1 = new CANSparkMax(9, MotorType.kBrushed);
  private CANSparkMax liftmotor2 = new CANSparkMax(8, MotorType.kBrushed);
  private MotorControllerGroup liftControllerGroup = new MotorControllerGroup(liftmotor1, liftmotor2);

  public Lift() {}

public void liftspeed(double speed){
  liftControllerGroup.set(speed);
} */

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
