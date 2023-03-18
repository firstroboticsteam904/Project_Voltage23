// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ArmRelated;

import frc.robot.Robot;
import frc.robot.Subsystems.Turntable;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class TableLeftAuto extends CommandBase {
  /** Creates a new TableAuto. */

 double disiredtableticks;

  public TableLeftAuto(double tableautoticks) {
    // Use addRequirements() here to declare subsystem dependencies.
    disiredtableticks = tableautoticks;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double tableturn = Robot.turntable.tabletravel();
    if(tableturn <= disiredtableticks){
      Robot.turntable.turntablespeed(0.50);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.turntable.tabletravel() >= disiredtableticks){
      Robot.turntable.turntablespeed(0);
      return true;
    } else {
      return false;
    }
  }
}
