package sample;

import java.time.LocalDate;
import java.time.LocalTime;

public class TableView1 {
    public TableView1(String itemType, int itemID, String title, String genre,String songDuration, String speed, String diametre, LocalDate releaseDate, String artist, Double price, Integer spceleft, LocalDate sellingDate, LocalTime sellingTime) {
        ItemType = itemType;
        ItemID = itemID;
        Title = title;
        Genre = genre;
        Speed = speed;
        SongDuration = songDuration;
        Diametre = diametre;
        ReleaseDate = releaseDate;
        Artist = artist;
        this.price = price;
        this.spceleft = spceleft;
        this.sellingDate = sellingDate;
        this.sellingTime = sellingTime;
    }

    public String getItemType() {
        return ItemType;
    }

    public void setItemType(String itemType) {
        ItemType = itemType;
    }

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }


    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public String getDiametre() {
        return Diametre;
    }

    public void setDiametre(String diametre) {
        Diametre = diametre;
    }

    public LocalDate getReleaseDate() {
        return ReleaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        ReleaseDate = releaseDate;
    }

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getSpceleft() {
        return spceleft;
    }

    public void setSpceleft(Integer spceleft) {
        this.spceleft = spceleft;
    }

    public LocalDate getSellingDate() {
        return sellingDate;
    }

    public void setSellingDate(LocalDate sellingDate) {
        this.sellingDate = sellingDate;
    }

    public LocalTime getSellingTime() {
        return sellingTime;
    }

    public void setSellingTime(LocalTime sellingTime) {
        this.sellingTime = sellingTime;
    }

    String ItemType;int ItemID;String Title; String Genre; String SongDuration; String Speed; String Diametre; LocalDate ReleaseDate; String Artist; Double price; Integer spceleft; LocalDate sellingDate; LocalTime sellingTime;
}


