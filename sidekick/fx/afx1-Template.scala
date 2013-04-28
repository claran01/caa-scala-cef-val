import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.stage.Stage
import java.util._

import javafx.collections.FXCollections
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Side
import javafx.scene.Node
import javafx.scene.chart.BarChart
import javafx.scene.chart.CategoryAxis
import javafx.scene.chart.NumberAxis
import javafx.scene.chart.XYChart






class TestApp extends Application {

    def init(primaryStage : Stage) : Unit = {
        var root = new Group()
        primaryStage.setScene(new Scene(root))
        root.getChildren().add(createChart())
    }

    def start(primaryStage : Stage) : Unit = {

        println("start " + stage)

        init(primaryStage)
        primaryStage.show()
    }
}


object TestApp {
  def main(args : Array[String]) : Unit = {
    println("Launching TestApp")
    Application.launch(classOf[TestApp], args : _*)
  }
}

TestApp.main(Array("1","2"))












