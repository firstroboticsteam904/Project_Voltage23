// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class DriveForAuto extends CommandBase {
  /** Creates a new DriveForAuto. */
  private double desiredForward;

  public DriveForAuto(double driveForward) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    desiredForward = driveForward;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //Robot.drivetrain.resetdistancetraveled();
    SmartDashboard.putString("Current Command", "DriveForward");
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double robovroom = Robot.drivetrain.getdistancetravled();
      if(robovroom > desiredForward ){
        Robot.drivetrain.arcadeDrive(0, -0.30);
      }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.drivetrain.getdistancetravled() < desiredForward) {
      Robot.drivetrain.arcadeDrive(0, 0);
      return true;
    } else {
      return false;
    }
  }
}
