package sample;

import java.time.LocalDate;

public class CD extends MusicItem{
    private int itemID;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String artist;
    private Double price;

    public String getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(String totalDuration) {
        this.totalDuration = totalDuration;
    }

    private String totalDuration;

    public CD(int itemID, String title, String genre, LocalDate releaseDate, String artist, Double price, String Duration) {
        super(itemID, title, genre, releaseDate, artist, price);
        this.totalDuration = Duration;
    }




    @Override
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }



    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public int getItemID() {
        return this.itemID;
    }

    @Override
    public String getTitle() {
        return this.title;
    }

    @Override
    public String getGenre() {
        return this.genre;
    }

    @Override
    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    @Override
    public String getArtist() {
        return this.artist;
    }

    @Override
    public Double getPrice() {
        return this.price;
    }
}
