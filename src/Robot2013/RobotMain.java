/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package Robot2013;


import Subsystems.Climber;
import Subsystems.Lifter;
import Subsystems.LoaderController;
import Subsystems.Shooter;
import Util.RobotTimer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the SimpleRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot implements RobotPorts
{

    public static RobotDrive driveTrain;
    public static Joystick leftStick;
    
    private Joystick rightStick;
    private static LoaderController loader;
    
    private static Shooter shooter;
    
    private static Lifter lifter;
    
    private static Climber climber;
    
    public static final long LOADER_DELAY = 500;
    
    public void robotInit()
    {

        driveTrain = new RobotDrive(MOTOR_FRONT_LEFT, MOTOR_REAR_LEFT, MOTOR_FRONT_RIGHT, MOTOR_REAR_RIGHT);
        
       // getWatchdog().setEnabled(true);
       // getWatchdog().setExpiration(0.1);
       
        loader = new LoaderController();
        shooter = new Shooter();
        lifter = new Lifter();
        climber = new Climber();
        
        leftStick = new Joystick(LEFT_STICK);
        rightStick = new Joystick(RIGHT_STICK);
  
        driveTrain.setSafetyEnabled(false);

    }

    /**
     * This function is called once each time the robot enters autonomous mode.
     */
    public void autonomousPeriodic()
    {
        
    }

    /**
     * This function is called once each time the robot enters operator control.
     */
    public void teleopPeriodic()
    {
        
    //    getWatchdog().feed();
       //driveTrain.arcadeDrive(leftStick);
        driveTrain.arcadeDrive(leftStick.getY() / 1.0, leftStick.getX() / 1.0, true);
        checkLoader();
        manualShoot();
        getLoader().sensorCheck();
        checkLifter();
        manualLoad();
        checkClimber();
    
    }
    
    public void buttonCheck()
    {
        
        
    }
    
    public void checkLoader()
    {
        
        if (leftStick.getRawButton(1))
        {

           getLoader().runLoader();
                  
        }
        
    }
    
    public void manualLoad()
    {
        
        if (leftStick.getRawButton(4))
        {
            
            getLoader().startLoader();
            
        }
        
        else if (getLoader().loaderReady())
        {
            
            getLoader().stopLoader();
            
        }
        
    }
    
    public void manualShoot()
    {
        
        if (leftStick.getRawButton(5))
        {
            
            if (getLoader().ready())
            {
            
                getShooter().shooterOn();
                RobotTimer.delayLoad(LOADER_DELAY);
            
            }
                
        }
        
    }
    
    public void checkClimber()
    {
        
        if (leftStick.getRawButton(8))
        {
            
            climber.climb();
            
        }
        
        else if (leftStick.getRawButton(9))
        {
            
            climber.release();
            
        }
        
        else
        {
            
            climber.stop();
            
        }
        
    }
    
    
    public void checkLifter()
    {
        
        if (leftStick.getRawButton(3))
        {
            
            getLifter().liftDown();
            
        }
        
        else if (leftStick.getRawButton(2))
        {
            
            getLifter().liftUp();
            
        }
        
        else
        {
            
            getLifter().stopLifter();
            
        }
        
    }
   
    public static LoaderController getLoader()
    {

        return loader;
        
    }
    
    public static Climber getClimber()
    {
        
        return climber;
        
    }
    
    public static Shooter getShooter()
    {
        
        return shooter;
        
    }
    
    public static Lifter getLifter()
    {
        
        return lifter;
        
    }       
     
          
    /**
     * This function is called once each time the robot enters test mode.
     */
    public void testPeriodic()
    {
        
    }

}
