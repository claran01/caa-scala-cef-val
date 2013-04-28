/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package appfx01;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.awt.event.MouseEvent;

/**
 *
 * @author spw
 */
public class Appfx extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
//        
//        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, 
//                                     new EventHandler<MouseEvent>() 
//                                     {
//                                        @Override
//                                        public void handle(MouseEvent t) {            
////x                                             if (t.getClickCount() >1) {
////x                                                 reset(canvas, Color.BLUE);
//                                                System.out.println("Mouse Click...");
////                                            }  
//                                        }
//                                     });        
//        
//        
//        
//        
//        
//        primaryStage.addEventHandler(MouseEvent.MOUSE_CLICKED, 
//                new EventHandler<InputEvent>() 
//                {
//                   @Override
////                   public void handle(MouseEvent t) {            
////                   }
//                   
//                   
//                   public void handle(InputEvent event) {
//                       System.out.println("Handling event " + event.getEventType()); 
//                       event.consume();
//                   }        
//                   
//                   
//                });        
//        
//        
        
        
        
        
        
        
        
        
//        primaryStage.addEventHandler(arg0, arg1)
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * The main() method is ignored in correctly deployed JavaFX application.
     * main() serves only as fallback in case the application can not be
     * launched through deployment artifacts, e.g., in IDEs with limited FX
     * support. NetBeans ignores main().
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
