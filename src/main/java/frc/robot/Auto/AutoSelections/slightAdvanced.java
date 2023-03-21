// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.AutoSelections;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Auto.DriveAuto;
import frc.robot.Auto.ArmRelated.TableRightAuto;
import frc.robot.Auto.ArmRelated.WinchExtendAuto;
import frc.robot.Auto.ArmRelated.GrippersOpenAuto;
import frc.robot.Auto.ArmRelated.LiftUpAuto;
import frc.robot.Auto.ArmRelated.WinchRetractAuto;
import frc.robot.Auto.ArmRelated.TiltUpAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class slightAdvanced extends SequentialCommandGroup {
  /** Creates a new advancedAuto. */
  public slightAdvanced() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new LiftUpAuto(-35), 
    new TableRightAuto(-25), 
    new TiltUpAuto(),
    new WaitCommand(1), 
    new WinchExtendAuto(-25), //might be positive
    new WaitCommand(2),
    new GrippersOpenAuto(),
    new WaitCommand(1),
    new WinchRetractAuto(3), //should be 0 or opposite +/- of extend
    new DriveAuto(60)
    );
  }
}
