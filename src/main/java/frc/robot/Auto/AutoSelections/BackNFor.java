// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.AutoSelections;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Auto.DriveAuto;
import frc.robot.Auto.DriveForAuto;
import frc.robot.Auto.ArmRelated.GrippersOpenAuto;
import frc.robot.Auto.ArmRelated.LiftUpAuto;
import frc.robot.Auto.ArmRelated.TableRightAuto;
import frc.robot.Auto.ArmRelated.TiltUpAuto;
import frc.robot.Auto.ArmRelated.WinchExtendAuto;
import frc.robot.Auto.ArmRelated.WinchRetractAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class BackNFor extends SequentialCommandGroup {
  /** Creates a new BackNFor. */
  public BackNFor() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new LiftUpAuto(-75), 
    new TableRightAuto(-23), 
    new TiltUpAuto(),
    new WaitCommand(1), 
    new WinchExtendAuto(-65), //might be positive
    new WaitCommand(1),
    new GrippersOpenAuto(),
    new WaitCommand(1),
    new WinchRetractAuto(-40), //should be 0 or opposite +/- of extend
    new DriveAuto(0.37), 
    new WaitCommand(2),
    new DriveForAuto(0.195)

    );
  }
}
