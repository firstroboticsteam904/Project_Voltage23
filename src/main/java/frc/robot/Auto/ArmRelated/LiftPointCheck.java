// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ArmRelated;

import frc.robot.Robot;
import frc.robot.Subsystems.Lift;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LiftPointCheck extends CommandBase {
  /** Creates a new LiftAuto. */

  double disiredliftticks;

  public LiftPointCheck(double liftautoticks) {
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
    if(liftgo <= disiredliftticks){
      Robot.lift.liftspeed(0.40);
    } else if(liftgo >= disiredliftticks){
      Robot.lift.liftspeed(-.40);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if((Robot.lift.lifttravel() <= disiredliftticks + 1 ) && (Robot.lift.lifttravel() >= disiredliftticks - 1)){
      Robot.lift.liftspeed(0);
      return true;
    } else {
      return false;
    }
  }
}
