package appfx01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.ItemSelectable;
import java.awt.Point;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.text.BadLocationException;
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.NativeInputEvent;
import org.jnativehook.keyboard.NativeKeyEvent;
import org.jnativehook.keyboard.NativeKeyListener;
import org.jnativehook.mouse.NativeMouseEvent;
import org.jnativehook.mouse.NativeMouseInputListener;
import org.jnativehook.mouse.NativeMouseWheelEvent;
import org.jnativehook.mouse.NativeMouseWheelListener;

/**
 * A demonstration of how to use the JNativeHook library.
 *
 * @author	Alexander Barker (<a href="mailto:alex@1stleg.com">alex@1stleg.com</a>)
 * @version	1.1
 *
 * @see GlobalScreen
 * @see NativeKeyListener
 */
//x public class Appfx5 extends JFrame implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener, ItemListener {
	public class Appfx5 extends JFrame implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1865350670081087993L;

    private boolean isFinalized = false;
    
    private int m_width = 0;
    private int m_height = 0;
    
    
	/**
	 * Instantiates a new native hook demo.
	 */
	public Appfx5() {
		//Setup the main window.
		setTitle("JNativeHook Demo");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		addWindowListener(this);

        GlobalScreen.getInstance().addNativeKeyListener(this);
        GlobalScreen.getInstance().addNativeMouseListener(this);
        GlobalScreen.getInstance().addNativeMouseMotionListener(this);
        GlobalScreen.getInstance().addNativeMouseWheelListener(this);
                
//x 	GlobalScreen.getInstance().removeNativeKeyListener(this);
//x 	GlobalScreen.getInstance().removeNativeMouseListener(this);
//x 	GlobalScreen.getInstance().removeNativeMouseMotionListener(this);
//x 	GlobalScreen.getInstance().removeNativeMouseWheelListener(this);

//        GlobalScreen

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
	
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * @see org.jnativehook.keyboard.NativeKeyListener#nativeKeyPressed(org.jnativehook.keyboard.NativeKeyEvent)
	 */
	public void nativeKeyPressed(NativeKeyEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.keyboard.NativeKeyListener#nativeKeyReleased(org.jnativehook.keyboard.NativeKeyEvent)
	 */
	public void nativeKeyReleased(NativeKeyEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.keyboard.NativeKeyListener#nativeKeyTyped(org.jnativehook.keyboard.NativeKeyEvent)
	 */
	public void nativeKeyTyped(NativeKeyEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseListener#nativeMouseClicked(org.jnativehook.mouse.NativeMouseEvent)
	 */
	public void nativeMouseClicked(NativeMouseEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseListener#nativeMousePressed(org.jnativehook.mouse.NativeMouseEvent)
	 */
	public void nativeMousePressed(NativeMouseEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseListener#nativeMouseReleased(org.jnativehook.mouse.NativeMouseEvent)
	 */
	public void nativeMouseReleased(NativeMouseEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseMotionListener#nativeMouseMoved(org.jnativehook.mouse.NativeMouseEvent)
	 */
	public void nativeMouseMoved(NativeMouseEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseMotionListener#nativeMouseDragged(org.jnativehook.mouse.NativeMouseEvent)
	 */
	public void nativeMouseDragged(NativeMouseEvent e) {
		displayEventInfo(e);
	}

	/**
	 * @see org.jnativehook.mouse.NativeMouseWheelListener#nativeMouseWheelMoved(org.jnativehook.mouse.NativeMouseWheelEvent)
	 */
	public void nativeMouseWheelMoved(NativeMouseWheelEvent e) {
		displayEventInfo(e);
	}

	private void displayEventInfo(final NativeInputEvent e) {
		/* Note: JNativeHook does *NOT* operate on the event dispatch thread.
		 * Because Swing components must be accessed on the event dispatching
		 * thread, you *MUST* wrap access to Swing components using the
		 * SwingUtilities.invokeLater() or EventQueue.invokeLater() methods.
		 */
			

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                System.out.println(e.paramString());
                
//                System.out.println(e.getID() + 
//                                   " || " +
//                                    e.getWhen() +
//                                   " || " +
//                                    Integer.toBinaryString(e.getModifiers()) + 
//                                   " || " +
//                                    e.getModifiersText(e.getModifiers()));
                
                
                if(e instanceof NativeMouseEvent)
                {
                	Point p = ((NativeMouseEvent) e).getPoint();
                	
                	System.out.println(p.x + " || " + p.y);
                }
            }
        });

	}

	/**
	 * Unimplemented
	 *
	 * @see java.awt.event.WindowListener#windowActivated(java.awt.event.WindowEvent)
	 */
	public void windowActivated(WindowEvent e) { /* Do Nothing */ }

	/**
	 * Unimplemented
	 *
	 * @see java.awt.event.WindowListener#windowClosing(java.awt.event.WindowEvent)
	 */
	public void windowClosing(WindowEvent e) { /* Do Nothing */ }

	/**
	 * Unimplemented
	 *
	 * @see java.awt.event.WindowListener#windowDeactivated(java.awt.event.WindowEvent)
	 */
	public void windowDeactivated(WindowEvent e) { /* Do Nothing */ }

	/**
	 * Unimplemented
	 *
	 * @see java.awt.event.WindowListener#windowDeiconified(java.awt.event.WindowEvent)
	 */
	public void windowDeiconified(WindowEvent e) { /* Do Nothing */ }

	/**
	 * Unimplemented
	 *
	 * @see java.awt.event.WindowListener#windowIconified(java.awt.event.WindowEvent)
	 */
	public void windowIconified(WindowEvent e) { /* Do Nothing */ }

	/**
	 * Display information about the native keyboard and mouse along with any
	 * errors that may have occurred.
	 *
	 * @see java.awt.event.WindowListener#windowOpened(java.awt.event.WindowEvent)
	 */
	public void windowOpened(WindowEvent e) {
		//Return the focus to the window.
		this.requestFocusInWindow();

		try {
			System.out.println("Auto Repeat Rate: " + System.getProperty("jnativehook.autoRepeatRate"));
			System.out.println("\n" + "Auto Repeat Delay: " + System.getProperty("jnativehook.autoRepeatDelay"));
			System.out.println("\n" + "Double Click Time: " + System.getProperty("jnativehook.multiClickInterval"));
			System.out.println("\n" + "Pointer Sensitivity: " + System.getProperty("jnativehook.pointerSensitivity"));
			System.out.println("\n" + "Pointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointerAccelerationMultiplier"));
			System.out.println("\n" + "Pointer Acceleration Threshold: " + System.getProperty("jnativehook.pointerAccelerationThreshold"));

			//Initialze native hook.  This is done on window open because the
			//listener requires the txtEventInfo object to be constructed.
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
    
	/**
	 * Finalize and exit the program.
	 *
	 * @see java.awt.event.WindowListener#windowClosed(java.awt.event.WindowEvent)
	 */
	public void windowClosed(WindowEvent e) {
        finalize();
	}

	/**
	 * The demo project entry point.
	 *
	 * @param args unused.
	 */
	public static void main(String[] args) {
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Appfx5();
			}
		});
	}
}
