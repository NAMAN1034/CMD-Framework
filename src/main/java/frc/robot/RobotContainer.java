package frc.robot;

import frc.robot.Constants.OperatorConstants;
import frc.robot.commands.Autonomous;
import frc.robot.commands.ShooterWheelSpinner;
import frc.robot.subsystems.ShooterWheelSubsystem;
import edu.wpi.first.wpilibj2.command.button.CommandXboxController;
import edu.wpi.first.wpilibj2.command.button.Trigger;

public class RobotContainer {
  private final CommandXboxController m_driverController = new CommandXboxController(OperatorConstants.kDriverControllerPort);
  private final ShooterWheelSubsystem m_shooterSubsystem = new ShooterWheelSubsystem();

  public RobotContainer() {
    configureBindings();
  }

  public CommandXboxController getDriverController() {
    return m_driverController;
  }

  private void configureBindings() {
    new Trigger(m_driverController.x())
        .whileTrue(new ShooterWheelSpinner(m_shooterSubsystem, 20));
  }

  public Command getAutonomousCommand() {
    return Autonomous.exampleAuto(m_shooterSubsystem);
  }
}
