package sample.Database.BuildTemp;


import sample.Database.DatabaseConnection;
import sample.Database.SongListBuilderPattern.SongListBuilder;
import sample.Model.Playlist;

import java.sql.*;
import java.util.ArrayList;

public class PlaylistBuildTemp {

    Connection myConn = DatabaseConnection.getDatabaseConn();
    ResultSet resultSet;

    public ArrayList<Playlist> getPlaylists(int UserID){
        ArrayList<Playlist> playlistsofuser = new ArrayList<>();

        int playlistID;
        String playlistName;
        String playlistDescription;

        Playlist playlist;

        try {
            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.playlist WHERE idplaylist= ?"); // Changed userid (gulaplayDB) to idplaylist (songhubDB)
                                                                                                                                // , might have error with logic now double check lang
            prepStatement.setInt(1,UserID);
            resultSet = prepStatement.executeQuery();
            while(resultSet.next()){
                playlistID = resultSet.getInt("PlaylistID");
                playlistName = resultSet.getString("PlaylistName");
                playlistDescription = resultSet.getString("PlaylistDescription");

                playlist = new Playlist(playlistID, playlistName,playlistDescription,UserID);
                System.out.println(playlist.getPlaylistName());
                playlistsofuser.add(playlist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return playlistsofuser;
    }
}
