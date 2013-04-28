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

    // return BarChart<String, Number>
    def createChart(): BarChart[String, Number] = {
        val years = Array("2007", "2008", "2009")

        val xAxis = new CategoryAxis()
        val yAxis = new NumberAxis()
        
        var stringList = new ArrayList[String]()
        stringList.add("2007")
        stringList.add("2008")
        stringList.add("2009")


        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null))
        val bc = new BarChart[String,Number](xAxis,yAxis)
        bc.setTitle("Advanced Bar Chart")

        xAxis.setLabel("Year")
        xAxis.setCategories(FXCollections.observableArrayList(stringList))
        yAxis.setLabel("Price")

        // val series1 = new XYChart.Series[String,Number]()
        // series1.setName("Data Series 1")
        // val series2 = new XYChart.Series[String,Number]()
        // series2.setName("Data Series 2")
        // val series3 = new XYChart.Series[String,Number]()
        // series3.setName("Data Series 3")

        // series1.getData().add(new XYChart.Data[String,Number](years(0), 567))
        // series1.getData().add(new XYChart.Data[String,Number](years(1), 1292))
        // series1.getData().add(new XYChart.Data[String,Number](years(2), 2180))
        // series2.getData().add(new XYChart.Data[String,Number](years(0), 956))
        // series2.getData().add(new XYChart.Data[String,Number](years(1), 1665))
        // series2.getData().add(new XYChart.Data[String,Number](years(2), 2450))
        // series3.getData().add(new XYChart.Data[String,Number](years(0), 800))
        // series3.getData().add(new XYChart.Data[String,Number](years(1), 1000))
        // series3.getData().add(new XYChart.Data[String,Number](years(2), 2800))


        class Series(name: String) {
            val series = new XYChart.Series[String,Number]()
            series.setName("Data Series #" + name)
            val data = series.getData()

            def add(y: Integer, v: Integer): Unit = data.add(new XYChart.Data[String,Number](years(y),v))
        }

        var ss = Array(new Series("1"), new Series("2"), new Series("3"))
        val v0 = Array(567, 1292, 2180, 956, 1665, 2450, 800, 1000, 2800)

        for(s <- 0 to 2 ; y <- 0 to 2) {
            ss(s).add(y, v0(s + (y * 3)))
        }


        // bc.getData().add(series1)
        // bc.getData().add(series2)
        // bc.getData().add(series3)


        bc.getData().add(ss(0).series)
        bc.getData().add(ss(1).series)
        bc.getData().add(ss(2).series)

        return bc
    }


    def start(primaryStage : Stage) : Unit = {

        println("start " + primaryStage)

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

