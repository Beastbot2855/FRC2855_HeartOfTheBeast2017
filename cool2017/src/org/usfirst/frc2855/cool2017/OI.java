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

import org.usfirst.frc2855.cool2017.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc2855.cool2017.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


	public Joystick joystick1;
	public Joystick joystick2;
	
	public JoystickButton climbButton;
    
	public JoystickButton ballOut;
    public JoystickButton ballin;
    
    public JoystickButton shooterbutton;
    
    public JoystickButton gearout;
    public JoystickButton gearin;
    public JoystickButton gearpinch;
    public JoystickButton gearrelease;
    
    public JoystickButton ledflash;
    public JoystickButton ledbreathe;
    
    public OI() {
        
        joystick1 = new Joystick(0);
        joystick2 = new Joystick(1);
        
        
        /** 
         * Each JoystickButton definition has two versions: Competition and Demo. Both are extended from this class.
         * 
         * Competition mode is intended for one driver with two joysticks and controls spread between them (uses
         * 	an Attack 3 on the left and an Extreme 3D Pro on the right).
         * 
         * Demo mode is intended for two drivers with one Extreme 3D Pro joystick each. Drive is on joystick 1
         * 	while all other controls are on joystick 2. 
         * 
         * This is done because Sparky is tank drive and thus requires two joysticks for one driver. The Extreme
         * 	3D Pro joystick is right-handed only, making using two of them together difficult. Thus, we use an 
         *  Attack 3 and an Extreme 3D Pro for Sparky and two Extreme 3D Pros for the Heart of the Beast if 
         *  both are being run simultaneously.
         *  
         * To switch modes, change which OI is chosen in Robot.java
         */
        
        // runs gear autonomous
        SmartDashboard.putData("Run Auto", new AutoGearCommandGroup());
        // runs climber backwards
        SmartDashboard.putData("Reentry", new reentry());
        // resets gyroscope
        SmartDashboard.putData("Calibrate Gyro", new calibrateSpinnySensor());
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getJoystick1() {
        return joystick1;
    }
    public Joystick getJoystick2() {
        return joystick2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

