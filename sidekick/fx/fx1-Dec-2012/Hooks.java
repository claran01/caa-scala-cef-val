package appfx01;

import java.awt.BorderLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

//x public class Hooks extends JFrame implements  NativeKeyListener, 
//x                                               NativeMouseInputListener, 
//x                                               NativeMouseWheelListener, 
//x                                               WindowListener 
public class Hooks implements  NativeKeyListener, 
                                              NativeMouseInputListener, 
                                              NativeMouseWheelListener
{
	private static final long serialVersionUID = 1865350670081087993L;

    private boolean isFinalized = false;
    
    private int m_width = 0;
    private int m_height = 0;
    
	public Hooks() 
    {
//x 		setTitle("JNativeHook Demo");
//x 		setLayout(new BorderLayout());
//x 		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
//x 		setSize(600, 300);
//x 		addWindowListener(this);

        GlobalScreen.getInstance().addNativeKeyListener(this);
        GlobalScreen.getInstance().addNativeMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
        GlobalScreen.getInstance().addNativeMouseWheelListener(this);
                
//x 		setVisible(true);
		
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
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println(e.paramString());
                
                if(e instanceof NativeMouseEvent)
                {
                	Point p = ((NativeMouseEvent) e).getPoint();
                	
                	System.out.println(p.x + " || " + p.y);
                }
            }
        });

	}

//x 	public void windowActivated(WindowEvent e) { /* Do Nothing */ }
//x 	public void windowClosing(WindowEvent e) { /* Do Nothing */ }
//x 	public void windowDeactivated(WindowEvent e) { /* Do Nothing */ }
//x 	public void windowDeiconified(WindowEvent e) { /* Do Nothing */ }
//x 	public void windowIconified(WindowEvent e) { /* Do Nothing */ }
    
//x 	public void windowOpened(WindowEvent e) {
//x 		//Return the focus to the window.
//x //x 		this.requestFocusInWindow();
//x 
//x 		try {
//x //x 			System.out.println("Auto Repeat Rate: " + System.getProperty("jnativehook.autoRepeatRate"));
//x //x 			System.out.println("\n" + "Auto Repeat Delay: " + System.getProperty("jnativehook.autoRepeatDelay"));
//x //x 			System.out.println("\n" + "Double Click Time: " + System.getProperty("jnativehook.multiClickInterval"));
//x //x 			System.out.println("\n" + "Pointer Sensitivity: " + System.getProperty("jnativehook.pointerSensitivity"));
//x //x 			System.out.println("\n" + "Pointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointerAccelerationMultiplier"));
//x //x 			System.out.println("\n" + "Pointer Acceleration Threshold: " + System.getProperty("jnativehook.pointerAccelerationThreshold"));
//x 
//x 			GlobalScreen.registerNativeHook();
//x 		}
//x 		catch (NativeHookException ex) {
//x 			System.out.println("\n" + "Error: " + ex.toString());
//x 		}
//x 	}
    
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
    
//x 	public void windowClosed(WindowEvent e) {
//x         finalize();
//x 	}
//x 
//x 	public static void main(String[] args) {
//x 		
//x 		SwingUtilities.invokeLater(new Runnable() {
//x 			public void run() {
//x 				new Hooks();
//x 			}
//x 		});
//x 	}
}
