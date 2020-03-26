package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class MainView implements Initializable {
    ArrayList<Integer> counts =new ArrayList<Integer>();
    ArrayList<Integer> value = new ArrayList<>();

    private double xOffset = 0;
    private double yOffset = 0;

    @FXML private TableView<sample.TableView> table;
    @FXML private TableColumn<sample.TableView, String> ItemType;
    @FXML private TableColumn<sample.TableView, Integer>ItemID;
    @FXML private TableColumn<sample.TableView, String> Title;
    @FXML private TableColumn<sample.TableView, String> Genre;
    @FXML private TableColumn<sample.TableView, String> SongDuration;
    @FXML private TableColumn<sample.TableView, String> Speed;
    @FXML private TableColumn<sample.TableView, String> Diametre;
    @FXML private TableColumn<sample.TableView, LocalDate> ReleaseDate;
    @FXML private TableColumn<sample.TableView, String> Artist;
    @FXML private TableColumn<sample.TableView, Double> Price;
    @FXML private TableColumn<sample.TableView, String> Space;
    @FXML private TableColumn<sample.TableView, LocalDate> SellDate;
    @FXML private TableColumn<sample.TableView, LocalTime> SellTime;
    @FXML private TextField searchBar;



    public ObservableList<sample.TableView> getItemList(){
        ObservableList<sample.TableView> Musicitems = FXCollections.observableArrayList();
        int i=0;
        for(MusicItem musicItem:AddItem.musicItems){

                if (AddItem.itemtype.get(i).equals("CD")) {
                    Musicitems.add(new sample.TableView(AddItem.itemtype.get(i), AddItem.itemid.get(i), musicItem.getTitle(), musicItem.getGenre(), AddItem.durations.get(i), "", "", musicItem.getReleaseDate(), musicItem.getArtist(), musicItem.getPrice(), AddItem.spaceleft.get(i), AddItem.sellingDate.get(i), AddItem.sellingTime.get(i)));
                } else {
                    Musicitems.add(new sample.TableView(AddItem.itemtype.get(i), AddItem.itemid.get(i), musicItem.getTitle(), musicItem.getGenre(), "", AddItem.speeds.get(i), AddItem.diametre.get(i), musicItem.getReleaseDate(), musicItem.getArtist(), musicItem.getPrice(), AddItem.spaceleft.get(i), AddItem.sellingDate.get(i), AddItem.sellingTime.get(i)));

                }
                i += 1;

        }


        return Musicitems;


    }



    public void Add(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddItem.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void Delete(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("DeleteItem.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void PrintMusic(ActionEvent event){
        for(int i=0;i<AddItem.musicItems.size();i++){
            System.out.println();
            System.out.print("Item ID" + "     "+"Item Type"+"     "+"Title");
            System.out.println();
            System.out.print(AddItem.itemid.get(i)+"            "+AddItem.itemtype.get(i)+"            "+AddItem.musicItems.get(i).getTitle());
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Successfully Printed Details On Screen");
            a.show();
        }

    }
    public void SortMusic(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("SortItem.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void BuyMusic(ActionEvent event) throws IOException {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("BuyItem.fxml"));
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset);
                primaryStage.setY(event.getScreenY() - yOffset);
            }
        });

        Scene scene = new Scene(root);
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public void GenerateReport(ActionEvent event) throws IOException, InterruptedException {
        BufferedWriter writer = new BufferedWriter(new FileWriter("C://Java Programmes//src//MusicStore//src//sample//Items.txt"));
        writer.write("Title"+"      "+"Item ID"+"       "+"Price"+"       "+"Selling Date"+"        "+"Selling Time ");
        writer.newLine();
        for(int i=0;i<AddItem.size.size();i++){
            writer.append(AddItem.musicItems.get(i).getTitle()+"      "+AddItem.itemid.get(i)+"       "+AddItem.musicItems.get(i).getPrice()+"       "+AddItem.sellingDate.get(i)+"        "+AddItem.sellingTime.get(i)+"\n");
            writer.newLine();
        }
        writer.close();
        TimeUnit.SECONDS.sleep(2);
        Alert a = new Alert(Alert.AlertType.NONE);
        a.setAlertType(Alert.AlertType.INFORMATION);
        a.setContentText("Successfuly Generated Report...");
        a.show();

    }
    public void RequestCopies(ActionEvent event){
        try {
            int num = 0;
            int count = 0;//Initialize the variables
            for (int i = 0; i < BuyItem.CDCOPIES.size(); i++) {//Run through a for loop step by step
                num = BuyItem.CDCOPIES.get(i);//Store the first Value from the for loop in varibale num
                for (int j = 0; j < BuyItem.CDCOPIES.size(); j++) {//Run through the for loop again to check every possibilty if the num is equal to any of the number in forloop
                    if (num == BuyItem.CDCOPIES.get(j)) {//if num is equal to one of the elemnts in the forloop
                        count += 1;//increase the count by 1
                    }
                }
                counts.add(count);//Add the total count for that particular element in the counts array
                value.add(num);//add the particular number which has more occurences meaning that value that has most amount of copies bought
                count = 0;//initialize the count to 0 again for that next iteration
            }
            int maximum = Collections.max(counts);//get the maximum from the counts
            int index = counts.indexOf(maximum);//get the index of that maximum number
            int getValue = value.get(index);//get the number of copies which has the most amount of buys
            System.out.print("The Number of Copies Recommended For CD : " + getValue);//print the value :- Therefore it will print on the screen the most amount of copies bought and tell the store to add that number of copies to that store , if the value is a very minimal value then the store should discard that particular item because no one is willing to buy them excpet for a few
            counts.clear();
            value.clear();
            //Same concept applies for the Vinyl buying aslo
            int max1 = 0, count1 = 0;
            for (int i = 0; i < BuyItem.VINYLCOPIES.size(); i++) {
                int num1 = BuyItem.VINYLCOPIES.get(i);
                for (int j = 0; j < BuyItem.VINYLCOPIES.size(); j++) {
                    if (num1 == BuyItem.VINYLCOPIES.get(j)) {
                        count1 += 1;
                    }
                }
                counts.add(count1);
                value.add(num1);
                count1 = 0;
            }
            int maximum1 = Collections.max(counts);
            int index1 = counts.indexOf(maximum1);
            int getValue1 = value.get(index1);
            System.out.println();
            System.out.print("The Number Of Copies Recommended For Vinyl : "+getValue1);
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("Successfuly Printed The Recommended Copies On the Screen...");
            a.show();
        }catch (Exception ex){
            Alert a = new Alert(Alert.AlertType.NONE);
            a.setAlertType(Alert.AlertType.INFORMATION);
            a.setContentText("No Element was Purchased from the Music Store...");
            a.show();

        }


    }
    public void MainPage(ActionEvent event){
        ((Node)event.getSource()).getScene().getWindow().hide();

    }
    public void SearchTitle(ActionEvent event){
        getItemList().clear();
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

        table.setItems(getTitle());


    }
    public void Refresh(ActionEvent event){
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
    public ObservableList<sample.TableView> getTitle(){
        ObservableList<sample.TableView> Musicitems = FXCollections.observableArrayList();
        String search = searchBar.getText();
        for(int i=0;i<AddItem.musicItems.size();i++){
            if(AddItem.musicItems.get(i).getTitle().equals(search)){
                int index = i;
                if(AddItem.itemtype.get(index).equals("CD")){
                    Musicitems.add(new sample.TableView(AddItem.itemtype.get(index),AddItem.itemid.get(index),AddItem.musicItems.get(index).getTitle(),AddItem.musicItems.get(index).getGenre(),AddItem.durations.get(index),"","",AddItem.musicItems.get(index).getReleaseDate(),AddItem.musicItems.get(index).getArtist(),AddItem.musicItems.get(index).getPrice(),AddItem.spaceleft.get(index),AddItem.sellingDate.get(index),AddItem.sellingTime.get(index)));
                }
                else{
                    Musicitems.add(new sample.TableView(AddItem.itemtype.get(index),AddItem.itemid.get(index),AddItem.musicItems.get(index).getTitle(),AddItem.musicItems.get(index).getGenre(),"",AddItem.speeds.get(index),AddItem.diametre.get(index),AddItem.musicItems.get(index).getReleaseDate(),AddItem.musicItems.get(index).getArtist(),AddItem.musicItems.get(index).getPrice(),AddItem.spaceleft.get(index),AddItem.sellingDate.get(index),AddItem.sellingTime.get(index)));
                }
            }
        }
        return Musicitems;
    }
}
