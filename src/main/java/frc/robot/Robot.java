// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

// import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorController;
import edu.wpi.first.wpilibj.motorcontrol.PWMVictorSPX;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;

/**
 * This is a demo program showing the use of the DifferentialDrive class,
 * specifically it contains
 * the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {
  private final XboxController xbox = new XboxController(0);
  private final MotorController m_leftMotor1 = new PWMVictorSPX(4);
  private final MotorController m_leftMotor2 = new PWMVictorSPX(5);
  private final MotorController m_leftMotor3 = new PWMVictorSPX(6);
  private final MotorController m_rightMotor1 = new PWMVictorSPX(7);
  private final MotorController m_rightMotor2 = new PWMVictorSPX(8);
  private final MotorController m_rightMotor3 = new PWMVictorSPX(9);

  private final MotorControllerGroup m_rightMotors = new MotorControllerGroup(m_rightMotor1, m_rightMotor2,
      m_rightMotor3);
  private final MotorControllerGroup m_leftMotors = new MotorControllerGroup(m_leftMotor1, m_leftMotor2, m_leftMotor3);
  private final DifferentialDrive m_myRobot = new DifferentialDrive(m_leftMotors, m_rightMotors);

  @Override
  public void robotInit() {
    // We need to invert one side of the drivetrain so that positive voltages
    // result in both sides moving forward. Depending on how your robot's
    // gearbox is constructed, you might have to invert the left side instead.
    // m_rightMotor1.setInverted(true);
    // m_rightMotor2.setInverted(true);
    // m_rightMotor3.setInverted(true);
    m_rightMotors.setInverted(true);
    m_leftMotors.setInverted(false);
    m_rightMotors.set(0.9);

    // m_leftStick = new Joystick(0);
    // m_rightStick = new Joystick(1);
  }

  @Override
  public void teleopPeriodic() {
    m_myRobot.tankDrive(xbox.getRightY(), xbox.getLeftY());
  }
}
