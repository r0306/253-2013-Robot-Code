/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import edu.wpi.first.wpilibj.Joystick;
import java.util.Hashtable;

/**
 *
 * @author MRT253
 */
public class JoyStickController
{

    public static class EventHandler
    {

        public void buttonDown()
        {

        }

        public void buttonUp()
        {

        }

        public void buttonHeld()
        {

        }
    
    }

    public static final int BTN_1 = 1;
    public static final int BTN_2 = 2;
    public static final int BTN_3 = 3;
    public static final int BTN_4 = 4;
    public static final int BTN_5 = 5;
    public static final int BTN_6 = 6;
    public static final int BTN_7 = 7;
    public static final int BTN_8 = 8;
    public static final int BTN_9 = 9;

    private Hashtable m_lastButtonStatus = new Hashtable();
    private Hashtable m_thisButtonStatus = new Hashtable();
    private Hashtable m_handlers = new Hashtable();

    public Joystick joystick;

    public JoyStickController(Joystick j)
    {
        
        joystick = j;
        EventHandler placeholder = new EventHandler();
        
        for (int i = 1; i <= 10; i++)
        {
        
            m_thisButtonStatus.put(new Integer(i), new Boolean(getButton(i)));
            m_handlers.put(new Integer(i), placeholder);

        }
    
        tick();
    
    }
    
    public double getTrigger()
    {

        return joystick.getRawAxis(3);
    
    }

    public void addButtonHandler(int button, EventHandler handler) 
    {
    
        m_handlers.put(new Integer(button), handler);
    
    }

    public void tick()
    {

        for (int i = 1; i <= 10; i++)
        {

            boolean lastStatus = ((Boolean) m_thisButtonStatus.get(new Integer(i))).booleanValue();
            boolean thisStatus = getButton(i);
            m_lastButtonStatus.put(new Integer(i), new Boolean(lastStatus));
            m_thisButtonStatus.put(new Integer(i), new Boolean(thisStatus));
    
            if (thisStatus)
                ((EventHandler) m_handlers.get(new Integer(i))).buttonHeld();
            if (lastStatus && !thisStatus)
                ((EventHandler) m_handlers.get(new Integer(i))).buttonUp();
            if (!lastStatus && thisStatus)
                ((EventHandler) m_handlers.get(new Integer(i))).buttonDown();

        }

    }

    public Point getStick()
    {

        Point p = new Point(joystick.getRawAxis(1), joystick.getRawAxis(2));
        p.y *= -1;

        return p;
    
    }

    public boolean getButton(int button)
    {

        return joystick.getRawButton(button);
    
    }

}