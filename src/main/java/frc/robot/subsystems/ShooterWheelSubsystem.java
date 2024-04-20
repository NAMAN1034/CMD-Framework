// This code is subject to the WPILib BSD license, which allows modification and sharing. 
// Refer to the license file in the root directory for details.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.controls.VelocityVoltage;
import com.ctre.phoenix6.controls.VoltageOut;
import com.ctre.phoenix6.hardware.TalonFX;

//import edu.wpi.first.wpilibj2.command.Command;
//import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
//import edu.wpi.first.wpilibj2.command.button.CommandXboxController;

public class ShooterWheelSubsystem extends SubsystemBase {
  /** Creates a new instance of ShooterWheelSubsystem. */
  private TalonFX shooter1;

  public ShooterWheelSubsystem() {
    shooter1 = new TalonFX(3);
    // Settings from TalonFX documentation
    // Set gains for slot 0 in the initialization function
    var slot0Configs = new Slot0Configs();
    slot0Configs.kS = 0.05; // Increase output by 0.05 V to overcome static friction
    slot0Configs.kV = 0.12; // Target velocity of 1 rps corresponds to 0.12 V output
    slot0Configs.kP = 0.11; // Error of 1 rps results in 0.11 V output
    slot0Configs.kI = 0; // No output for integrated error
    slot0Configs.kD = 0; // No output for error derivative

    shooter1.getConfigurator().apply(slot0Configs);
  }

  public TalonFX getShooter(){
    return shooter1;
  }

  public void stopShooter(){
    shooter1.stopMotor();
  }

  public void setShooterVelocity(double rps){
    shooter1.setControl(new VelocityVoltage(rps * 0.6));
  }

  @Override
  public void periodic() {
    // This method is called once per scheduler run
  }

  @Override
  public void simulationPeriodic() {
    // This method is called once per scheduler run during simulation
  }
}
