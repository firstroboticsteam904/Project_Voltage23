// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ControlableAutos;

import frc.robot.Auto.ArmRelated.LiftDownAuto;
import frc.robot.Auto.ArmRelated.LiftPointCheck;
import frc.robot.Auto.ArmRelated.TiltDownAuto;
import frc.robot.Auto.ArmRelated.WinchRetractAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class OperationDown extends SequentialCommandGroup {
  /** Creates a new OperationDown. */
  public OperationDown() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new WinchRetractAuto(39),
      new WaitCommand(0.2),
      new TiltDownAuto(),
      new WaitCommand(0.2),
      new LiftPointCheck(27)
    );
  }
}
