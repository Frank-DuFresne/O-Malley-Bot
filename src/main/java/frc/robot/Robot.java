package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_VictorSPX;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Instant;

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

        public StringBuilder yeet = new StringBuilder();

        m_FrontLeft = new WPI_VictorSPX(0);
        m_FrontRight = new WPI_VictorSPX(1);
        m_BackLeft = new WPI_VictorSPX(2);
        m_BackRight = new WPI_VictorSPX(3);

        m_Drivetrain = new DifferentialDrive(m_FrontLeft, m_FrontRight);

        m_Joystick = new Joystick(0);

        m_FrontLeft.configFactoryDefault();
        m_FrontRight.configFactoryDefault();
        m_BackLeft.configFactoryDefault();
        m_BackRight.configFactoryDefault();

        m_BackLeft.follow(m_FrontLeft);
        m_BackRight.follow(m_FrontRight);

        Shuffleboard.getTab("Drivetrain").add(m_Drivetrain);

        File elif = new File(Robot.class.getProtectionDomain().getCodeSource().getLocation().getPath());
        yeet.append("Code Last Deployed: ").append(sDF.format(elif.lastModified()));

        yeet.append("\n----------\nFront Left Drivetrain Firmware Version: ").append(m_FrontLeft.getFirmwareVersion());
        yeet.append("\nFront Right Drivetrain Firmware Version: ").append(m_FrontRight.getFirmwareVersion());
        yeet.append("\nBack Left Drivetrain Firmware Version: ").append(m_BackLeft.getFirmwareVersion());
        yeet.append("\nBack Right Drivetrain Firmware Version: ").append(m_BackRight.getFirmwareVersion());
        yeet.append("\n----------\n");
        System.out.println(yeet);
        yeet.setLength(0);
    }

    @Override
    public void autonomousPeriodic() {
        teleopPeriodic();
    }

    @Override
    public void teleopPeriodic() {
        m_Drivetrain.arcadeDrive(-m_Joystick.getY(),m_Joystick.getX());

        statisticLooperCounter++;
        if (statisticLooperCounter >= 9) {
            statisticPrinting();
            statisticLooperCounter = 0;
        }
    }

    public void statisticPrinting() {
        statisticsBuilding.append("----------");
        statisticsBuilding.append("\nTimestamp: ").append(sDF.format(Instant.now().getEpochSecond()));
        statisticsBuilding.append("\nFront Left Motor Power Level: ").append(m_FrontLeft.get());
        statisticsBuilding.append("\nFront Right Motor Power Level: ").append(m_FrontRight.get());
        statisticsBuilding.append("\nBack Left Motor Power Level: ").append(m_BackLeft.get());
        statisticsBuilding.append("\nBack Right Motor Power Level: ").append(m_BackRight.get());
        statisticsBuilding.append("----------");
        System.out.println(statisticsBuilding);
        statisticsBuilding.setLength(0);
    }
}
