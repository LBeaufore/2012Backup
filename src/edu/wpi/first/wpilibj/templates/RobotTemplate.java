/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import com.sun.squawk.util.MathUtils;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotTemplate extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    Joystick j1;
    Joystick j2;
    Joystick controller;
    Victor fLeft, fRight, bLeft, bRight;
    RobotDrive drive;


    public void robotInit()
    {
        j1 = new Joystick (1); // left
        j2 = new Joystick (2); // right
        controller = new Joystick (3);
        fLeft = new Victor(1);//switch
        fRight = new Victor(3);
        bLeft = new Victor (2);//switch
        bRight = new Victor (4);
        drive = new RobotDrive(fLeft, bLeft, fRight, bRight);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic()
    {

    }

    /**
     * This function is called periodically during operator control
     */
    //double magnitude, angle;
    public void teleopPeriodic()
    {
        //drive.mecanumDrive_Cartesian(deadzone(-j2.getX()), deadzone(-j1.getX()), deadzone(j2.getY()), 0);

        //controller one
        drive.mecanumDrive_Cartesian(deadzone(-j2.getX()), deadzone(-j1.getX()), deadzone(j2.getY()), 0);
        detectAxis();
        //API is wrong: actually X, ROT, Y, 0
        //drive.mecanumDrive_Cartesian(deadzone(j2.getX()), deadzone(j2.getY()), deadzone(j1.getX()), 0);

    }

    public double deadzone(double d)
    {
        if (Math.abs(d) < 0.10)
            return 0;
        //return d / Math.abs(d) * ((Math.abs(d) - 0.5) / .5);
        return d / Math.abs(d) * ((Math.abs(d) - .10) / .90);
    }
    public void detectAxis()
    {
        for(int i=0; i<=12; i++)
        {
            System.out.println(i + " : " + controller.getRawAxis(i));
        }
    }
}
