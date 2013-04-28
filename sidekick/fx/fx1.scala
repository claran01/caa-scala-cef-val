import javafx.application._
import javafx.scene._
import javafx.stage._
import javafx.event._
import javafx.scene.layout._
import javafx.scene.control._
import javafx.scene.shape._
import javafx.scene.paint._

class ScalaJavaFXApp extends Application {
  println("ScalaJavaFXApp constructor")
  
  // def start(stage : Stage) : Unit = {
  //   println("start " + stage)
  // }

	def start(stage : Stage) : Unit = {
	    println("start " + stage)
	    stage.setTitle("Example of Scala - JavaFX application")
	    val root = new VBox
	    val stuff = root.getChildren
	    val rect = new Rectangle(0, 0, 400, 100)
	    val button = new Button("Press to change to: " + Color.RED.invert)


	    stuff.addAll(button, rect)
	    rect.setFill(Color.RED)
	    button.setOnAction(new EventHandler[ActionEvent]() {
	      override def handle(event : ActionEvent) : Unit = {
	        val oldc : Color = rect.getFill.asInstanceOf[Color]
	        rect.setFill(oldc.invert)
	        button.setText("Press to change to: " + oldc)
	      }
	    })
	    button.setPrefSize(400, 100)
	    stage.setScene(new Scene(root, 400, 200))
	    stage.show
	  }


}


object ScalaJavaFXApp {
  def main(args : Array[String]) : Unit = {
    println("Launching ScalaJavaFXApp")
    Application.launch(classOf[ScalaJavaFXApp], args : _*)
  }
}




ScalaJavaFXApp.main(Array("1","2"))