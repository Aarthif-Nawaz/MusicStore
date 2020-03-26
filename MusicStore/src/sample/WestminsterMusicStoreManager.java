package sample;

public class WestminsterMusicStoreManager implements WestminsterStoreManager {
    private MusicItem MusicItem;
    @Override
    public MusicItem getMusicItem() {
        return MusicItem;
    }

    @Override
    public void setMusicItem(MusicItem musicItem) {
        this.MusicItem = musicItem;
    }
}
