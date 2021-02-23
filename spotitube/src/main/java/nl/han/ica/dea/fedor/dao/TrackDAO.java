package nl.han.ica.dea.fedor.dao;

import nl.han.ica.dea.fedor.dao.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.TrackDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Track dao.
 */
public class TrackDAO {
    private final Logger logger = Logger.getLogger(getClass().getName());
    private final DatabaseProperties databaseProperties;

    /**
     * Instantiates a new Track dao.
     */
    public TrackDAO() {
        databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    /**
     * Find all list.
     *
     * @param id the id
     * @return the list
     */
    public List<TrackDTO> findAll(int id) {

        List<TrackDTO> tracks = null;

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("select * from tracks  WHERE tracks.id NOT IN (SELECT track_id FROM playliststracks WHERE playlist_id =?)");
            statement.setInt(1, id);

            statement.executeQuery();
            tracks = getAllTracks(statement);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return tracks;
    }

    /**
     * Find tracks from playlist list.
     *
     * @param id the id
     * @return the list
     */
    public List<TrackDTO> findTracksFromPlaylist(int id) {
        List<TrackDTO> tracksFromPlaylist = null;

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement("select * from playliststracks join tracks on playliststracks.track_id = tracks.id where playliststracks.playlist_id =?");
            statement.setInt(1, id);

            tracksFromPlaylist = getAllTracks(statement);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return tracksFromPlaylist;

    }

    private TrackDTO mapToTrackDTO(ResultSet resultSet) throws SQLException {
        TrackDTO trackDTO = new TrackDTO();
        trackDTO.setId(resultSet.getInt("id"));
        trackDTO.setTitle(resultSet.getString("title"));
        trackDTO.setPerformer(resultSet.getString("performer"));
        trackDTO.setDuration(resultSet.getInt("duration"));
        trackDTO.setAlbum(resultSet.getString("album"));
        trackDTO.setPlaycount(resultSet.getInt("playcount"));
        trackDTO.setPublication_date(resultSet.getString("publication_date"));
        trackDTO.setDescription(resultSet.getString("description"));
        trackDTO.setOffline_available(resultSet.getBoolean("offline_available"));

        return trackDTO;
    }

    private List<TrackDTO> getAllTracks(PreparedStatement statement) throws SQLException {
        List<TrackDTO> tracks = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            tracks.add(mapToTrackDTO(resultSet));
        }
        return tracks;
    }

    /**
     * Delete track.
     *
     * @param id       the id
     * @param track_id the track id
     */
    public void deleteTrack(int id, int track_id) {

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("delete from playliststracks where playlist_id = ? and track_id = ?");
            statement.setInt(1, id);
            statement.setInt(2, track_id);
            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    /**
     * Add track.
     *
     * @param id       the id
     * @param trackDTO the track dto
     */
    public void addTrack(int id, TrackDTO trackDTO) {
        int track_id = trackDTO.getId();

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("insert into playliststracks(playlist_id, track_id) values (?,?)");
            statement.setInt(1, id);//1 specifies the first parameter in the query i.e. name
            statement.setInt(2, track_id);

            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }
}
