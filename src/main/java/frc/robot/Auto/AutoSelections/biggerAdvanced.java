// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.AutoSelections;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.Auto.DriveAuto;
import frc.robot.Auto.ArmRelated.TableRightAuto;
import frc.robot.Auto.ArmRelated.TiltDownAuto;
import frc.robot.Auto.ArmRelated.WinchExtendAuto;
import frc.robot.Auto.ArmRelated.GrippersCloseAuto;
import frc.robot.Auto.ArmRelated.GrippersOpenAuto;
import frc.robot.Auto.ArmRelated.LiftDownAuto;
import frc.robot.Auto.ArmRelated.LiftUpAuto;
import frc.robot.Auto.ArmRelated.WinchRetractAuto;
import frc.robot.Auto.ArmRelated.TiltUpAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class biggerAdvanced extends SequentialCommandGroup {
  /** Creates a new advancedAuto. */
  public biggerAdvanced() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new LiftUpAuto(-35), 
    new TableRightAuto(-45), 
    new TiltUpAuto(), 
    new WaitCommand(1),
    new WinchExtendAuto(80.5), //might be positive
    new WaitCommand(1),
    new LiftDownAuto(-30),
    new WaitCommand(1),
    new GrippersOpenAuto(),
    new WaitCommand(1),
    new TiltDownAuto(),
    new WaitCommand(1),
    new WinchRetractAuto(37),
    new DriveAuto(0.4)
    );
  }
}
