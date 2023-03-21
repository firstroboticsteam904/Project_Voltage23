// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ArmRelated;

import frc.robot.Robot;
import frc.robot.Subsystems.Winch;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class WinchExtendAuto extends CommandBase {
  /** Creates a new WinchAuto. */

double disiredwinchticks;

  public WinchExtendAuto(double winchautoticks) {
    // Use addRequirements() here to declare subsystem dependencies.
    double disiredwinchticks = winchautoticks;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double winchspin = Robot.winch.winchtravel();
    if(winchspin <= disiredwinchticks){
      Robot.winch.winchmotorspeed(0.70);
    } 
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.winch.winchtravel() >= disiredwinchticks){
      Robot.winch.winchmotorspeed(0);
      return true;
    } else {
      return false;
    }

  }
}
