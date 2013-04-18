/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;

import Robot2013.RobotPorts;
import edu.wpi.first.wpilibj.Relay;

/**
 *
 * @author MRT253
 */
public class Lifter implements RobotPorts
{

    private Relay lifter;
    
    public Lifter()
    {
        
        lifter = new Relay(LIFTER_PORT);
        
    }
    
    public void liftUp()
    {
        
        lifter.set(Relay.Value.kForward);
        
    }
    
    public void liftDown()
    {
        
        lifter.set(Relay.Value.kReverse);
        
    }        
    
    public void stopLifter()
    {
        
        lifter.set(Relay.Value.kOff);
        
    }
      
    
}
