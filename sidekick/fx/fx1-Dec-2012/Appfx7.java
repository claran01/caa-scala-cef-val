package appfx01;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;

public class Appfx7 extends JFrame implements WindowListener 
{
	private static final long serialVersionUID = 1865350670081087993L;

    private Hooks7 m_hooks = null;
    
	public Appfx7() 
    {
		setTitle("JNativeHook Demo");
		setLayout(new BorderLayout());
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setSize(600, 300);
		addWindowListener(this);

		setVisible(true);
		
        m_hooks = new Hooks7(null);
	}
    
	public void windowActivated(WindowEvent e) { /* Do Nothing */ }
	public void windowClosing(WindowEvent e) { /* Do Nothing */ }
	public void windowDeactivated(WindowEvent e) { /* Do Nothing */ }
	public void windowDeiconified(WindowEvent e) { /* Do Nothing */ }
	public void windowIconified(WindowEvent e) { /* Do Nothing */ }
    
	public void windowOpened(WindowEvent e) {
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.out.println("\n" + "Error: " + ex.toString());
		}
	}
    
	public void windowClosed(WindowEvent e) {
        m_hooks.finalize();
	}

	public static void main(String[] args) {
		
		System.out.println("Appfx7");
		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Appfx7();
			}
		});
	}
}
