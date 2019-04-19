//package sample.Database.SongListBuilderPattern.concreteBuilders;
//
//import sample.Database.DatabaseConnection;
//import sample.Database.BuildTemp.SongListBuildTemp;
//import sample.Database.SongListBuilderPattern.SongListBuilder;
//import sample.Model.Playlist;
//import sample.Model.Song;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
//
//public class PlaylistBuilder implements SongListBuilder {
//
//    ArrayList<Song> songlist;
//    SongListBuildTemp songListBuildTemp = new SongListBuildTemp();
//    int playlistid;
//
//    PlaylistBuilder(int playlistid)
//
//    @Override
//    public void setSongList(int playlistid) {
//        songlist = songListBuildTemp.getSongsofPlaylist(playlistid);
//    }
//
//    public Playlist getResult(){
//        Connection myConn = DatabaseConnection.getDatabaseConn();
//        ResultSet resultSet;
//
//        int playlistID;
//        String playlistName;
//        String playlistDescription;
//
//        Playlist playlist;
//
//        try {
//            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM gulaplay.playlist WHERE UserID = ?");
//            prepStatement.setInt(1,UserID);
//            resultSet = prepStatement.executeQuery();
//            while(resultSet.next()){
//                playlistID = resultSet.getInt("PlaylistID");
//                playlistName = resultSet.getString("PlaylistName");
//                playlistDescription = resultSet.getString("PlaylistDescription");
//
//                playlist = new Playlist(playlistID, playlistName,playlistDescription,UserID);
//                System.out.println(playlist.getPlaylistName());
//                playlistsofuser.add(playlist);
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//        return playlistsofuser;
//    }
//}
