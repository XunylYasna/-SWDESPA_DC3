package sample.Database.BuildTemp;



import sample.Database.DatabaseConnection;
import sample.Model.Song;

import java.sql.*;
import java.util.ArrayList;

public class SongListBuildTemp {

    Connection myConn = DatabaseConnection.getDatabaseConn();
    Statement statement = null;
    ResultSet resultSet;

    public ArrayList<Song> getSongs(String filtercolumn, String value){
        int songID;
        String songTitle;
        String artist;
        String album;
        String genre;
        ArrayList<Song> songList = new ArrayList<>();
        Song song;
        String sql = "SELECT * FROM songhub.song;";

        try {
            if(filtercolumn != null && value != null){
                PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.song WHERE " + filtercolumn + " LIKE ?");
                prepStatement.setString(1,value);
                resultSet = prepStatement.executeQuery();
            }
            else{
                statement = myConn.createStatement();
                resultSet = statement.executeQuery(sql);
            }
            while(resultSet.next()){
                songID = resultSet.getInt("idsong");
                song = getSong(songID);
                System.out.println("sa songlist build temp " + song.getSongTitle());
                songList.add(song);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return songList;
    }


    public ArrayList<String> getColumn(String columnname){

        String artist;
        ArrayList<String> artistList = new ArrayList<>();

        String sql = "SELECT DISTINCT " + columnname + " FROM songhub.song;";

        try {
            statement = myConn.createStatement();
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                artist = resultSet.getString(columnname);
                artistList.add(artist);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return artistList;
    }

    public ArrayList<Song> getSongsofPlaylist(int PlaylistID){
        int songID;
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> songIDList = new ArrayList<>();
        Song song;

        try {
            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.songtoplaylist WHERE playlistid LIKE ?");
            prepStatement.setInt(1,PlaylistID);
            resultSet = prepStatement.executeQuery();

            while(resultSet.next()){
                songID = resultSet.getInt("SongID");
                songIDList.add(songID);
            }

            for(int i = 0; i < songIDList.size(); i++){
                song = getSong(songIDList.get(i));
                songList.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songList;
    }

    public ArrayList<Song> getFavorites(int userID){
        int songID;
        ArrayList<Song> songList = new ArrayList<>();
        ArrayList<Integer> songIDList = new ArrayList<>();
        Song song;

        try {
            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.songuserfavorites WHERE iduser LIKE ?");
            prepStatement.setInt(1,userID);
            resultSet = prepStatement.executeQuery();

            while(resultSet.next()){
                songID = resultSet.getInt("SongID");
                songIDList.add(songID);
            }

            for(int i = 0; i < songIDList.size(); i++){
                song = getSong(songIDList.get(i));
                songList.add(song);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return songList;
    }

    public Song getSong(int SongID){
        String songTitle;
        String artist;
        String album;
        String genre;
        ArrayList<Song> songList = new ArrayList<>();
        Song song = null;
        ResultSet getSongResult;

        try {
            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.song WHERE idsong LIKE ?");
            prepStatement.setInt(1,SongID);
            getSongResult = prepStatement.executeQuery();

            while(getSongResult.next()){
                songTitle = getSongResult.getString("title");
                artist = getSongResult.getString("artist");
                album = getSongResult.getString("album");
                genre = getSongResult.getString("genre");

                song = new Song(SongID, songTitle,artist, album, genre);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return song;
    }


}
