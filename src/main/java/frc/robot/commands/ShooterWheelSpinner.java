// This code is subject to the WPILib BSD license, which allows modification and sharing.
// Refer to the license file in the root directory for details.

package frc.robot.commands;

import frc.robot.subsystems.ShooterWheelSubsystem;

//import com.ctre.phoenix6.controls.VelocityVoltage;

//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.Command;

/** A command to spin the shooter wheel subsystem at a specified rate. */
public class ShooterWheelSpinner extends Command {
  @SuppressWarnings({"PMD.UnusedPrivateField", "PMD.SingularField"})
  private final ShooterWheelSubsystem m_subsystem;

  //private double timerLength;
  //private Timer timer;

  private double rps;
  /**
   * Creates a new ShooterWheelSpinner command.
   *
   * @param subsystem The subsystem used by this command.
   * @param rps The desired revolutions per second for the shooter wheel.
   */
  public ShooterWheelSpinner(ShooterWheelSubsystem subsystem, double rps) {
    addRequirements(subsystem);

    m_subsystem = subsystem;
    //timer = new Timer();
    //timerLength = seconds;
    this.rps = rps;
    // Use addRequirements() here to declare subsystem dependencies.
    
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    m_subsystem.setShooterVelocity(rps);
    //timer.restart();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    m_subsystem.stopShooter();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
