// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto;

import frc.robot.Robot;
import frc.robot.Subsystems.Drivetrain;

import javax.naming.spi.DirStateFactory;

import com.revrobotics.RelativeEncoder;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class DriveAuto extends CommandBase {
  /** Creates a new DriveAuto. */
  private double desiredDistance;

  public DriveAuto(double driveDistance) {
    // Use addRequirements() here to declare subsystem dependencies.
    super();
    desiredDistance = driveDistance;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivetrain.resetdistancetraveled();
    SmartDashboard.putString("Current Command", "Driveback");

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double robovroom = Robot.drivetrain.getdistancetravled();
    if (robovroom < desiredDistance) {
      Robot.drivetrain.arcadeDrive(0, 0.25);
      SmartDashboard.putString("reading auto?", "yes");
    }
    // // } else {
    // Robot.drivetrain.arcadeDrive(0, 0);
    // }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (Robot.drivetrain.getdistancetravled() > desiredDistance) {
      Robot.drivetrain.arcadeDrive(0, 0);
      return true;
    } else {
      return false;
    }

  }
}
