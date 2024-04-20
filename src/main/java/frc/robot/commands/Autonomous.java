// This code is subject to the WPILib BSD license, which allows modification and sharing.
// Refer to the license file in the root directory for details.

package frc.robot.commands;

import frc.robot.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;

public final class Autonomous {
  /** Static factory method for an example autonomous command. */
  public static Command exampleAuto(ShooterWheelSubsystem subsystem) {
    return Commands.sequence(
      new ShooterWheelSpinner(subsystem, 20).withTimeout(5.0),
      Commands.waitSeconds(5.0),
      new ShooterWheelSpinner(subsystem, 20).withTimeout(5.0)
    );
  }

  private Autonomous() {
    throw new UnsupportedOperationException("This is a utility class!");
  }
}
