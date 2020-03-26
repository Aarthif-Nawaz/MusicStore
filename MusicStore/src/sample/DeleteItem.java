package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class DeleteItem implements Initializable{
    ArrayList<Integer> num = new ArrayList<>();
    @FXML private TextField space;
    @FXML private Label msg;
    @FXML private ComboBox<Integer> itemID;

    public void DeleteMusics(ActionEvent event){
        try {
            int index = AddItem.itemid.indexOf(itemID.getValue());
            String value = AddItem.itemtype.get(index);
            msg.setText("The Selected Item Was a " + value);
            AddItem.itemtype.remove(index);
            AddItem.musicItems.remove(index);
            AddItem.itemid.remove(index);
            AddItem.spaceleft.remove(index);
            AddItem.sellingDate.remove(index);
            AddItem.sellingTime.remove(index);
            if (value.equals("CD")) {
                AddItem.cd.remove(index);
            } else {
                AddItem.vinyl.remove(index);
            }
            int ans = Integer.parseInt(space.getText()) + 1;
            space.setText(String.valueOf(ans));
        }catch (Exception ex){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("No Value Selected To Delete...");
            a.show();
        }


    }
    public void MainPage(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        for(int i : AddItem.itemid){
            itemID.getItems().addAll(i);
            num.add(i);
        }
        if(num.size()==0){
            space.setText(String.valueOf(1000));
        }
        else{
            space.setText(String.valueOf(1000-num.size()));
        }
    }
}
