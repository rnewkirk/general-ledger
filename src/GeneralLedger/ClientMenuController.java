package GeneralLedger;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
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

        File file = new File("data/clientList.txt");

        //check file before reading
        if(!file.isFile()) {
            File dir = new File("data");

            try{
                //file missing, check directory before creating file
                if(!dir.exists()){
                    dir.mkdir();
                }
                FileWriter fw = new FileWriter(file);
                fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        String line;
        ObservableList<String> clients = FXCollections.observableArrayList();

        try {
            FileReader fileReader =
                    new FileReader(file);

            BufferedReader bufferedReader =
                    new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
                clients.add(line);
            }

            bufferedReader.close();
        }
        catch(IOException e) {
            e.printStackTrace();
        }

        FXCollections.sort(clients);
        return clients;
    }

    //Actions
    public void newClientClicked(){
        String newClient = "";
        newClient = InputBox.display("New Client Creation", "Please enter the client's name.");

        //check if new client is duplicate before adding new client
        boolean duplicateCheck = false;
        ObservableList<String> clients = getClientList();

        for (String client : clients) {
            if (client.equalsIgnoreCase(newClient)) {
                duplicateCheck = true;
                break;
            } else {
                duplicateCheck = false;
            }
        }

        if (!duplicateCheck && !newClient.equals("")) {
            File file = new File("data/clientList.txt");

            try {
                FileWriter fw = new FileWriter(file,true);
                fw.write(newClient+"\n");
                fw.close();
                clientList.setItems(getClientList());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
    public void copyClientClicked(){

    }
    public void deleteClientClicked(){


    }
}
