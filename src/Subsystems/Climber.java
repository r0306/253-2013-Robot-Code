/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;

import Robot2013.RobotPorts;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author MRT253
 */
public class Climber implements RobotPorts
{

    private Victor winch;
    public final double WINCH_SPEED = 0.65;
    
    public Climber()
    {
        
        winch = new Victor(WINCH_PORT);
        
    }
    
    public void climb()
    {
        
        winch.set(-WINCH_SPEED);
        
    }
    
    public void release()
    {
        
        winch.set(WINCH_SPEED);
        
    }
    
    public void stop()
    {
        
        winch.set(0.0);
        
    }
    
}
