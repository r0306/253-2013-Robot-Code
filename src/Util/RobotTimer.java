/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import Robot2013.RobotMain;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author MRT253
 */
public class RobotTimer
{
    static Timer autotimer = new Timer();
    public static void timeLoader()
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {
              
                       RobotMain.getLoader().disablePiston();
          
                    }
       
        }, 10L);
        
    }
    
    public static void loaderDelayStop(long delay, final long delayPiston)
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {

                         RobotMain.getLoader().stopLoader();
                         RobotMain.getLoader().enableLoader();
                         RobotTimer.pistonDelayStart(delayPiston);
                            
                    }
       
        }, delay);
        
    }
    
    public static void pistonDelayStart(final long delay)
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {

                         RobotMain.getLoader().runPiston();
                            
                    }
       
        }, delay);
        
    }
    
    public static void shooterDelayStop(long delay)
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {

                         RobotMain.getShooter().shooterOff();
                            
                    }
       
        }, delay);
        
    }
    
    public static void delayLoad(long delay)
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {

                         RobotMain.getLoader().runPiston();
                            
                    }
       
        }, delay);
        
    }
    
    public static void pistonTimer(long delay)
    {
        
        Timer timer = new Timer();

        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {
                    
                        RobotMain.getLoader().enableTimer();
                    
                    }
        }, delay);
       
    }
     public static void autonomousDelayLoad(long delay) 
     {
      
        Timer timer = new Timer();
        
        autotimer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {
                       
                        RobotMain.getLoader().runLoaderAutonomous();
                        RobotMain.getLoader().enableLoader();
                    
                    }
        
        }, delay);
         
     }
   
     public static void autonomousPistonDelay(long delay) 
     {
      
        Timer timer = new Timer();
        
        timer.schedule(new TimerTask()
        {          
   
                    public void run()
                    {

                         RobotMain.getLoader().stopLoader();
                         RobotMain.getLoader().runPistonAutonomous();
                         RobotMain.getLoader().enablePiston();
                         
                    }
        
        }, delay);
         
     }

    public RobotTimer() {
    }
    

} 
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               