package GeneralLedger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ClientMenuController implements Initializable{

    private MainMenuController mainWindow;

    public ListView<String> clientList;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clientSelectDetection();
        clientList.setItems(getClientList());
    }

    public void setMainWindow(MainMenuController mainWindow){
        this.mainWindow = mainWindow;
    }

    public void clientSelectDetection() {

        clientList.setOnMouseClicked((click) ->  {
            if (click.getClickCount() == 2) {
                mainWindow.selectedClientTextField.setText(clientList.getSelectionModel().getSelectedItem());
            }
        });
    }

    public ObservableList<String> getClientList() {

        String fileName = "data/clientList.txt";
        String line;
        ObservableList<String> clients = FXCollections.observableArrayList();

        try {
            FileReader fileReader =
                    new FileReader(fileName);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                clients.add(line);
            }

            bufferedReader.close();
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }

        FXCollections.sort(clients);
        return clients;
    }

}
