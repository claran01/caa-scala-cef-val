package appfx01;

import java.awt.Dimension;

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

import javafx.scene.shape.Rectangle;
 
public class SideKick extends Stage {
    //variables for storing initial position of the stage at the beginning of drag
    private double initX;
    private double initY;

    private Stage m_thisStage = null;
    
//        Dimension d = m_hooks.getScreenDimension();
//        int w = (int)d.getWidth() - OFFSET;
//        int h = (int)d.getHeight() - OFFSET;
    
    private Dimension m_screenDimension;
    
    public SideKick(Stage primaryStage,
                    Dimension i_screenDimension) {
        super(StageStyle.TRANSPARENT);
                 
        m_screenDimension = i_screenDimension;
                 
        m_thisStage = this;
        
        Group rootGroup = new Group();
        //create scene with set width, height and color
//x         Scene scene = new Scene(rootGroup, 200, 200, Color.TRANSPARENT);
        
        Scene scene = new Scene(rootGroup, 200, m_screenDimension.getHeight(), Color.TRANSPARENT);
        
        
        //set scene to stage
        this.setScene(scene);
        //center this on screen
//        this.centerOnScreen();
        this.setX(m_screenDimension.getWidth() - 200);
        this.setY(0);


        //show the this
        this.show();

        
        
       // CREATION OF THE DRAGGER (CIRCLE)
  
       //create dragger with desired size
       Circle draggerC = new Circle(100, 100, 100);
       //fill the dragger with some nice radial background
       draggerC.setFill(new RadialGradient(-0.3, 135, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
           new Stop(0, Color.DARKGRAY),
           new Stop(1, Color.BLACK)
        }));
         
        //create dragger with desired size
//x         Circle dragger = new Circle(100, 100, 100);
        
        Rectangle dragger = new Rectangle(200, 
                                          m_screenDimension.getHeight());
        
        
        //fill the dragger with some nice radial background
        dragger.setFill(new RadialGradient(-0.3, 135, 0.5, 0.5, 1, true, CycleMethod.NO_CYCLE, new Stop[] {
            new Stop(0, Color.DARKGRAY),
            new Stop(1, Color.BLACK)
         }));
         
         
         
        //when mouse button is pressed, save the initial position of screen
        rootGroup.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                initX = me.getScreenX() - m_thisStage.getX();
                initY = me.getScreenY() - m_thisStage.getY();
            }
        });

        //when screen is dragged, translate it accordingly
        rootGroup.setOnMouseDragged(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
            	m_thisStage.setX(me.getScreenX() - initX);
            	m_thisStage.setY(me.getScreenY() - initY);
            }
        });
        
//-         // CREATE MIN AND CLOSE BUTTONS
//-         //create button for closing application
//-         Button close = new Button("Close me");
//-         close.setOnAction(new EventHandler<ActionEvent>() {
//-             public void handle(ActionEvent event) {
//-                 //in case we would like to close whole demo
//-                 //javafx.application.Platform.exit();
//- 
//-                 //however we want to close only this instance of this
//-             	m_thisStage.close();
//-             }
//-         });
//- 
//-         //create button for minimalising application
//-         Button min = new Button("Minimize me");
//-         min.setOnAction(new EventHandler<ActionEvent>() {
//-             public void handle(ActionEvent event) {
//-             	m_thisStage.setIconified(true);
//-             }
//-         });
//- 
//- 
//-         // CREATE SIMPLE TEXT NODE
//-         Text text = new Text("JavaFX"); //20, 110,
//-         text.setFill(Color.WHITESMOKE);
//-         text.setEffect(new Lighting());
//-         text.setBoundsType(TextBoundsType.VISUAL);
//-         text.setFont(Font.font(Font.getDefault().getFamily(), 50));
//- 
//-         // USE A LAYOUT VBOX FOR EASIER POSITIONING OF THE VISUAL NODES ON SCENE
//-         VBox vBox = new VBox();
//-         vBox.setSpacing(10);
//-         vBox.setPadding(new Insets(60, 0, 0, 20));
//-         vBox.setAlignment(Pos.TOP_CENTER);
//-         vBox.getChildren().addAll(text, min, close);
//- 
//-         //add all nodes to main root group
//-         rootGroup.getChildren().addAll(dragger, vBox);
        rootGroup.getChildren().addAll(dragger,draggerC);
    }
}


