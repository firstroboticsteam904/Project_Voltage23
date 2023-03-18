// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto;

import frc.robot.Lift;
import frc.robot.Robot;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LiftAuto extends CommandBase {
  /** Creates a new LiftAuto. */

  double disiredliftticks;

  public LiftAuto(double liftautoticks) {
    // Use addRequirements() here to declare subsystem dependencies.
    disiredliftticks = liftautoticks;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double liftgo = Robot.lift.lifttravel();
    if(liftgo >= disiredliftticks){
      Robot.lift.liftspeed(-0.40);
    } else {
      Robot.lift.liftspeed(0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if(Robot.lift.lifttravel() <= disiredliftticks){
      Robot.lift.liftspeed(0);
      return true;
    } else {
      return false;
    }
  }
}
