// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc2855.cool2017;

import org.usfirst.frc2855.cool2017.SPIGyro.ADXRS453Gyro;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import com.ctre.CANTalon.FeedbackDevice;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;


/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static SpeedController ballintakeintaketalon;
    
    public static CANTalon MakesMarksOnLowCeilings;
    
    public static CANTalon driveleftreartalon;
    public static CANTalon driveleftreartalon2;
    public static CANTalon driveleftfronttalon;
    public static CANTalon driverightfronttalon;
    public static CANTalon driverightreartalon;
    public static CANTalon driverightreartalon2;
    public static SixMotorDrive driveRobotDrive41;
    
    public static SpeedController flightenabler;
    
    public static SpeedController FischerAnnoyer;
    
    public static CameraServer camera;
    
    public static DoubleSolenoid gearInOutSolenoid;
    public static DoubleSolenoid gearPinchSolenoid;
    
    public static ADXRS453Gyro SpinnySensor;
    
    public static DigitalOutput ledmarker;
    public static DigitalOutput ledintake;
    public static DigitalOutput ledflash;
    public static DigitalOutput ledbreathe;
    
    // read WPILIB documentation on LiveWindow to understand it (it is for Driver Station test mode)
    public static void init() {
    	
    	// starts cameras
    	CameraServer.getInstance().startAutomaticCapture();
    	
    	// tells the RoboRIO that the FischerAnnoyer is controlled by a Talon SR on PWM 4
        FischerAnnoyer = new Talon(4);
        LiveWindow.addActuator("agitator", "agitator", (Talon) FischerAnnoyer);
        
        // sets intake Talon SR to PWM port 5
        ballintakeintaketalon = new Talon(5);
        LiveWindow.addActuator("ball intake", "intake talon", (Talon) ballintakeintaketalon);
        
        
        // tells the RoboRIO that to make a mark on the ceiling, it needs to contact the Talon SRX with ID 7
        MakesMarksOnLowCeilings = new CANTalon(7);
        LiveWindow.addActuator("shooter", "shooter talon", MakesMarksOnLowCeilings);
        
        
        // sets drivetrain Talon SRX for back left MiniCIM furthest from intake to Talon SRX at CAN ID 4
        driveleftreartalon = new CANTalon(4);
        LiveWindow.addActuator("drive", "left rear talon", driveleftreartalon);
        
        // sets drivetrain Talon SRX for back left MiniCIM closest to intake to Talon SRX at CAN ID 1
        // sets Talon SRX at CAN ID 1 to follower mode
        driveleftreartalon2 = new CANTalon(1);
        driveleftreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "left rear talon2", driveleftreartalon2);
        
        // sets drivetrain Talon SRX for front left CIM to Talon SRX at CAN ID 5
        driveleftfronttalon = new CANTalon(5);
        LiveWindow.addActuator("drive", "left front talon", driveleftfronttalon);
        
        // sets drivetrain Talon SRX for front right CIM to Talon SRX at CAN ID 8
        driverightfronttalon = new CANTalon(8);
        LiveWindow.addActuator("drive", "right front talon", driverightfronttalon);
        
        // sets drivetrain Talon SRX for back right MiniCIM furthest from intake to Talon SRX at CAN ID 6
        driverightreartalon = new CANTalon(6);
        LiveWindow.addActuator("drive", "right rear talon", driverightreartalon);
       
        // sets drivetrain Talon SRX for back right MiniCIM closest to intake to Talon SRX at CAN ID 3
        // sets Talon SRX at CAN ID 3 to follower mode
        driverightreartalon2 = new CANTalon(3);
        driverightreartalon2.setControlMode(CANTalon.TalonControlMode.Follower.getValue());
        LiveWindow.addActuator("drive", "right rear talon2", driverightreartalon2);
        
        
        
        // creates drivetrain object and passes all motor controllers to object
        driveRobotDrive41 = new SixMotorDrive(driveleftfronttalon, driveleftreartalon,
              driverightfronttalon, driverightreartalon, driveleftreartalon2, driverightreartalon2);
        
        // sets if motor safety is on or off (recommend on)
        driveRobotDrive41.setSafetyEnabled(false);
        // sets timeout before motor safety decides that drive motors need to be stopped because drivetrain object stopped sending a signal
        driveRobotDrive41.setExpiration(0.5);
        // sets sensitivity for something (not sure what)
        driveRobotDrive41.setSensitivity(0.5);
        // sets maximum output percentage for non-PercentvBus modes
        driveRobotDrive41.setMaxOutput(1.0);

        // inverts direction of front motors because we are using Mecanum
        driveRobotDrive41.setInvertedMotor(SixMotorDrive.MotorType.kFrontRight, true);
        driveRobotDrive41.setInvertedMotor(SixMotorDrive.MotorType.kFrontLeft, true);
        
        // sets flight Talon SR to PWM 6 
        flightenabler = new Talon(6);
        LiveWindow.addActuator("climbing arm", "climbing motor", (Talon) flightenabler);
        
        // sets gear arm solenoid to ports 0 and 1 on PCM 0
        gearInOutSolenoid = new DoubleSolenoid(0, 0, 1);
        LiveWindow.addActuator("Gear In Out Solenoid", "Gear Arm Double Solenoid", gearInOutSolenoid);
        
        // sets gear solenoid to ports 2 and 3 on PCM 0
        gearPinchSolenoid = new DoubleSolenoid(0, 2, 3);
        LiveWindow.addActuator("Gear Pinch", "Gear Pinch Double Solenoid", gearPinchSolenoid);
        
        // sets the type of the sensor that is plugged into the MakesMarksOnLowCeilings Talon SRX 
        MakesMarksOnLowCeilings.setFeedbackDevice(FeedbackDevice.CtreMagEncoder_Relative);
        // sets if the sensor is running in reverse (not sure exactly how to explain it)
        MakesMarksOnLowCeilings.reverseSensor(false);
        // sets minimum output voltage for each direction when in closed-loop modes
        MakesMarksOnLowCeilings.configNominalOutputVoltage(+0.0f, -0.0f);
        // sets maximum output voltage for each direction when in closed-loop modes and only allows it to run forwards
        MakesMarksOnLowCeilings.configPeakOutputVoltage(+12.0f, -0.0f);
        // sets which set of values to use from preset 'profiles' that are set in the Web Dashboard (there are two profiles, 0 & 1)
        MakesMarksOnLowCeilings.setProfile(0);
        
        
        // creates new SpinnySensor object
        SpinnySensor = new ADXRS453Gyro();

        // creates new DIO output object for DIO 1
        ledmarker = new DigitalOutput(1);
        LiveWindow.addActuator("LED Shooter", "LED Shooter", ledmarker);
        
        // creates new DIO output object for DIO 2
        ledintake = new DigitalOutput(2);
        LiveWindow.addActuator("LED Intake", "LED Intake", ledintake);
        
        // creates new DIO output object for DIO 3
        ledflash = new DigitalOutput(3);
        LiveWindow.addActuator("LED Flash", "LED Flash", ledflash);
        
        // creates new DIO output object for DIO 4
        ledbreathe = new DigitalOutput(4);
        LiveWindow.addActuator("LED Breathe", "LED Breathe", ledbreathe);
        
    }
}
