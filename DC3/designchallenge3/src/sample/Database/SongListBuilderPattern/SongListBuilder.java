package sample.Database.SongListBuilderPattern;

import sample.Database.DatabaseConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public interface SongListBuilder {
    Connection myConn = DatabaseConnection.getDatabaseConn();
    Statement statement = null;
    ResultSet resultSet = null;

    public void setSongList(int id);

}
