// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Subsystems;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;


public class Winch extends SubsystemBase {
  /** Creates a new Winch. */

 private CANSparkMax winchmotor1 = new CANSparkMax(8, MotorType.kBrushless);
 public RelativeEncoder winchencoder = winchmotor1.getEncoder();

  public Winch() {}

  public void winchmotorspeed(double speed){
    winchmotor1.set(speed);
    winchencoder = winchmotor1.getEncoder();

    SmartDashboard.putNumber("winch encoder ticks", winchencoder.getPosition());
  }

  public double winchtravel(){
    double winchticks = winchencoder.getPosition();

    return winchticks;
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
