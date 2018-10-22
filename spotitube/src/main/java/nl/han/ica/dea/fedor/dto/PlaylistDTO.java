package nl.han.ica.dea.fedor.dto;

public class PlaylistDTO {
    private int id;
    private String name;
    private boolean owner;
    private int[] tracks;

    public void setPlaylist(int id, String name, boolean owner, int[] tracks) {
        setId(id);
        setName(name);
        setOwner(owner);
        setTracks(tracks);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isOwner() {
        return owner;
    }

    public void setOwner(boolean owner) {
        this.owner = owner;
    }

    public int[] getTracks() {
        return tracks;
    }

    public void setTracks(int[] tracks) {
        this.tracks = tracks;
    }

}
