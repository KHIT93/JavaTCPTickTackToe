package UI;

import Models.Gameboard;
import Models.Interfaces.IGameFigure;
import Models.Interfaces.IGameboard;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable
{
    @FXML
    private GridPane layout;

    private Gameboard gameboard;

    @FXML
    private TextArea logarea;

    public Controller()
    {
    }


    @Override
    public void initialize(URL location, ResourceBundle resources)
    {
        //this.layout.setPrefSize(600, 600);
        this.gameboard = new Gameboard();
        this.createContent();
        this.logarea.setText("Output log here...");


    }

    private Gameboard getGameboard()
    {
        return this.gameboard;
    }


    private void createContent() {
        this.layout.setPrefSize(600, 600);
        this.layout.setAlignment(Pos.TOP_LEFT);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Tile tile = new Tile(i, j, this.gameboard);
                Tile tile = new Tile(i, j);
                tile.setTranslateX(j * 200);
                tile.setTranslateY(i * 200);

                this.layout.getChildren().add(tile);
            }
        }

        //return layout;
    }

    private class Tile extends StackPane
    {
        private Text text = new Text();
        private int coordinate_x;
        private int coordinate_y;

        public Tile(int x, int y)
        {
            this.coordinate_x = x;
            this.coordinate_y = y;
            Rectangle border = new Rectangle(200, 200);
            border.setFill(null);
            border.setStroke(Color.BLACK);

            text.setFont(Font.font(72));

            setAlignment(Pos.CENTER);
            getChildren().addAll(border, text);

            setOnMouseClicked(event ->
            {
                if(!getGameboard().isPlayable())
                {
                    return;
                }
                if (event.getButton() == MouseButton.PRIMARY)
                {
                    getGameboard().place_figure(getGameboard().getCurrentPlayer().getFigure(), this.coordinate_x, this.coordinate_y);

                    this.text.setText(getGameboard().getCurrentPlayer().place_figure());
                }
            });
        }

        public double getCenterX()
        {
            return getTranslateX() + 100;
        }

        public double getCenterY()
        {
            return getTranslateY() + 100;
        }

        public String getValue()
        {
            return text.getText();
        }

    }
}
