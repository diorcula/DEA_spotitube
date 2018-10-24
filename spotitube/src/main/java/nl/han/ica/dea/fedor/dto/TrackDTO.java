package nl.han.ica.dea.fedor.dto;

public class TrackDTO {
    private int id;
    private String title;
    private String performer;
    private int duration;
    private String album;
    private int playcount;
    private String publication_date;
    private String description;
    private boolean offline_available;

    public void setTrack(int id,String title,String performer,int duration,String album, int playcount, String publication_date, String description, boolean offline_available) {
        setId(id);
        setTitle(title);
        setPerformer(performer);
        setDuration(duration);
        setAlbum(album);
        setPlaycount(playcount);
        setPublication_date(publication_date);
        setDescription(description);
        setOffline_available(offline_available);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPerformer() {
        return performer;
    }

    public void setPerformer(String performer) {
        this.performer = performer;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public String getPublication_date() {
        return publication_date;
    }

    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOffline_available() {
        return offline_available;
    }

    public void setOffline_available(boolean offline_available) {
        this.offline_available = offline_available;
    }
}

