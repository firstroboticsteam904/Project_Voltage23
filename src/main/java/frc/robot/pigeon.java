// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;
import com.ctre.phoenix.sensors.WPI_PigeonIMU;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// Add your docs here.
 
public class pigeon {
//initializing the pigeon on can bus __
WPI_PigeonIMU m_pigeon = new WPI_PigeonIMU(15); //pigeon on CAN device ID 15
public void configurePigeon(){
    System.out.println("Current pigeon firmware ver: " + m_pigeon.getFirmwareVersion());
    m_pigeon.configFactoryDefault();
    m_pigeon.clearStickyFaults();   
}

public void getPigeonValues(){
    System.out.println("Pigeon yaw: " + m_pigeon.getYaw());
    System.out.println("Pigeon pitch: " + m_pigeon.getPitch());
    System.out.println("Pigeon roll: " + m_pigeon.getRoll());
    System.out.println("Pigeon compass heading: " + m_pigeon.getCompassHeading());
    SmartDashboard.putNumber("Pigeon yaw", m_pigeon.getYaw());
    SmartDashboard.putNumber("Pigeon pitch", m_pigeon.getPitch());
    SmartDashboard.putNumber("Pigeon roll", m_pigeon.getRoll());
    SmartDashboard.putNumber("Pigeon compass heading", m_pigeon.getCompassHeading());
  }

  //function to autobalance robot on the charging station
  public void AutoBalanceRobot(){
    //move lift in if it is out
    double output = m_pigeon.getPitch();

    output *= 0.02;
    Robot.drivetrain.arcadeDrive(output, 0);
    //tilt gripper to proper angle
  }
}


