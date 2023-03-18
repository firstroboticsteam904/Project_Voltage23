// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.ControlableAutos;

import frc.robot.Auto.ArmRelated.LiftDownAuto;
import frc.robot.Auto.ArmRelated.TiltDownAuto;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class OperationDown extends SequentialCommandGroup {
  /** Creates a new OperationDown. */
  public OperationDown() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
      new TiltDownAuto(),
      new LiftDownAuto(5)

    );
  }
}
