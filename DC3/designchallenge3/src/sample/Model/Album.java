package sample.Model;

import java.util.ArrayList;

public class Album {
    private int albumID;
    private String albumName;
    private ArrayList<Song> songlist;
    private int artistID;



    public Album(int albumID, String albumName, int artistID) {
        this.albumID = albumID;
        this.albumName = albumName;
        this.artistID = artistID;
    }

    public int getAlbumID() {
        return albumID;
    }

    public String getAlbumName() {
        return albumName;
    }

    public int getArtistID() {
        return artistID;
    }

    public ArrayList<Song> getSonglist() {
        return songlist;
    }

    public void setSonglist(ArrayList<Song> songlist) {
        this.songlist = songlist;
    }
}
