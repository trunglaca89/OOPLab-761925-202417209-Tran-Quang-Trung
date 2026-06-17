package hust.soict.globalict.javafx;

import javafx.fxml.FXML;
import javafx.scene.control.RadioButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class PainterController {

    @FXML private Pane drawingAreaPane;
    @FXML private RadioButton penRadioButton;
    @FXML private RadioButton eraserRadioButton;

    @FXML
    private void drawingAreaMouseDragged(MouseEvent event) {
        Circle circle = new Circle(event.getX(), event.getY(), 4);
        if (eraserRadioButton.isSelected()) {
            circle.setFill(Color.WHITE);
        } else {
            circle.setFill(Color.BLACK);
        }
        drawingAreaPane.getChildren().add(circle);
    }

    @FXML
    private void clearButtonPressed() {
        drawingAreaPane.getChildren().clear();
    }
}
