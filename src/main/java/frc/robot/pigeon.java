// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

/*package frc.robot;
import com.ctre.phoenix.sensors.Pigeon2;
import com.ctre.phoenix.sensors.Pigeon2Configuration;
import com.ctre.phoenix.sensors.WPI_Pigeon2;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
/** Add your docs here.
 * 
public class pigeon {
private Pigeon2 m_pigeon;
private WPI_Pigeon2 m_pigeon_wpi;
//initializing the pigeon on can bus __
    //m_pigeon = new Pigeon2(_);

public void configurePigeon(){
    System.out.println("Current pigeon firmware ver: " + m_pigeon.getFirmwareVersion());
    m_pigeon.configFactoryDefault();
    m_pigeon.clearStickyFaults();
    final Pigeon2Configuration pigeonConfig = new Pigeon2Configuration();
    pigeonConfig.EnableCompass = true;
    pigeonConfig.MountPosePitch = 0;
    pigeonConfig.MountPoseRoll = 0;
    pigeonConfig.MountPoseYaw = 0;
    m_pigeon.configAllSettings(pigeonConfig);   
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
    
    //tilt gripper to proper angle

    //close gripper

    //initialize PID variables

    //get pigeon values

    //call drivetrain function arcade drive

    //using PID, driving train, and pigeon values, adjust position on balance beam 

  }
  
}

*/
