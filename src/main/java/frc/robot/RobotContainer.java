// This code is subject to the WPILib BSD license, which allows modification and sharing.
// Refer to the license file in the root directory for details.

package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ShooterWheelSpinner;
import frc.robot.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final ShooterWheelSubsystem m_shooterSubsystem = new ShooterWheelSubsystem();

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    configureBindings();
  }

  public CommandXboxController getDriverController() {
    return m_driverController;
  }

  /**
   * Use this method to define your trigger->command mappings.
   */
  private void configureBindings() {
    // Spin shooter wheel when X button is pressed, stop when released
    new Trigger(m_driverController.x())
        .whenActive(new ShooterWheelSpinner(m_shooterSubsystem, 20))
        .whenInactive(new ShooterWheelSpinner(m_shooterSubsystem, 0));

    // Example of mapping a command to a button
    // m_driverController.b().whileHeld(new ExampleCommand(m_shooterSubsystem));
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    return Autonomous.exampleAutonomous(m_shooterSubsystem);
  }
}
