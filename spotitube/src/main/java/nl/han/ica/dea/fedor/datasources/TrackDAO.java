package nl.han.ica.dea.fedor.datasources;

import nl.han.ica.dea.fedor.datasources.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;
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
        List<TrackBuilderDTO> tracks = new ArrayList<>();
        tryFindAll(tracks, "SELECT * from tracks");
        return tracks;
    }

    public List<TrackBuilderDTO> findTracksFromPlaylist(int id){
        List<TrackBuilderDTO> tracks = new ArrayList<>();
        tryFindAll(tracks, "SELECT * from tracks ietsjes anders");
        return tracks;
    }

    private void tryFindAll(List<TrackBuilderDTO> tracks, String query) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(),databaseProperties.connectionUSER(),databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement(query);
            addNewItemsFromDatabase(tracks, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    private void addNewItemFromResultSet(List<TrackBuilderDTO> tracks, ResultSet resultSet) throws SQLException {
        TrackBuilderDTO trackBuilderDTO = new TrackBuilderDTO();
      // trackBuilderDTO.set
        // hier moet alles geset worden met data uit de database
        tracks.add(trackBuilderDTO);

    }

    private void addNewItemsFromDatabase(List<TrackBuilderDTO> tracks, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromResultSet(tracks, resultSet);
        }
    }

}
