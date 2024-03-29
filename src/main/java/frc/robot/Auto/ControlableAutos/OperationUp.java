// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ControlableAutos;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.Auto.ArmRelated.LiftUpAuto;
import frc.robot.Auto.ArmRelated.TiltUpAuto;
import frc.robot.Auto.ArmRelated.WinchPointCheck;
import frc.robot.Auto.ArmRelated.WinchRetractAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class OperationUp extends SequentialCommandGroup {
  /** Creates a new OperationUp. */
  public OperationUp() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new WinchPointCheck(27),
      new TiltUpAuto(),
      new LiftUpAuto(-29)

    );
  }
}
