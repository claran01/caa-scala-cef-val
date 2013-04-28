package appfx01;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.ItemSelectable;
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
public class Appfx4 extends JFrame implements NativeKeyListener, NativeMouseInputListener, NativeMouseWheelListener, WindowListener, ItemListener {
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1865350670081087993L;

	/** Checkbox's for event delivery options. */
	private JCheckBox chkKeyboard, chkButton, chkMotion, chkWheel;

	/** The text area to display event info. */
	private JTextArea txtEventInfo;

    
    private boolean isFinalized = false;
    
	/**
	 * Instantiates a new native hook demo.
	 */
	public Appfx4() {
		//Setup the main window.
		setTitle("JNativeHook Demo");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		addWindowListener(this);

//x 		//Create options panel
//x 		JPanel grpOptions = new JPanel();
//x 		grpOptions.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
//x 		grpOptions.setLayout(new FlowLayout(FlowLayout.LEADING));
//x 		add(grpOptions, BorderLayout.NORTH);

//x 		//Create keyboard checkbox
//x 		chkKeyboard = new JCheckBox("Keyboard Events");
//x 		chkKeyboard.setMnemonic(KeyEvent.VK_K);
//x 		chkKeyboard.addItemListener(this);
//x 		chkKeyboard.setSelected(true);
//x 		grpOptions.add(chkKeyboard);

//x 		//Create button checkbox
//x 		chkButton = new JCheckBox("Button Events");
//x 		chkButton.setMnemonic(KeyEvent.VK_B);
//x 		chkButton.addItemListener(this);
//x 		chkButton.setSelected(true);
//x 		grpOptions.add(chkButton);

//x 		//Create motion checkbox
//x 		chkMotion = new JCheckBox("Motion Events");
//x 		chkMotion.setMnemonic(KeyEvent.VK_M);
//x 		chkMotion.addItemListener(this);
//x 		chkMotion.setSelected(true);
//x 		grpOptions.add(chkMotion);

//x 		//Create wheel checkbox
//x 		chkWheel = new JCheckBox("Wheel Events");
//x 		chkWheel.setMnemonic(KeyEvent.VK_W);
//x 		chkWheel.addItemListener(this);
//x 		chkWheel.setSelected(true);
//x 		grpOptions.add(chkWheel);

//x 		//Create feedback area
//x 		txtEventInfo = new JTextArea();
//x 		txtEventInfo.setEditable(false);
//x 		txtEventInfo.setBackground(new Color(0xFF, 0xFF, 0xFF));
//x 		txtEventInfo.setForeground(new Color(0x00, 0x00, 0x00));
//x 		txtEventInfo.setText("");

//x 		JScrollPane scrollPane = new JScrollPane(txtEventInfo);
//x 		scrollPane.setPreferredSize(new Dimension(375, 125));
//x 		add(scrollPane, BorderLayout.CENTER);

        
				GlobalScreen.getInstance().addNativeKeyListener(this);
				GlobalScreen.getInstance().addNativeMouseListener(this);
				GlobalScreen.getInstance().addNativeMouseMotionListener(this);
				GlobalScreen.getInstance().addNativeMouseWheelListener(this);
                
//x 		    GlobalScreen.getInstance().removeNativeKeyListener(this);
//x 		    GlobalScreen.getInstance().removeNativeMouseListener(this);
//x 		    GlobalScreen.getInstance().removeNativeMouseMotionListener(this);
//x 		    GlobalScreen.getInstance().removeNativeMouseWheelListener(this);

        
        
        
		setVisible(true);
	}

    
	/**
	 * @see java.awt.event.ItemListener#itemStateChanged(java.awt.event.ItemEvent)
	 */
	public void itemStateChanged(ItemEvent e) {
//x 		ItemSelectable item = e.getItemSelectable();
//x 
//x 		if (item == chkKeyboard) {
//x 			//Keyboard checkbox was changed, adjust listeners accordingly
//x 			if (e.getStateChange() == ItemEvent.SELECTED) {
//x 				GlobalScreen.getInstance().addNativeKeyListener(this);
//x 			}
//x 			else {
//x 				GlobalScreen.getInstance().removeNativeKeyListener(this);
//x 			}
//x 		}
//x 		else if (item == chkButton) {
//x 			//Button checkbox was changed, adjust listeners accordingly
//x 			if (e.getStateChange() == ItemEvent.SELECTED) {
//x 				GlobalScreen.getInstance().addNativeMouseListener(this);
//x 			}
//x 			else {
//x 				GlobalScreen.getInstance().removeNativeMouseListener(this);
//x 			}
//x 		}
//x 		else if (item == chkMotion) {
//x 			//Motion checkbox was changed, adjust listeners accordingly
//x 			if (e.getStateChange() == ItemEvent.SELECTED) {
//x 				GlobalScreen.getInstance().addNativeMouseMotionListener(this);
//x 			}
//x 			else {
//x 				GlobalScreen.getInstance().removeNativeMouseMotionListener(this);
//x 			}
//x 		}
//x 		else if (item == chkWheel) {
//x 			//Motion checkbox was changed, adjust listeners accordingly
//x 			if (e.getStateChange() == ItemEvent.SELECTED) {
//x 				GlobalScreen.getInstance().addNativeMouseWheelListener(this);
//x 			}
//x 			else {
//x 				GlobalScreen.getInstance().removeNativeMouseWheelListener(this);
//x 			}
//x 		}
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

	/**
	 * Write information about the <code>NativeInputEvent</code> to the text
	 * window.
	 *
	 * @param e the native input event to display.
	 */
	private void displayEventInfo(final NativeInputEvent e) {
		/* Note: JNativeHook does *NOT* operate on the event dispatch thread.
		 * Because Swing components must be accessed on the event dispatching
		 * thread, you *MUST* wrap access to Swing components using the
		 * SwingUtilities.invokeLater() or EventQueue.invokeLater() methods.
		 */
//x		SwingUtilities.invokeLater(new Runnable() {
//x			public void run() {
//x				txtEventInfo.append("\n" + e.paramString());
//x
//x				try {
//x					txtEventInfo.setCaretPosition(txtEventInfo.getLineStartOffset(txtEventInfo.getLineCount() - 1));
//x				}
//x				catch (BadLocationException ex) {
//x					txtEventInfo.setCaretPosition(txtEventInfo.getDocument().getLength());
//x				}
//x			}
//x		});

        System.out.println(e.paramString());

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
//x	public void windowOpened(WindowEvent e) {
//x		//Return the focus to the window.
//x		this.requestFocusInWindow();
//x
//x		try {
//x			txtEventInfo.setText("Auto Repeat Rate: " + System.getProperty("jnativehook.autoRepeatRate"));
//x			txtEventInfo.append("\n" + "Auto Repeat Delay: " + System.getProperty("jnativehook.autoRepeatDelay"));
//x			txtEventInfo.append("\n" + "Double Click Time: " + System.getProperty("jnativehook.multiClickInterval"));
//x			txtEventInfo.append("\n" + "Pointer Sensitivity: " + System.getProperty("jnativehook.pointerSensitivity"));
//x			txtEventInfo.append("\n" + "Pointer Acceleration Multiplier: " + System.getProperty("jnativehook.pointerAccelerationMultiplier"));
//x			txtEventInfo.append("\n" + "Pointer Acceleration Threshold: " + System.getProperty("jnativehook.pointerAccelerationThreshold"));
//x
//x			//Initialze native hook.  This is done on window open because the
//x			//listener requires the txtEventInfo object to be constructed.
//x			GlobalScreen.registerNativeHook();
//x		}
//x		catch (NativeHookException ex) {
//x			txtEventInfo.append("\n" + "Error: " + ex.toString());
//x		}
//x
//x		try {
//x			txtEventInfo.setCaretPosition(txtEventInfo.getLineStartOffset(txtEventInfo.getLineCount() - 1));
//x		}
//x		catch (BadLocationException ex) {
//x			txtEventInfo.setCaretPosition(txtEventInfo.getDocument().getLength());
//x		}
//x	}

    
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

//x 		try {
//x 			txtEventInfo.setCaretPosition(txtEventInfo.getLineStartOffset(txtEventInfo.getLineCount() - 1));
//x 		}
//x 		catch (BadLocationException ex) {
//x 			txtEventInfo.setCaretPosition(txtEventInfo.getDocument().getLength());
//x 		}
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
//x		//Clean up the native hook.
//x		GlobalScreen.unregisterNativeHook();
//x		System.runFinalization();
//x		System.exit(0);

//x         System.out.println("zzzzzzzzz");
//x         if(isFinalized == false)
//x         {
//x             System.out.println("windowClosed");
//x             
//x             isFinalized = true;
//x         
//x             //Clean up the native hook.
//x             GlobalScreen.unregisterNativeHook();
//x             System.runFinalization();
//x             System.exit(0);
//x         }

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
				new Appfx4();
			}
		});
	}
}
