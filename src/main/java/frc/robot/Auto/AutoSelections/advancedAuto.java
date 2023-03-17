// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.Auto.AutoSelections;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.Auto.DriveAuto;
import frc.robot.Auto.ExtendAuto;
import frc.robot.Auto.GrippersAuto;
import frc.robot.Auto.LiftAuto;
import frc.robot.Auto.RetractAuto;
import frc.robot.Auto.TableAuto;
import frc.robot.Auto.TiltAuto;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class advancedAuto extends SequentialCommandGroup {
  /** Creates a new advancedAuto. */
  public advancedAuto() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
    new TableAuto(27), 
    new LiftAuto(80), 
    new ExtendAuto(25), 
    new TiltAuto(), 
    new GrippersAuto(),
    new RetractAuto(3),
    new DriveAuto(60)
    );
  }
}