package nl.han.ica.dea.fedor.datasources;

import nl.han.ica.dea.fedor.datasources.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.TrackBuilderDTO;

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

    public List<TrackBuilderDTO> findAll() {
        List<TrackBuilderDTO> tracks = tryFindAll("SELECT * from tracks");
        return tracks;
    }

    public List<TrackBuilderDTO> findTracksFromPlaylist(int id) {
        List<TrackBuilderDTO> tracks = tryFindAll(
                "SELECT * " +
                        "FROM playlist_track " +
                        "JOIN tracks ON playlist_track.track_id = tracks.id " +
                        "WHERE playlist_track.playlist_id = " + id);

        return tracks;
    }

    private List<TrackBuilderDTO> tryFindAll(String query) {
        List<TrackBuilderDTO> allTracks;
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement(query);
            allTracks = getAllTracks(statement);
            statement.close();
            connection.close();

        } catch (SQLException e) {
            allTracks = new ArrayList<>();
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return allTracks;
    }

    private TrackBuilderDTO mapToTrackDTO(ResultSet resultSet) throws SQLException {
        TrackBuilderDTO trackBuilderDTO = new TrackBuilderDTO();
        trackBuilderDTO.setId(resultSet.getInt("track_id"));
        trackBuilderDTO.setTitle(resultSet.getString("title"));
        trackBuilderDTO.setPerformer(resultSet.getString("performer"));
        trackBuilderDTO.setDuration(resultSet.getInt("duration"));
        trackBuilderDTO.setAlbum(resultSet.getString("album"));
        trackBuilderDTO.setPlaycount(resultSet.getInt("playcount"));
        trackBuilderDTO.setPublication_date(resultSet.getString("publication_date"));
        trackBuilderDTO.setDescription(resultSet.getString("description"));
        trackBuilderDTO.setOffline_available(resultSet.getBoolean("offline_available"));

        return trackBuilderDTO;
    }

    private List<TrackBuilderDTO> getAllTracks(PreparedStatement statement) throws SQLException {
        List<TrackBuilderDTO> tracks = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            tracks.add(mapToTrackDTO(resultSet));
        }

        return tracks;
    }
}
