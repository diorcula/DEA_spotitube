package nl.han.ica.dea.fedor.dao;

import nl.han.ica.dea.fedor.dao.Properties.DatabaseProperties;
import nl.han.ica.dea.fedor.dto.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The type Playlist dao.
 */
public class PlaylistDAO {
    private Logger logger = Logger.getLogger(getClass().getName());
    private DatabaseProperties databaseProperties;

    /**
     * Instantiates a new Playlist dao.
     */
    public PlaylistDAO() {
        databaseProperties = new DatabaseProperties();
        tryLoadJdbcDriver(databaseProperties);
    }

    /**
     * Find all list.
     *
     * @return the list
     */
    public List<PlaylistDTO> findAll() {
        List<PlaylistDTO> playlists = new ArrayList<>();
        tryFindAll(playlists, "SELECT * FROM playlists");
        return playlists;
    }

    /**
     * Find one playlist dto.
     *
     * @param id the id
     * @return the playlist dto
     */
    public PlaylistDTO findOne(int id) {
        List<PlaylistDTO> playlists = new ArrayList<>();
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("select * from playlists where id=?");
            statement.setInt(1, id);

            addNewItemsFromDatabase(playlists, statement);

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return playlists.get(0);
    }

    private void tryLoadJdbcDriver(DatabaseProperties databaseProperties) {
        try {
            Class.forName(databaseProperties.driver());
        } catch (ClassNotFoundException e) {
            logger.log(Level.SEVERE, "Can't load JDBC Driver " + databaseProperties.driver(), e);
        }
    }

    private void tryFindAll(List<PlaylistDTO> playlists, String query) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());
            PreparedStatement statement = connection.prepareStatement(query);

            addNewItemsFromDatabase(playlists, statement);

            statement.close();
            connection.close();
        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    private void addNewItemsFromDatabase(List<PlaylistDTO> playlists, PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            addNewItemFromResultSet(playlists, resultSet);
        }
    }

    private void addNewItemFromResultSet(List<PlaylistDTO> playlists, ResultSet resultSet) throws SQLException {
        PlaylistDTO playlist = new PlaylistDTO();
        playlist.setId(resultSet.getInt("id"));
        playlist.setName(resultSet.getString("name"));
        playlist.setOwner(resultSet.getBoolean("owner"));

        playlist.setDuration(findLength(playlist.getId()));
        TrackDAO trackDAO = new TrackDAO();
        playlist.setTracks(trackDAO.findTracksFromPlaylist(playlist.getId()));

        playlists.add(playlist);
    }

    /**
     * Edit playlist.
     *
     * @param playlistDTO the playlist dto
     * @param id          the id
     */
    public void editPlaylist(PlaylistDTO playlistDTO, int id) {
        String playlistnaam = playlistDTO.getName();

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("update playlists set name=? where id=?");
            statement.setString(1, playlistnaam);    //1 specifies the first parameter in the query i.e. name
            statement.setInt(2, id);

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    /**
     * Delete playlist.
     *
     * @param id the id
     */
    public void deletePlaylist(int id) {
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("delete from playlists where id=?");
            statement.setInt(1, id);//1 specifies the first parameter in the query i.e. name

            statement.execute();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    /**
     * Add playlist.
     *
     * @param playlistDTO the playlist dto
     */
    public void addPlaylist(PlaylistDTO playlistDTO) {
        String naam = playlistDTO.getName();

        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("insert into playlists(name, owner) values(?, 1)");
            statement.setString(1, naam);//1 specifies the first parameter in the query i.e. name

            statement.execute();

            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
    }

    /**
     * Find length int.
     *
     * @param id the id
     * @return the int
     */
    public int findLength(int id) {

        int lengte = 0;
        try {
            Connection connection = DriverManager.getConnection(databaseProperties.connectionURL(), databaseProperties.connectionUSER(), databaseProperties.connectionPASS());

            PreparedStatement statement = connection.prepareStatement("select sum(duration) from tracks inner join playliststracks on playliststracks.track_id = tracks.id where playliststracks.playlist_id = ?");
            statement.setInt(1, id);

            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                lengte = rs.getInt(1);
            }
            statement.close();
            connection.close();

        } catch (SQLException e) {
            logger.log(Level.SEVERE, "Error communicating with database " + databaseProperties.connectionURL(), e);
        }
        return lengte;
    }
}
