package GeneralLedger;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import java.io.IOException;


public class MainMenuController {

    public TextField selectedClientTextField;

    public void clientSelectClick() {



        try{
            FXMLLoader loader = new FXMLLoader(getClass().getResource("clientMenu.fxml"));
            Parent clientWindowScene = loader.load();
            Stage clientWindow = new Stage();
            ClientMenuController controller = loader.getController();
            controller.setMainWindow(this);
            clientWindow.setTitle("Client Menu");
            clientWindow.setScene(new Scene(clientWindowScene));
            clientWindow.show();

            selectedClientTextField.textProperty().addListener(new ChangeListener<String>() {
                @Override
                public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
                    clientWindow.close();
                }
            });

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}






