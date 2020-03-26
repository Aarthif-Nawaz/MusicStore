package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.ResourceBundle;

public class SortItem implements Initializable {
    @FXML
    private javafx.scene.control.TableView<TableView1> table;
    @FXML private TableColumn<TableView1, String> ItemType;
    @FXML private TableColumn<sample.TableView1, Integer>ItemID;
    @FXML private TableColumn<sample.TableView1, String> Title;
    @FXML private TableColumn<sample.TableView1, String> Genre;
    @FXML private TableColumn<sample.TableView1, String> SongDuration;
    @FXML private TableColumn<sample.TableView1, String> Speed;
    @FXML private TableColumn<sample.TableView1, String> Diametre;
    @FXML private TableColumn<sample.TableView1, LocalDate> ReleaseDate;
    @FXML private TableColumn<sample.TableView1, String> Artist;
    @FXML private TableColumn<sample.TableView1, Double> Price;
    @FXML private TableColumn<sample.TableView1, String> Space;
    @FXML private TableColumn<sample.TableView1, LocalDate> SellDate;
    @FXML private TableColumn<sample.TableView1, LocalTime> SellTime;

    public ObservableList<TableView1> getItemList(){
        ObservableList<sample.TableView1> Musicitems = FXCollections.observableArrayList();
        ArrayList<String> check = new ArrayList<>();
        String first_title = "";
        String outcome = "";
        int index = 0;
        for(int i=0;i<AddItem.musicItems.size();i++){
            outcome = AddItem.musicItems.get(i).getTitle().substring(0,1).toUpperCase()+AddItem.musicItems.get(i).getTitle().substring(1);
            check.add(outcome);
        }

        Collections.sort(check);
        for(int j=0;j<check.size();j++){
            first_title = check.get(j);
            for(int k=0;k<AddItem.musicItems.size();k++){
                if(first_title.equals(AddItem.musicItems.get(k).getTitle().substring(0,1).toUpperCase()+AddItem.musicItems.get(k).getTitle().substring(1))){
                    index = k;
                    if(AddItem.itemtype.get(index).equals("CD")){
                        Musicitems.add(new sample.TableView1(AddItem.itemtype.get(index),AddItem.itemid.get(index),AddItem.musicItems.get(index).getTitle(),AddItem.musicItems.get(index).getGenre(),AddItem.durations.get(index),"","",AddItem.musicItems.get(index).getReleaseDate(),AddItem.musicItems.get(index).getArtist(),AddItem.musicItems.get(index).getPrice(),AddItem.spaceleft.get(index),AddItem.sellingDate.get(index),AddItem.sellingTime.get(index)));
                    }
                    else{
                        Musicitems.add(new sample.TableView1(AddItem.itemtype.get(index),AddItem.itemid.get(index),AddItem.musicItems.get(index).getTitle(),AddItem.musicItems.get(index).getGenre(),"",AddItem.speeds.get(index),AddItem.diametre.get(index),AddItem.musicItems.get(index).getReleaseDate(),AddItem.musicItems.get(index).getArtist(),AddItem.musicItems.get(index).getPrice(),AddItem.spaceleft.get(index),AddItem.sellingDate.get(index),AddItem.sellingTime.get(index)));
                    }
                }
            }
        }


        return Musicitems;


    }

    public void MainPage(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ItemType.setCellValueFactory(new PropertyValueFactory<>("itemType"));
        ItemID.setCellValueFactory(new PropertyValueFactory<>("itemID"));
        Title.setCellValueFactory(new PropertyValueFactory<>("title"));
        Genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        SongDuration.setCellValueFactory(new PropertyValueFactory<>("songDuration"));
        Speed.setCellValueFactory(new PropertyValueFactory<>("speed"));
        Diametre.setCellValueFactory(new PropertyValueFactory<>("diametre"));
        ReleaseDate.setCellValueFactory(new PropertyValueFactory<>("releaseDate"));
        Artist.setCellValueFactory(new PropertyValueFactory<>("artist"));
        Price.setCellValueFactory(new PropertyValueFactory<>("price"));
        Space.setCellValueFactory(new PropertyValueFactory<>("spceleft"));
        SellDate.setCellValueFactory(new PropertyValueFactory<>("sellingDate"));
        SellTime.setCellValueFactory(new PropertyValueFactory<>("sellingTime"));

        table.setItems(getItemList());

    }
}
