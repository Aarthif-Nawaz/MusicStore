package sample;


import java.time.LocalDate;

public abstract class MusicItem {
    private int itemID;
    private String Title;
    private String Genre;
    private LocalDate ReleaseDate;
    private String Artist;
    private Double Price;

    public MusicItem(int itemID, String title, String genre, LocalDate releaseDate, String artist, Double price) {
        this.itemID = itemID;
        this.Title = title;
        this.Genre = genre;
        this.ReleaseDate = releaseDate;
        this.Artist = artist;
        this.Price = price;
    }


    public abstract void setItemID(int itemID);
    public abstract void setTitle(String title);
    public abstract void setGenre(String genre);
    public abstract void setReleaseDate(LocalDate releaseDate);
    public abstract void setArtist(String artist);
    public abstract void setPrice(Double price);

    public abstract int getItemID();
    public abstract String getTitle();
    public abstract String getGenre();
    public abstract LocalDate getReleaseDate();
    public abstract String getArtist();
    public abstract Double getPrice();



}
