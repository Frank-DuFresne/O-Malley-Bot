package frc.robot;

import com.revrobotics.CANSparkMax;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import java.text.SimpleDateFormat;

public class Robot extends TimedRobot {

    private CANSparkMax m_FrontLeft;
    private CANSparkMax m_FrontRight;
    private CANSparkMax m_BackLeft;
    private CANSparkMax m_BackRight;

    private SpeedControllerGroup m_LeftPair;
    private SpeedControllerGroup m_RightPair;
    private DifferentialDrive m_Drivetrain;

    private Joystick m_Joystick;

    private StringBuilder statisticsBuilding = new StringBuilder();
    private int statisticLooperCounter = 0;
    private SimpleDateFormat sDF = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    @Override
    public void robotInit() {
        
    }
}
