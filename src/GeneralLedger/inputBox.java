package GeneralLedger;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class InputBox {

    static String input;

    public static String display(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(400);
        window.setMinHeight(175);

        Label label = new Label(message);
        TextField inputTextField = new TextField();
        Button submitButton = new Button("Submit");

        inputTextField.setMinWidth(300);

        submitButton.setOnAction(e -> {
            input = inputTextField.getText();
            window.close();
        });

        VBox vboxLayout = new VBox(10);
        HBox hboxLayout = new HBox(10);

        hboxLayout.getChildren().addAll(inputTextField, submitButton);
        vboxLayout.getChildren().addAll(label, hboxLayout);

        hboxLayout.setAlignment(Pos.CENTER);
        vboxLayout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(vboxLayout);
        window.setScene(scene);
        window.showAndWait();

        return input;

    }

}
