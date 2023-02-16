// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Winch extends SubsystemBase {
  /** Creates a new Winch. */

 /* private CANSparkMax winchmotor1 = new CANSparkMax(11, MotorType.kBrushless);

  public Winch() {}

  public void winchmotorspeed(double speed){
    winchmotor1.set(speed);
  }
*/
  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
