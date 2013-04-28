import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.animation.PathTransition
import javafx.animation.PathTransition.OrientationType
import javafx.animation.PathTransitionBuilder


//port javafx.animation.PathBuilder
import javafx.scene.shape.PathBuilder

import javafx.animation.Timeline
import javafx.event.EventHandler
import javafx.scene.Node
import javafx.scene.paint.Color
import javafx.scene.shape._
import javafx.util.Duration

class PathTransitionSample extends Application {

    println("constructor")

    var pathTransition: PathTransition

    def init(primaryStage : Stage) : Unit = {

        println("init")

        var root = new Group()
        primaryStage.setResizable(false)
        primaryStage.setScene(new Scene(root, 400,260))
        var rect = new Rectangle (0, 0, 40, 40)
        rect.setArcHeight(10)
        rect.setArcWidth(10)
        rect.setFill(Color.ORANGE)
        root.getChildren().add(rect)

        var path = PathBuilder.create().elements(new MoveTo(20,20),new CubicCurveTo(380, 0, 380, 120, 200, 120),new CubicCurveTo(0, 120, 0, 240, 380, 240)).build()
        
        path.setStroke(Color.DODGERBLUE)
        path.getStrokeDashArray().setAll(5d,5d)
        root.getChildren().add(path)
        
        pathTransition = PathTransitionBuilder.create()
                .duration(Duration.seconds(4))
                .path(path)
                .node(rect)
                .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
                .cycleCount(Timeline.INDEFINITE)
                .autoReverse(true)
                .build();
    }

    def play(): Unit = { pathTransition.play() }
    def stop(): Unit = { pathTransition.stop() }
    def getSampleWidth(): Double = 400
    def getSampleHeight(): Double = 260

    def start(primaryStage : Stage) : Unit = {

        println("start")

        init(primaryStage)
        primaryStage.show()
        play()
    }
}

object PathTransitionSample {
  def main(args : Array[String]) : Unit = {
    println("Launching PathTransitionSample")
    Application.launch(classOf[PathTransitionSample], args : _*)
  }
}


PathTransitionSample.main(Array("1","2"))




















// import javafx.application.Application
// import javafx.scene.Group
// import javafx.scene.Scene
// import javafx.stage.Stage
// import javafx.animation.PathTransition
// import javafx.animation.PathTransition.OrientationType
// import javafx.animation.PathTransitionBuilder
// import javafx.animation.Timeline
// import javafx.event.EventHandler
// import javafx.scene.Node
// import javafx.scene.paint.Color
// import javafx.scene.shape._
// import javafx.util.Duration

// public class PathTransitionSample extends Application {

//     private PathTransition pathTransition;

//     private void init(Stage primaryStage) {
//         Group root = new Group();
//         primaryStage.setResizable(false);
//         primaryStage.setScene(new Scene(root, 400,260));
//         Rectangle rect = new Rectangle (0, 0, 40, 40);
//         rect.setArcHeight(10);
//         rect.setArcWidth(10);
//         rect.setFill(Color.ORANGE);
//         root.getChildren().add(rect);
//         Path path = PathBuilder.create()
//                 .elements(
//                     new MoveTo(20,20),
//                     new CubicCurveTo(380, 0, 380, 120, 200, 120),
//                     new CubicCurveTo(0, 120, 0, 240, 380, 240)
//                 )
//                 .build();
//         path.setStroke(Color.DODGERBLUE);
//         path.getStrokeDashArray().setAll(5d,5d);
//         root.getChildren().add(path);
        
//         pathTransition = PathTransitionBuilder.create()
//                 .duration(Duration.seconds(4))
//                 .path(path)
//                 .node(rect)
//                 .orientation(OrientationType.ORTHOGONAL_TO_TANGENT)
//                 .cycleCount(Timeline.INDEFINITE)
//                 .autoReverse(true)
//                 .build();
//     }

//     public void play() {
//         pathTransition.play();
//     }

//     @Override public void stop() {
//         pathTransition.stop();
//     }

//     public double getSampleWidth() { return 400; }

//     public double getSampleHeight() { return 260; }

//     @Override public void start(Stage primaryStage) throws Exception {
//         init(primaryStage);
//         primaryStage.show();
//         play();
//     }
//     public static void main(String[] args) { launch(args); }
// }
