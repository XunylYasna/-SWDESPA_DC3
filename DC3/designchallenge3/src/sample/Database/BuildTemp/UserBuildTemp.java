package sample.Database.BuildTemp;



import sample.Database.DatabaseConnection;
import sample.Database.SongListBuilderPattern.SongListBuilder;
import sample.Model.Playlist;
import sample.Model.User;

import java.sql.*;
import java.util.ArrayList;

public class UserBuildTemp {

    Connection myConn = DatabaseConnection.getDatabaseConn();
    Statement statement = null;
    ResultSet resultSet;

    public User getUser(String username){
        int userID;
        String firstName;
        String lastName;
        String password;
        String email;
        String type;

        User user = null;


        try {
            PreparedStatement prepStatement = myConn.prepareStatement("SELECT * FROM songhub.user WHERE username LIKE  ?");
            prepStatement.setString(1,username);
            resultSet = prepStatement.executeQuery();
            while(resultSet.next()){
                userID = resultSet.getInt("iduser");
                firstName = resultSet.getString("first_name");
                lastName = resultSet.getString("last_name");
                password = resultSet.getString("password");
                email = resultSet.getString("email");
                type = resultSet.getString("type");

                user = new User(userID, username,firstName, lastName, password, email, type);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }
}
