package appfx01;

import java.awt.Dimension;
import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
 
 
public class T9FxApp extends Application implements IHooksCallback {
    private double initX;
    private double initY;

    private Hooks7 m_hooks = null;
    private T9Tray m_T9Tray = null;
    
    private Stage m_primaryStage;
    
    private SideKick m_sideKick = null;
    
    
    private void init(Stage primaryStage) {
        Group root = new Group();
        //x primaryStage.
        
        m_primaryStage = primaryStage;
        //x primaryStage.toFront();
        
        primaryStage.setScene(new Scene(root));
         //create a button for initializing our new stage
        Button button = new Button("Create a Stage");
        button.setStyle("-fx-font-size: 24;");
        button.setDefaultButton(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
            
                newCircle();
            }
        });
 
        m_hooks = new Hooks7(this);
        root.getChildren().add(button);
        
        m_T9Tray = new T9Tray();
        
        
        m_sideKick = new SideKick(primaryStage, 
                                  m_hooks.getScreenDimension());
                                  
                                  
        m_sideKick.show();                                  
    }
    
    private void newCircle()
    {
//        final int OFFSET = 100;
//    
//        Dimension d = m_hooks.getScreenDimension();
//        int w = (int)d.getWidth() - OFFSET;
//        int h = (int)d.getHeight() - OFFSET;
//        
//        final Stage s = new CircleFxStage(null);
//        
//        Random rand = new Random();
//        int i = rand.nextInt(1000000);
//
//        s.setX((i % w) + OFFSET / 2);
//        s.setY((i % h) + OFFSET / 2);
    }
    
    public void callback(Boolean i_show)
    {
        if(i_show == true)
        {
        	m_primaryStage.toFront();
            
            if(m_sideKick != null)
            {
                m_sideKick.toFront();
            }
            
        }
        else
        {
        	m_primaryStage.toBack();
            
            if(m_sideKick != null)
            {
                m_sideKick.toBack();
            }
        }
        
//x         newCircle();
        
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
    
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.out.println("\n" + "Error: " + ex.toString());
		}
    
        init(primaryStage);
//x     primaryStage.toBack();
//x     primaryStage.toFront();

        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                System.out.println("setOnCloseRequest");
                 	m_hooks.finalize();
            }
        });        

        primaryStage.show();
        
        

        String[] args = { "one", "two", "three"};
        
//x     TrayAppFx.main_tray(args);
        
    }
    
    
    
    public static void main(String[] args) { launch(args); }
    
    
    public static void start_up() 
    { 
//        String[] args = {
//                "arg0",
//                "arg1",
//                "arg2"
//            };
//    	
//    	launch(args); 
    }
}


