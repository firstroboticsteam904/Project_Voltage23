// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Compressor;
//import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.PneumaticHub;

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
  private Joystick operation;  
  public static Drivetrain drivetrain;
  double deadzone = 0.25;
  public static Lift lift;
  public static Turntable turntable;
  public static Winch winch;
  //Compressor pcmCompressor = new Compressor(0, PneumaticsModuleType.REVPH);
  //PneumaticHub m_pH = new PneumaticHub();
  /*DoubleSolenoid solenoidintake = m_pH.makeDoubleSolenoid(10, 2);
  DoubleSolenoid solenoidclimb = m_pH.makeDoubleSolenoid(1, 9);
  DoubleSolenoid solenoidmiddle = m_pH.makeDoubleSolenoid(0, 8);*/
  //public static Solenoid leftDTsolenoid = new Solenoid(PneumaticsModuleType.REVPH, 0);
  //public static Solenoid rightDTsolenoid = new Solenoid(PneumaticsModuleType.REVPH, 1);
  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */
  @Override
  public void robotInit() {
    m_chooser.setDefaultOption("Default Auto", kDefaultAuto);
    m_chooser.addOption("My Auto", kCustomAuto);
    SmartDashboard.putData("Auto choices", m_chooser);
    drivematrix = new Joystick(0); //initialize the driver joystick on port 1
    drivematrix.setYChannel(1); //initialize the y axis controller on joystick channel 1
    drivematrix.setXChannel(4); //initialize the x axis controller on joystick channel 4
    drivetrain = new Drivetrain();
    operation = new Joystick(1); //initialize the operator joystick on port 1
    //operation.setYChannel(1);
    //operation.setXChannel(4);
    lift = new Lift();
    //Pneumatic solenoids are set below. Three solenoids are set to be in reverse, forward, and forward to begin
    //pcmCompressor.enableDigital();
    /*solenoidintake.set(DoubleSolenoid.Value.kReverse);
    solenoidclimb.set(DoubleSolenoid.Value.kForward);
    solenoidmiddle.set(DoubleSolenoid.Value.kForward);*/

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
    double throttledeadzone;
    double turnratedeadzone;

    if(Math.abs(drivematrix.getY())>deadzone){
      throttledeadzone = Math.pow(drivematrix.getY(), 3);
    } else{
      throttledeadzone = 0;
    }
    if(Math.abs(drivematrix.getX())>deadzone){
      turnratedeadzone = Math.pow(drivematrix.getX(), 3);
    } else {
      turnratedeadzone = 0;
    }

    drivetrain.arcadeDrive(turnratedeadzone, throttledeadzone);

/*   if(operation.getRawAxis(1) >= 0.5){
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

     //if the right bumper button is pressed on the operator controller, activate the winch motor
    if(operation.getRawButton(6)){
      winch.winchmotorspeed(0.25);
    } else if(operation.getRawButton(7)){ //if the left trigger button is pressed on the operator controller, deactivate the winch controller
      winch.winchmotorspeed(-0.25);
    } else {
      winch.winchmotorspeed(0);
    }*/
    //if the x button is pressed on the operator controller, set the climb solenoid to the reverse position
/*  if (operation.getRawButton(1)) {
      solenoidclimb.set(DoubleSolenoid.Value.kReverse);
    }
    //if the A button is pressed on the operator controller, set the climb solenoid to the forward position
    if (operation.getRawButton(2)) {
      solenoidclimb.set(DoubleSolenoid.Value.kForward);
    }
    //if the left bumber button is pressed on the operator controller, set the intake solenoid to forward
    if (operation.getRawButton(5)){
      solenoidintake.set(DoubleSolenoid.Value.kForward);
    }
    else {
      solenoidintake.set(DoubleSolenoid.Value.kReverse);
    }
    //if the right trigger is pressed on the operator controller, set the middle solenoid to the reverse position
    if (operation.getRawButton(8)){
      solenoidmiddle.set(DoubleSolenoid.Value.kReverse);

    }  else {
      solenoidmiddle.set(DoubleSolenoid.Value.kForward);
    }
*/








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
