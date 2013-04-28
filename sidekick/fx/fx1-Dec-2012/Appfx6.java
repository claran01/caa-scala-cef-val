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

public class Appfx6 extends JFrame implements NativeKeyListener, 
                                              NativeMouseInputListener, 
                                              NativeMouseWheelListener, 
                                              WindowListener 
{
	private static final long serialVersionUID = 1865350670081087993L;

    private boolean isFinalized = false;
    
    private int m_width = 0;
    private int m_height = 0;
    
	public Appfx6() 
    {
		setTitle("JNativeHook Demo");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		addWindowListener(this);

        GlobalScreen.getInstance().addNativeKeyListener(this);
        GlobalScreen.getInstance().addNativeMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
        GlobalScreen.getInstance().addNativeMouseWheelListener(this);
                
		setVisible(true);
		
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

	public void windowActivated(WindowEvent e) { /* Do Nothing */ }
	public void windowClosing(WindowEvent e) { /* Do Nothing */ }
	public void windowDeactivated(WindowEvent e) { /* Do Nothing */ }
	public void windowDeiconified(WindowEvent e) { /* Do Nothing */ }
	public void windowIconified(WindowEvent e) { /* Do Nothing */ }
    
	public void windowOpened(WindowEvent e) {
		//Return the focus to the window.
//x 		this.requestFocusInWindow();

		try {
//x 			System.out.println("Auto Repeat Rate: " + System.getProperty("jnativehook.autoRepeatRate"));
//x 			System.out.println("\n" + "Auto Repeat Delay: " + System.getProperty("jnativehook.autoRepeatDelay"));
//x 			System.out.println("\n" + "Double Click Time: " + System.getProperty("jnativehook.multiClickInterval"));
//x 			System.out.println("\n" + "Pointer Sensitivity: " + System.getProperty("jnativehook.pointerSensitivity"));
//x 			System.out.println("\n" + "Pointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointerAccelerationMultiplier"));
//x 			System.out.println("\n" + "Pointer Acceleration Threshold: " + System.getProperty("jnativehook.pointerAccelerationThreshold"));

			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.out.println("\n" + "Error: " + ex.toString());
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
    
	public void windowClosed(WindowEvent e) {
        finalize();
	}

	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Appfx6();
			}
		});
	}
}
