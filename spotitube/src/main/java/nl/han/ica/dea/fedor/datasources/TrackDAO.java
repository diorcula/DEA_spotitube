package nl.han.ica.dea.fedor.datasources;

import nl.han.ica.dea.fedor.datasources.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.TrackDTO;

import javax.inject.Inject;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TrackDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
    private DatabaseProperties databaseProperties;

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

    public List<TrackDTO> findAll(int id) {

        List<TrackDTO> tracks;
        String query = "select * from tracks  WHERE tracks.id NOT IN (SELECT track_id FROM playlist_track WHERE playlist_id = " + id + ")";
        tracks = tryFindAll(query);

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement(query);
            statement.executeQuery();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return tracks;
    }

    public List<TrackDTO> findTracksFromPlaylist(int id) {

        return tryFindAll(
                "SELECT * " +
                        "FROM playlist_track " +
                        "JOIN tracks ON playlist_track.track_id = tracks.id " +
                        "WHERE playlist_track.playlist_id = " + id);

    }

    private List<TrackDTO> tryFindAll(String query) {
        List<TrackDTO> allTracks = null;
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement(query);

            allTracks = getAllTracks(statement);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return allTracks;
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

    public void deleteTrack(int id, int track_id) {
        String query = "DELETE FROM playlist_track WHERE playlist_id = " + id + " AND track_id = " + track_id;

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    public void addTrack(int id, TrackDTO trackDTO) {

        int track_id = trackDTO.getId();

        String query = "INSERT INTO playlist_track(playlist_id, track_id)\n" +
                "VALUES\n" +
                "(" + id + "," + track_id + ")";

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement(query);
            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }
}
