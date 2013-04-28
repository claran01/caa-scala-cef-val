
import javafx.application.Application
import javafx.scene.Group
import javafx.scene.Scene
import javafx.stage.Stage
import javafx.collections.ObservableList
import javafx.geometry.HPos
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.Separator
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.layout._


class TestApp extends Application {

    // val Image ICON_48 = new Image(GridPaneSample.class.getResourceAsStream("icon-48x48.png"))
//    val ICON_48 = new Image(TestApp.class.getResourceAsStream("C:\\work.caa.scala.cef.val\\p1\sidekick\\fx\\resources\\icon-48x48.png"))
    val ICON_48 = new Image("file://C:\\work.caa.scala.cef.val\\p1\\sidekick\\fx\\resources\\icon-48x48.png", true);

    def init(primaryStage : Stage) : Unit = {
        var root = new Group()
        primaryStage.setScene(new Scene(root))






        val vbox = new VBox()

        var grid1Caption = new Label("The example below shows GridPane content placement by specifying rows and columns:")
        grid1Caption.setWrapText(true)
        var grid1 = new GridPane()
        grid1.setHgap(4)
        grid1.setVgap(6)
        grid1.setPadding(new Insets(18, 18, 18, 18))
//x         ObservableList<Node> content = grid1.getChildren()
        val content = grid1.getChildren()

        var label = new Label("Name:")
        GridPane.setConstraints(label, 0, 0)
        GridPane.setHalignment(label, HPos.RIGHT)
        content.add(label)

        label = new Label("John Q. Public")
        GridPane.setConstraints(label, 1, 0, 2, 1)
        GridPane.setHalignment(label, HPos.LEFT)
        content.add(label)

        label = new Label("Address:")
        GridPane.setConstraints(label, 0, 1)
        GridPane.setHalignment(label, HPos.RIGHT)
        content.add(label)

        label = new Label("12345 Main Street, Some City, CA")
        GridPane.setConstraints(label, 1, 1, 5, 1)
        GridPane.setHalignment(label, HPos.LEFT)
        content.add(label)

        vbox.getChildren().addAll(grid1Caption, grid1, new Separator())

        val grid2Caption = new Label("The example below shows GridPane content placement by influencing the rows and columns themselves.")
        grid2Caption.setWrapText(true)
        grid2Caption.setWrapText(true)
        val grid2 = new GridPane()
        grid2.setPadding(new Insets(18, 18, 18, 18))
        val rowinfo = new RowConstraints(40, 40, 40)
        val colinfo = new ColumnConstraints(90, 90, 90)

        for (i <- 0 to 2)  grid2.getRowConstraints().add(rowinfo)
        for (i <- 0 to 2)  grid2.getColumnConstraints().add(colinfo)

        
        val category = new Label("Category:")
        GridPane.setHalignment(category, HPos.RIGHT)
        val categoryValue = new Label("Wines")             
        val company = new Label("Company:")
        GridPane.setHalignment(company, HPos.RIGHT)
        val companyValue = new Label("Acme Winery")
        val rating = new Label("Rating:")
        GridPane.setHalignment(rating, HPos.RIGHT)
        val ratingValue = new Label("Excellent")

        val imageView = new ImageView(ICON_48)
        GridPane.setHalignment(imageView, HPos.CENTER)

        //Place content
        GridPane.setConstraints(category, 0, 0)
        GridPane.setConstraints(categoryValue, 1, 0)
        GridPane.setConstraints(company, 0, 1)
        GridPane.setConstraints(companyValue, 1, 1)
        GridPane.setConstraints(imageView, 2, 1)
        GridPane.setConstraints(rating, 0, 2)
        GridPane.setConstraints(ratingValue, 1, 2)
        grid2.getChildren().addAll(category, categoryValue, company, companyValue, imageView, rating, ratingValue)

        vbox.getChildren().addAll(grid2Caption, grid2, new Separator())

        //grid3 places the child by influencing the rows and columns
        //via GridRowInfo and GridColumnInfo. This grid uses the percentages
        val grid3Caption = new Label("The example below shows GridPane content placement by influencing row and column percentages.  Also, grid lines are made visible in this example.  The lines can be helpful in debugging.")
        grid3Caption.setWrapText(true)
        val grid3 = new GridPane()
        grid3.setPadding(new Insets(18, 18, 18, 18))
        grid3.setGridLinesVisible(true)
        val rowinfo3 = new RowConstraints()
        rowinfo3.setPercentHeight(50)

        val colInfo2 = new ColumnConstraints()
        colInfo2.setPercentWidth(25)

        val colInfo3 = new ColumnConstraints()
        colInfo3.setPercentWidth(50)

        grid3.getRowConstraints().add(rowinfo3)//2*50 percent
        grid3.getRowConstraints().add(rowinfo3)

        grid3.getColumnConstraints().add(colInfo2) //25 percent
        grid3.getColumnConstraints().add(colInfo3) //50 percent
        grid3.getColumnConstraints().add(colInfo2) //25 percent

        val condLabel = new Label(" Member Name:")
        GridPane.setHalignment(condLabel, HPos.RIGHT)
        GridPane.setConstraints(condLabel, 0, 0)
        val condValue = new Label("MyName")
        GridPane.setMargin(condValue, new Insets(0, 0, 0, 10))
        GridPane.setConstraints(condValue, 1, 0)
      
        val acctLabel = new Label("Member Number:")
        GridPane.setHalignment(acctLabel, HPos.RIGHT)
        GridPane.setConstraints(acctLabel, 0, 1)
        val textBox = new TextField("Your number")
        GridPane.setMargin(textBox, new Insets(10, 10, 10, 10))
        GridPane.setConstraints(textBox, 1, 1)

        val button = new Button("Help")
        GridPane.setConstraints(button, 2, 1)
        GridPane.setMargin(button, new Insets(10, 10, 10, 10))
        GridPane.setHalignment(button, HPos.CENTER)

        GridPane.setConstraints(condValue, 1, 0)
        grid3.getChildren().addAll(condLabel, condValue, button, acctLabel, textBox)

        vbox.getChildren().addAll(grid3Caption, grid3)

        root.getChildren().add(vbox)

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



