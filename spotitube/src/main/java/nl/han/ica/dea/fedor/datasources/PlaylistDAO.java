package nl.han.ica.dea.fedor.datasources;

import nl.han.ica.dea.fedor.datasources.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlaylistDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
    private DatabaseProperties databaseProperties;

    public PlaylistDAO() {
        databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    public List<PlaylistBuilderDTO> findAll() {
        List<PlaylistBuilderDTO> playlists = new ArrayList<>();
        tryFindAll(playlists,"SELECT * from playlists");
        return playlists;
    }

    public PlaylistBuilderDTO findOne(int id){
        List<PlaylistBuilderDTO> playlists = new ArrayList<>();
        tryFindAll(playlists,"SELECT * from playlists WHERE id = " + id );

        return playlists.get(0);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    private void tryFindAll(List<PlaylistBuilderDTO> playlists, String query) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(),databaseProperties.connectionUSER(),databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement(query);
            addNewItemsFromDatabase(playlists, statement);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    private void addNewItemsFromDatabase(List<PlaylistBuilderDTO> playlists, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromResultSet(playlists, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<PlaylistBuilderDTO> playlists, ResultSet resultSet) throws SQLException {
        PlaylistBuilderDTO playlist = new PlaylistBuilderDTO();
        playlist.setId(resultSet.getInt("id"));
        playlist.setName(resultSet.getString("name"));
        playlist.setOwner(resultSet.getBoolean("owner"));

        playlists.add(playlist);
    }

    public Object editPlaylist(PlaylistBuilderDTO playlistBuilderDTO, int id) {
        
    }
}