package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BuyItem implements Initializable{
    static final ArrayList<Integer> CDCOPIES = new ArrayList<>();
    static final ArrayList<Integer> VINYLCOPIES = new ArrayList<>();
    @FXML private ComboBox<Integer> itemID;
    @FXML private TextField copies;
    @FXML private TextField total;
    String ans = "";
    double tot = 0;

    public void BuyMusics(ActionEvent event){
        try {
            int value = itemID.getValue();
            int index = AddItem.itemid.indexOf(value);
            String item = AddItem.itemtype.get(index);
            if (item.equals("CD")) {
                ans = copies.getText();
                CDCOPIES.add(Integer.parseInt(ans));
                tot = AddItem.prices.get(index) * Integer.parseInt(ans);
                total.setText(String.valueOf(tot));
            } else {
                ans = copies.getText();
                VINYLCOPIES.add(Integer.parseInt(ans));
                tot = AddItem.prices.get(index) * Integer.parseInt(ans);
                total.setText(String.valueOf(tot));

            }
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("You Have Successfully Purchased " + item + " Which is priced at " + total.getText() + " For " + ans + " Copies");
            a.show();
        }catch (Exception ex){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("No Value Selected To Buy Items from the Music Store...");
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
        }
    }
}
