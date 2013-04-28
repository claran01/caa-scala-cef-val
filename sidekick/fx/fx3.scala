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
    def createChart(): {
        final String[] years = {"2007", "2008", "2009"};
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null));
        final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
        // setup chart
        bc.setTitle("Advanced Bar Chart");
        xAxis.setLabel("Year");
        xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
        yAxis.setLabel("Price");
        // add starting data
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
        series1.setName("Data Series 1");
        XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
        series2.setName("Data Series 2");
        XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        series3.setName("Data Series 3");
        // create sample data
        series1.getData().add(new XYChart.Data<String,Number>(years[0], 567));
        series1.getData().add(new XYChart.Data<String,Number>(years[1], 1292));
        series1.getData().add(new XYChart.Data<String,Number>(years[2], 2180));
        series2.getData().add(new XYChart.Data<String,Number>(years[0], 956));
        series2.getData().add(new XYChart.Data<String,Number>(years[1], 1665));
        series2.getData().add(new XYChart.Data<String,Number>(years[2], 2450));
        series3.getData().add(new XYChart.Data<String,Number>(years[0], 800));
        series3.getData().add(new XYChart.Data<String,Number>(years[1], 1000));
        series3.getData().add(new XYChart.Data<String,Number>(years[2], 2800));
        bc.getData().add(series1);
        bc.getData().add(series2);
        bc.getData().add(series3);
        return bc;
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




























// /**
//  * Copyright (c) 2008, 2012 Oracle and/or its affiliates.
//  * All rights reserved. Use is subject to license terms.
//  */
// import javafx.application.Application;
// import javafx.scene.Group;
// import javafx.scene.Scene;
// import javafx.stage.Stage;
// import java.util.*;

// import javafx.collections.FXCollections;
// import javafx.event.ActionEvent;
// import javafx.event.EventHandler;
// import javafx.geometry.Side;
// import javafx.scene.Node;
// import javafx.scene.chart.BarChart;
// import javafx.scene.chart.CategoryAxis;
// import javafx.scene.chart.NumberAxis;
// import javafx.scene.chart.XYChart;

// /**
//  *
//  * An advanced bar chart with a variety of controls.
//  *
//  * @see javafx.scene.chart.BarChart
//  * @see javafx.scene.chart.Chart
//  * @see javafx.scene.chart.NumberAxis
//  * @see javafx.scene.chart.XYChart
//  */
// public class AdvancedBarChartSample extends Application {

//     private void init(Stage primaryStage) {
//         Group root = new Group();
//         primaryStage.setScene(new Scene(root));
//         root.getChildren().add(createChart());
//     }

//     protected BarChart<String, Number> createChart() {
//         final String[] years = {"2007", "2008", "2009"};
//         final CategoryAxis xAxis = new CategoryAxis();
//         final NumberAxis yAxis = new NumberAxis();
//         yAxis.setTickLabelFormatter(new NumberAxis.DefaultFormatter(yAxis,"$",null));
//         final BarChart<String,Number> bc = new BarChart<String,Number>(xAxis,yAxis);
//         // setup chart
//         bc.setTitle("Advanced Bar Chart");
//         xAxis.setLabel("Year");
//         xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(years)));
//         yAxis.setLabel("Price");
//         // add starting data
//         XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
//         series1.setName("Data Series 1");
//         XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
//         series2.setName("Data Series 2");
//         XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
//         series3.setName("Data Series 3");
//         // create sample data
//         series1.getData().add(new XYChart.Data<String,Number>(years[0], 567));
//         series1.getData().add(new XYChart.Data<String,Number>(years[1], 1292));
//         series1.getData().add(new XYChart.Data<String,Number>(years[2], 2180));
//         series2.getData().add(new XYChart.Data<String,Number>(years[0], 956));
//         series2.getData().add(new XYChart.Data<String,Number>(years[1], 1665));
//         series2.getData().add(new XYChart.Data<String,Number>(years[2], 2450));
//         series3.getData().add(new XYChart.Data<String,Number>(years[0], 800));
//         series3.getData().add(new XYChart.Data<String,Number>(years[1], 1000));
//         series3.getData().add(new XYChart.Data<String,Number>(years[2], 2800));
//         bc.getData().add(series1);
//         bc.getData().add(series2);
//         bc.getData().add(series3);
//         return bc;
//     }

//     @Override public void start(Stage primaryStage) throws Exception {
//         init(primaryStage);
//         primaryStage.show();
//     }
//     public static void main(String[] args) { launch(args); }
// }
