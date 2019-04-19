package sample.Database.EventHandlers;

import sample.Database.DatabaseConnection;

import java.sql.*;

public class SongDeleteHandler {
    PreparedStatement prepStatement;
    Connection myConn = DatabaseConnection.getDatabaseConn();
    ResultSet resultSet;


    public SongDeleteHandler(){

    }

    public void deleteSong(int songID) {
        String sql = "DELETE FROM song WHERE idsong = ?;";// insert insert user query here
        try {
            prepStatement = myConn.prepareStatement(sql);
            prepStatement.setInt(1, songID);
            prepStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
