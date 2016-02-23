package GeneralLedger;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class MainMenuController {

    public TextField selectedClientTextField;

    public void clientSelectClicked() {

        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("fxml/clientMenu.fxml"));
            Parent clientWindowScene = loader.load();
            Stage clientWindow = new Stage();
            ClientMenuController controller = loader.getController();
            controller.setMainWindow(this);
            clientWindow.setTitle("Client Menu");
            clientWindow.setScene(new Scene(clientWindowScene));
            clientWindow.show();

            selectedClientTextField.textProperty().addListener((observable, oldValue, newValue) -> {
                    clientWindow.close();
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}






