/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Subsystems;

import Robot2013.RobotPorts;
import Util.RobotTimer;
import edu.wpi.first.wpilibj.Victor;

/**
 *
 * @author MRT253
 */
public class Shooter implements RobotPorts
{

    private Victor frontShooter;
    private Victor rearShooter;
    public static final double FRONT_MOTOR_SPEED = 0.85;
    public static final double REAR_MOTOR_SPEED = 0.70;
    public static final long SHOOTER_DELAY = 500L;
    
    public Shooter()
    {
        
        frontShooter = new Victor(RobotPorts.SHOOTER_ONE);
        rearShooter = new Victor(RobotPorts.SHOOTER_TWO);
        
    }
    
    public void timeShooter()
    {
        
        RobotTimer.shooterDelayStop(SHOOTER_DELAY);
        
    }
    
    public void shooterOn()
    {
        
        frontShooter.set(FRONT_MOTOR_SPEED);
        rearShooter.set(REAR_MOTOR_SPEED);
        
    }
    
    public void shooterOff()
    {
        
        frontShooter.set(0.0);
        rearShooter.set(0.0);
        
    }
    
}
