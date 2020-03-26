package sample;
import java.time.LocalDate;


public class Vinyl extends MusicItem {
    private int itemID;
    private String title;
    private String genre;
    private LocalDate releaseDate;
    private String artist;
    private Double price;
    public String getSpeed() {
        return Speed;
    }

    public void setSpeed(String speed) {
        Speed = speed;
    }

    public String getDiameter() {
        return Diameter;
    }

    public void setDiameter(String diameter) {
        Diameter = diameter;
    }

    private String Speed;
    private String Diameter;

    public Vinyl(int itemID, String title, String genre, LocalDate releaseDate, String artist, Double price, String speed, String diameter) {
        super(itemID, title, genre, releaseDate, artist, price);
        this.Speed = speed;
        this.Diameter = diameter;
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
