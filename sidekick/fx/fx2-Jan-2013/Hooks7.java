package appfx01;

import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;

import javafx.application.Platform;

import javax.swing.SwingUtilities;

import java.awt.Dimension;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

public class Hooks7 implements  NativeKeyListener, 
                                NativeMouseInputListener, 
                                NativeMouseWheelListener
{
	private static final long serialVersionUID = 1865350670081087993L;

    private boolean isFinalized = false;
    private boolean m_isTriggerZone = false;
    
    private int m_width = 0;
    private int m_triggerX = 0;
    private int m_height = 0;
    
    private Dimension m_dimension = null;
    
    private IHooksCallback m_hooksCallback;
    
	public Hooks7(IHooksCallback i_hooksCallback) 
    {
		m_hooksCallback = i_hooksCallback;
		
        GlobalScreen.getInstance().addNativeKeyListener(this);
        GlobalScreen.getInstance().addNativeMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
        GlobalScreen.getInstance().addNativeMouseWheelListener(this);
                
		readScreenSizes();
	}
    
	private void readScreenSizes()
	{
		GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
		
		GraphicsDevice[] devices = env.getScreenDevices();
		    // REMIND : Multi-monitor full-screen mode not yet supported
//	    for (int i = 0; i < 1 /* devices.length */; i++) {
		for (int i = 0; i < 1 /* devices.length */; i++) {
	        System.out.println("Width "+devices[i].getDisplayMode().getWidth());
	        System.out.println("Height "+devices[i].getDisplayMode().getHeight());
	    }		
        
        m_width  = devices[0].getDisplayMode().getWidth();
        m_height = devices[0].getDisplayMode().getHeight();
        
        m_triggerX = m_width - 1;
        
        m_dimension = new Dimension(m_width, m_height);
	}
    
//+     public int getHeight() { return m_height; }
//+     public int getWidth() { return m_width; }
    
    public Dimension getScreenDimension()
    {
        return m_dimension;
    }
    
	///////////////////////////////////////////////////////////////////////////
	//

	public void nativeKeyPressed(NativeKeyEvent e) { displayEventInfo(e); }
	public void nativeKeyReleased(NativeKeyEvent e) { displayEventInfo(e); }
	public void nativeKeyTyped(NativeKeyEvent e) { displayEventInfo(e); }
	public void nativeMouseClicked(NativeMouseEvent e) { displayEventInfo(e); }
	public void nativeMousePressed(NativeMouseEvent e) { displayEventInfo(e); }
	public void nativeMouseReleased(NativeMouseEvent e) { displayEventInfo(e); }
	public void nativeMouseMoved(NativeMouseEvent e) { displayEventInfo(e); }
	public void nativeMouseDragged(NativeMouseEvent e) { displayEventInfo(e); }
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) { displayEventInfo(e); }
    
   
	private void displayEventInfo(final NativeInputEvent e) {
		/* Note: JNativeHook does *NOT* operate on the event dispatch thread.
		 * Because Swing components must be accessed on the event dispatching
		 * thread, you *MUST* wrap access to Swing components using the
		 * SwingUtilities.invokeLater() or EventQueue.invokeLater() methods.
		 */
        if(e instanceof NativeMouseEvent)
        {
            final Point p = ((NativeMouseEvent) e).getPoint();

            if(p.x >= m_triggerX) 
            {
                if(m_isTriggerZone == false)
                {
                    m_isTriggerZone = true;
                
//x                    SwingUtilities.invokeLater(new Runnable() {
                    Platform.runLater(new Runnable() {
                    	
                        public void run() {
                            System.out.println(e.paramString());
//x                         System.out.println("T" + p.x + " || " + p.y);
                            
                            if(m_hooksCallback != null)
                            {
                            	m_hooksCallback.callback(true);
                            }
                        }
                    });
                }
            }
            else
            {
                if(m_isTriggerZone == true)
                {
//x                    System.out.println("F" + p.x + " || " + p.y);
                    
                    if(m_hooksCallback != null)
                    {
                        m_hooksCallback.callback(false);
                    }
                    
                }
                m_isTriggerZone = false;
            }
        }
	}

    
    public void finalize()
    {
        System.out.println("fffffffff");
        
        if(isFinalized == false)
        {
            System.out.println("Finialize");
        
            isFinalized = true;
        
            //Clean up the native hook.
            GlobalScreen.unregisterNativeHook();
            System.runFinalization();
            System.exit(0);
        }
     }
}
