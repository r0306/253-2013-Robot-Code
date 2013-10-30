/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;

import Robot2013.RobotMain;
import Robot2013.RobotPorts;
import Util.RobotTimer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author MRT253
 */
public class LoaderController implements RobotPorts
{

    private Relay piston;
    private Relay loader;
    private DigitalInput limitSwitch;
    private boolean pistonReady;
    private boolean timerReady;
    private boolean loaderReady;
    public static final double PISTON_SPEED = 0.2;
    public static final double LOADER_SPEED = 0.2;
    public static final long PISTON_DELAY = 100L;
    public static final long PISTON_START_DELAY = 500L;
    public static final long TIMER_DELAY = 500L;
    public static final long LOADER_DURATION = 1000L;
    public static final long AUTONOMOUS_DELAY = 70L;
    
    public LoaderController()
    {

        piston = new Relay(RobotPorts.PISTON_PORT);        
        loader = new Relay(RobotPorts.LOADER_PORT);
        limitSwitch = new DigitalInput(RobotPorts.PISTON_SENSOR);
        pistonReady = true;
        timerReady = true;
        loaderReady = true;
        
    }
    
    public void enableTimer()
    {
        
        timerReady = true;
        
    }
    
    public void disableTimer()
    {
        
        timerReady = false;
        
    }
   
    public void enablePiston()
    {
        
        pistonReady = true;
        
    }
    
    public void disablePiston()
    {
        
        pistonReady = false;
        
    }
    
    public void enableLoader()
    {
        
        loaderReady = true;
        
    }
    
    public void disableLoader()
    {
        
        loaderReady = false;
        
    }
    
    public boolean loaderReady()
    {
        
        return loaderReady;
        
    }
    
    public boolean pistonReady()
    {
     
        return pistonReady;
        
    }
    
    public boolean timerReady()
    {
        
        return timerReady;
    
    }
    
    public void sensorCheck()
    {

        if (timerReady && !pistonReady && limitSwitch.get())
        {

            stopPiston();
            
        }
                 
    }
        
    public void runPiston()
    {
        
        if (pistonReady && timerReady)
        {

            disablePiston();
            disableTimer();
            piston.set(Relay.Value.kForward);
            RobotTimer.pistonTimer(TIMER_DELAY);
            RobotMain.getShooter().timeShooter();
        
        }
            
    }
    
    public void test()
    {

        piston.set(Relay.Value.kForward);
        
    }
        
    public void stopPiston()
    {

        enablePiston();
        piston.set(Relay.Value.kOff);
        
    }
   
    public void runLoader()
    {
        
       if (pistonReady)
       {

           disableLoader();
           loader.set(Relay.Value.kForward);
           RobotTimer.loaderDelayStop(LOADER_DURATION, PISTON_START_DELAY);
           RobotMain.getShooter().shooterOn();

       }
        
    }
    
    public void runAutonomousProcesses()
    {
        
        
        
    }
    
    public void runLoaderAutonomous()
    {
      
        disableLoader();
        disableTimer();
        loader.set(Relay.Value.kForward);
        RobotTimer.loaderDelayStop(LOADER_DURATION, PISTON_START_DELAY);
    
    }
    
    public void runPistonAutonomous()
    { 
        
        disablePiston();
        piston.set(Relay.Value.kForward);
        RobotTimer.pistonTimer(AUTONOMOUS_DELAY);
          
    }
    
    public boolean ready()
    {
        
        return pistonReady && timerReady;
        
    }
    
    public void startLoader()
    {
        
        loader.set(Relay.Value.kForward);
        
    }
    
    public void stopLoader()
    {

        loader.set(Relay.Value.kOff);
        
    }
    
    public boolean sensorPressed()
    {
        
        return limitSwitch.get();
        
    }

}

