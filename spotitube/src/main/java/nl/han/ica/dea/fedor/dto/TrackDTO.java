package nl.han.ica.dea.fedor.dto;

/**
 * The type Track dto.
 */
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

    /**
     * Sets track.
     *
     * @param id                the id
     * @param title             the title
     * @param performer         the performer
     * @param duration          the duration
     * @param album             the album
     * @param playcount         the playcount
     * @param publication_date  the publication date
     * @param description       the description
     * @param offline_available the offline available
     */
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

    /**
     * Gets id.
     *
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Gets title.
     *
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets title.
     *
     * @param title the title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets performer.
     *
     * @return the performer
     */
    public String getPerformer() {
        return performer;
    }

    /**
     * Sets performer.
     *
     * @param performer the performer
     */
    public void setPerformer(String performer) {
        this.performer = performer;
    }

    /**
     * Gets duration.
     *
     * @return the duration
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Sets duration.
     *
     * @param duration the duration
     */
    public void setDuration(int duration) {
        this.duration = duration;
    }

    /**
     * Gets album.
     *
     * @return the album
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Sets album.
     *
     * @param album the album
     */
    public void setAlbum(String album) {
        this.album = album;
    }

    /**
     * Gets playcount.
     *
     * @return the playcount
     */
    public int getPlaycount() {
        return playcount;
    }

    /**
     * Sets playcount.
     *
     * @param playcount the playcount
     */
    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    /**
     * Gets publication date.
     *
     * @return the publication date
     */
    public String getPublication_date() {
        return publication_date;
    }

    /**
     * Sets publication date.
     *
     * @param publication_date the publication date
     */
    public void setPublication_date(String publication_date) {
        this.publication_date = publication_date;
    }

    /**
     * Gets description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets description.
     *
     * @param description the description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Is offline available boolean.
     *
     * @return the boolean
     */
    public boolean isOffline_available() {
        return offline_available;
    }

    /**
     * Sets offline available.
     *
     * @param offline_available the offline available
     */
    public void setOffline_available(boolean offline_available) {
        this.offline_available = offline_available;
    }
}

