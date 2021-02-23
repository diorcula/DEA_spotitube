package nl.han.ica.dea.fedor.dto;

import java.util.List;

/**
 * The type Playlist dto.
 */
public class PlaylistDTO {
    private int id;
    private String name;
    private boolean owner;
    private List<TrackDTO> tracks;
    private int duration;

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
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Is owner boolean.
     *
     * @return the boolean
     */
    public boolean isOwner() {
        return owner;
    }

    /**
     * Sets owner.
     *
     * @param owner the owner
     */
    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    /**
     * Gets tracks.
     *
     * @return the tracks
     */
    public List<TrackDTO> getTracks() {
        return tracks;
    }

    /**
     * Sets tracks.
     *
     * @param tracks the tracks
     */
    public void setTracks(List<TrackDTO> tracks) {
        this.tracks = tracks;
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
     * Get duration int.
     *
     * @return the int
     */
    public int getDuration(){
        return duration;
    }
}
