package sample;

import com.sun.istack.internal.FinalArrayList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;

public class AddItem implements Initializable {
    static final ArrayList<MusicItem> musicItems = new ArrayList<MusicItem>();
    static final ArrayList<String> song = new ArrayList<>();
    static final ArrayList<CD> cd = new ArrayList<CD>();
    static final ArrayList<Vinyl> vinyl = new ArrayList<Vinyl>();
    static final ArrayList<String> itemtype =  new ArrayList<>();
    static final ArrayList<LocalDate> sellingDate = new ArrayList<>();
    static final ArrayList<LocalTime> sellingTime = new ArrayList<>();
    static final ArrayList<Integer> itemid = new ArrayList<>();
    static final ArrayList<Integer> spaceleft = new ArrayList<>();
    static final ArrayList<Integer> size = new ArrayList<>();
    static final ArrayList<Double> prices = new ArrayList<>();

    static final ArrayList<String> durations = new ArrayList<>();
    static final ArrayList<String> speeds = new ArrayList<>();
    static final ArrayList<String> diametre = new ArrayList<>();


    @FXML private ComboBox<String> ItemType;
    @FXML private Label dur;
    @FXML private TextField duration;
    @FXML private Label lblSpeed;
    @FXML private TextField speed;
    @FXML private Label lblDiam;
    @FXML private TextField Diam;
    @FXML private TextField space;
    @FXML private TextField itemID;
    @FXML private TextField Title;
    @FXML private TextField Genre;
    @FXML private TextField Artist;
    @FXML private TextField Price;
    @FXML private DatePicker ReleaseDate;
    int start = musicItems.size();
    int count = musicItems.size()+1;
    String tot = "";
    String s = "";
    String d = "";




    public void AddMusics(javafx.event.ActionEvent event){
        try {
            if (ItemType.getValue().equals("CD")) {
                itemtype.add("CD");
                MusicItem Cd = new CD(count, Title.getText(), Genre.getText(), ReleaseDate.getValue(), Artist.getText(), Double.parseDouble(Price.getText()), tot);
                Cd.setTitle(Title.getText());
                Cd.setGenre(Genre.getText());
                Cd.setReleaseDate(ReleaseDate.getValue());
                Cd.setArtist(Artist.getText());
                Cd.setPrice(Double.parseDouble(Price.getText()));
                CD cd1 = new CD(count, Title.getText(), Genre.getText(), ReleaseDate.getValue(), Artist.getText(), Double.parseDouble(Price.getText()), duration.getText());
                cd1.setTotalDuration(duration.getText());
                tot = cd1.getTotalDuration();
                musicItems.add(Cd);
                durations.add(duration.getText());
                speeds.add("");
                diametre.add("");
                cd.add(cd1);
                song.add(duration.getText());
                prices.add(Cd.getPrice());
                sellingDate.add(LocalDate.now());
                sellingTime.add(LocalTime.now());
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Successfuly Added Item CD");
                a.show();
                start =  - start;
                count = 0 + count;
                spaceleft.add(start);
                itemid.add(count);
                size.add(1);

            } else {
                itemtype.add("Vinyl");
                MusicItem Vinyl = new Vinyl(count, Title.getText(), Genre.getText(), ReleaseDate.getValue(), Artist.getText(), Double.parseDouble(Price.getText()), s, d);
                Vinyl.setTitle(Title.getText());
                Vinyl.setGenre(Genre.getText());
                Vinyl.setReleaseDate(ReleaseDate.getValue());
                Vinyl.setArtist(Artist.getText());
                Vinyl.setPrice(Double.parseDouble(Price.getText()));
                Vinyl vinyl1 = new Vinyl(count, Title.getText(), Genre.getText(), ReleaseDate.getValue(), Artist.getText(), Double.parseDouble(Price.getText()), speed.getText(), Diam.getText());
                vinyl1.setSpeed(speed.getText());
                vinyl1.setDiameter(Diam.getText());
                s = vinyl1.getSpeed();
                d = vinyl1.getDiameter();
                musicItems.add(Vinyl);
                durations.add("");
                speeds.add(speed.getText());
                diametre.add(Diam.getText());
                vinyl.add(vinyl1);
                prices.add(Vinyl.getPrice());
                sellingDate.add(LocalDate.now());
                sellingTime.add(LocalTime.now());
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.INFORMATION);
                a.setContentText("Successfuly Added Item Vinyl");
                a.show();
                start = 999 - start;
                count = 0 + count;
                spaceleft.add(start);
                itemid.add(count);
                size.add(2);
                print();
            }
        }catch (Exception ex){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("No Details Written Down To Add the Music...");
            a.show();
        }

    }
    public void BackTo1(javafx.event.ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        space.setText(String.valueOf(1000-count));
        itemID.setText(String.valueOf(0+count));

        ItemType.getItems().addAll("CD","Vinyl");
        ItemType.getSelectionModel().selectedItemProperty().addListener((v, old,neww) -> showResults());

    }

    private void showResults() {
        if(ItemType.getValue().equals("Vinyl")){
            dur.setVisible(false);
            duration.setVisible(false);
            lblDiam.setVisible(true);
            lblSpeed.setVisible(true);
            speed.setVisible(true);
            Diam.setVisible(true);
        }
        else{
            dur.setVisible(true);
            duration.setVisible(true);
            lblDiam.setVisible(false);
            lblSpeed.setVisible(false);
            speed.setVisible(false);
            Diam.setVisible(false);
        }
    }
    public void print(){
        WestminsterStoreManager westminsterStoreManager = new WestminsterStoreManager() {
            private MusicItem musicItem;
            @Override
            public MusicItem getMusicItem() {
                return this.musicItem;
            }

            @Override
            public void setMusicItem(MusicItem musicItem) {
                this.musicItem = musicItem;

            }
        };
    }



}
