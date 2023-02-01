// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
  private static final String kDefaultAuto = "Default";
  private static final String kCustomAuto = "My Auto";
  private String m_autoSelected;
  private final SendableChooser<String> m_chooser = new SendableChooser<>();
  private Joystick drivematrix; // driver joystick
  private Joystick operation; //operator joystick 
  public static Drivetrain drivetrain;
  double deadzone = 0.25;
  public static Lift lift;
  public static Turntable turntable;
  public static Winch winch;
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    drivematrix = new Joystick(0);
    drivematrix.setYChannel(1);
    drivematrix.setXChannel(4);
    drivetrain = new Drivetrain();
    operation = new Joystick(1);
    //operation.setYChannel(1);
    //operation.setXChannel(4);
    lift = new Lift();
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {}

  /**
   * This autonomous (along with the chooser code above) shows how to select between different
   * autonomous modes using the dashboard. The sendable chooser code works with the Java
   * SmartDashboard. If you prefer the LabVIEW Dashboard, remove all of the chooser code and
   * uncomment the getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to the switch structure
   * below with additional strings. If using the SendableChooser make sure to add them to the
   * chooser code above as well.
   */
  @Override
  public void autonomousInit() {
    m_autoSelected = m_chooser.getSelected();
    // m_autoSelected = SmartDashboard.getString("Auto Selector", kDefaultAuto);
    System.out.println("Auto selected: " + m_autoSelected);
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    switch (m_autoSelected) {
      case kCustomAuto:
        // Put custom auto code here
        break;
      case kDefaultAuto:
      default:
        // Put default auto code here
        break;
    }
  }

  /** This function is called once when teleop is enabled. */
  @Override
  public void teleopInit() {
    
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {
    drivetrain.arcadeDrive(drivematrix.getY(), drivematrix.getX());
    double throttledeadzone;
    double turnratedeadzone;

    if(Math.abs(drivematrix.getY())>deadzone){
      throttledeadzone = Math.pow(drivematrix.getY(), 1);
    } else{
      throttledeadzone = 0;
    }
    if(Math.abs(drivematrix.getX())>deadzone){
      turnratedeadzone = Math.pow(drivematrix.getX(), 1);
    } else {
      turnratedeadzone = 0;
    }

    if(operation.getRawAxis(1) >= 0.5){
      lift.liftspeed(0.5);
    } else if(operation.getRawAxis(1) >= -0.5) {
      lift.liftspeed(-0.5);
    } else {
      lift.liftspeed(0);
    }

    if(operation.getRawAxis(2) >= 0.5){
      turntable.turntablespeed(0.5);
    } else if(operation.getRawAxis(4) >= -0.5){
      turntable.turntablespeed(-0.5);
    } else{
      turntable.turntablespeed(0);
    }

    if(operation.getRawButton(6)){
      winch.winchmotorspeed(0.25);
    } else if(operation.getRawButton(7)){
      winch.winchmotorspeed(-0.25);
    } else {
      winch.winchmotorspeed(0);
    }









  }

  /** This function is called once when the robot is disabled. */
  @Override
  public void disabledInit() {

  }

  /** This function is called periodically when disabled. */
  @Override
  public void disabledPeriodic() {

  }

}
