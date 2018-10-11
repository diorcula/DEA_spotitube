//package nl.han.ica.dea.fedor.services;
//
//import nl.han.ica.dea.fedor.datasources.PlaylistsDAO;
//import nl.han.ica.dea.fedor.datasources.SQLDatabaseConnection;
//
//import nl.han.ica.dea.fedor.dto.PlaylistBuilderDTO;
//import nl.han.ica.dea.fedor.dto.PlaylistCollectionDTO;
//
//import javax.inject.Inject;
//
//public class PlaylistService {
//
//    @Inject
//    SQLDatabaseConnection connection;
//
//    @Inject
//    PlaylistsDAO playlistsDAO;
//
//    public PlaylistCollectionDTO getAllPlaylists() {
//        PlaylistBuilderDTO playlist1 = new PlaylistBuilderDTO();
////        playlist1.setPlaylist(1, "Death Metal", true, new int[0]);
//
//        String playlistName = playlistsDAO.getPlaylistName();
//        playlist1.setPlaylist(1, playlistName, true, new int[0]);
//
//        PlaylistBuilderDTO playlist2 = new PlaylistBuilderDTO();
//        playlist2.setPlaylist(2, "Pop", false, new int[0]);
//
//        PlaylistCollectionDTO playlistCollectionDTO = new PlaylistCollectionDTO();
//
//        playlistCollectionDTO.addPlaylist(playlist1);
//        playlistCollectionDTO.addPlaylist(playlist2);
//        playlistCollectionDTO.setLength(123445);
//
//        return playlistCollectionDTO;
//    }
//
//    public PlaylistCollectionDTO editPlaylist(int id, PlaylistBuilderDTO playlistBuilderDTO) {
//        PlaylistBuilderDTO playlist1 =
//
//        String playlistName = playlistsDAO.editPlaylist(listName);
//        playlist1.setPlaylist(1, playlistName, true, new int[0]);
//
//        PlaylistCollectionDTO playlistCollectionDTO = new PlaylistCollectionDTO();
//
//        return playlistCollectionDTO;
//    }
//}
