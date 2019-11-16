package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import java.text.SimpleDateFormat;

public class Robot extends TimedRobot {

    private WPI_VictorSPX m_FrontLeft;
    private WPI_VictorSPX m_FrontRight;
    private WPI_VictorSPX m_BackLeft;
    private WPI_VictorSPX m_BackRight;

    private DifferentialDrive m_Drivetrain;

    private Joystick m_Joystick;

    private StringBuilder statisticsBuilding = new StringBuilder();
    private int statisticLooperCounter = 0;
    private SimpleDateFormat sDF = new SimpleDateFormat("MM/dd/yy HH:mm:ss");

    @Override
    public void robotInit() {

        m_FrontLeft = new WPI_VictorSPX(0);
        m_FrontRight = new WPI_VictorSPX(1);
        m_BackLeft = new WPI_VictorSPX(2);
        m_BackRight = new WPI_VictorSPX(3);

        m_Drivetrain = new DifferentialDrive(m_FrontLeft, m_FrontRight);

        m_Joystick = new Joystick(0);

    }
}
