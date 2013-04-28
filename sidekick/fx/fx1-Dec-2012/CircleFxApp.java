package appfx01;

/**


 * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
 * All rights reserved. Use is subject to license terms.
 */
import java.awt.Dimension;
import java.util.Random;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Lighting;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Circle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextBoundsType;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.stage.WindowEvent;
 
import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
 
 
/**
 * A sample with a control that creates a transparent stage that is centered on
 * your desktop. You can drag the stage with your mouse or use the scene
 * controls to minimize or close it. With a transparent stage, you must add
 * your own event handlers to perform these actions.
 *
 * @see javafx.stage.Stage
 * @see javafx.scene.Scene
 * @see javafx.stage.StageStyle
 * @see javafx.application.Platform
 * @related scenegraph/stage/Stage
 */
public class CircleFxApp extends Application implements IHooksCallback {
    //variables for storing initial position of the stage at the beginning of drag
    private double initX;
    private double initY;

    private Hooks7 m_hooks = null;
    
    private Stage m_stage;
    
    private void init(Stage primaryStage) {
        Group root = new Group();
        //x primaryStage.
        
        m_stage = primaryStage;
        //x primaryStage.toFront();
        
        primaryStage.setScene(new Scene(root));
         //create a button for initializing our new stage
        Button button = new Button("Create a Stage");
        button.setStyle("-fx-font-size: 24;");
        button.setDefaultButton(true);
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override public void handle(ActionEvent t) {
                // INITIALISATION OF THE STAGE/SCENE
                 
//x                 Dimension d = m_hooks.getScreenDimension();
//x                 int w = (int)d.getWidth();
//x                 int h = (int)d.getHeight();
//x                 
//x                 final Stage s = new CircleFxStage(null);
//x                 
//x                 Random rand = new Random();
//x                 int i = rand.nextInt(1000000);
//x 
//x                 s.setX(i % w);
//x                 s.setY(i % h);
                
                newCircle();
            }
        });
 
        m_hooks = new Hooks7(this);

 
        root.getChildren().add(button);
    }
    
    private void newCircle()
    {
        final int OFFSET = 100;
    
        Dimension d = m_hooks.getScreenDimension();
        int w = (int)d.getWidth() - OFFSET;
        int h = (int)d.getHeight() - OFFSET;
        
        final Stage s = new CircleFxStage(null);
        
        Random rand = new Random();
        int i = rand.nextInt(1000000);

        s.setX((i % w) + OFFSET / 2);
        s.setY((i % h) + OFFSET / 2);
    }
    
    public void callback()
    {
        newCircle();
    }
 
    @Override public void start(Stage primaryStage) throws Exception {
    
		try {
			GlobalScreen.registerNativeHook();
		}
		catch (NativeHookException ex) {
			System.out.println("\n" + "Error: " + ex.toString());
		}
    
    
    
        init(primaryStage);
//x        primaryStage.toBack();

//        primaryStage.showAndWait();
//        primaryStage.toFront();
        
//x         primaryStage.setOnShowing(new EventHandler<WindowEvent>() {
//x             public void handle(WindowEvent e) {
//x                 System.out.println("showing");
//x             }
//x         });        
//x         
//x         primaryStage.setOnHiding(new EventHandler<WindowEvent>() {
//x             public void handle(WindowEvent e) {
//x                 System.out.println("hiding");
//x             }
//x         });        
//x         
//x         primaryStage.setOnHidden(new EventHandler<WindowEvent>() {
//x             public void handle(WindowEvent e) {
//x                 System.out.println("Hiden");
//x             }
//x         });        
//x         
//x         


        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            public void handle(WindowEvent e) {
                System.out.println("setOnCloseRequest");
                 	m_hooks.finalize();
            }
        });        

        primaryStage.show();
        
    }
    public static void main(String[] args) { launch(args); }
}


