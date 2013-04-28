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
        val years = Array("2007", "2008", "2009", "2010", "2011", "2012")
        //val years = Array("2007", "2008", "2009")

        val xAxis = new CategoryAxis()
        val yAxis = new NumberAxis()
        
        var stringList = new ArrayList[String]()
        for (y <- years) stringList.add(y)


        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null))
        val bc = new BarChart[String,Number](xAxis,yAxis)
        bc.setTitle("Advanced Bar Chart")

        xAxis.setLabel("Year")
        xAxis.setCategories(FXCollections.observableArrayList(stringList))
        yAxis.setLabel("Price")

        class Series(bc: BarChart[String,Number], year_name: String) {
            val series = new XYChart.Series[String,Number]()
            series.setName("Data Series #" + year_name)
            val data = series.getData()

            bc.getData().add(series)

//x            def add(y: Integer, v: Integer): Unit = data.add(new XYChart.Data[String,Number](years(y),v))
            def add(v: Integer): Unit = data.add(new XYChart.Data[String,Number](year_name,v))
        }
        var r = new scala.util.Random

        var ss = new Array[Series](years.length)
        for (y <- 0 until years.length) { 
            ss(y) = new Series(bc, years(y))

            for(i <- 0 to 2 ) ss(y).add(r.nextInt(1000))
        }


        // for(y <- 0 until years.length) { ss(y).add(y, r.nextInt(1000))  }


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

