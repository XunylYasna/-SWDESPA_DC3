package sample.Database.EventHandlers;

import sample.Database.DatabaseConnection;

import java.sql.*;

public class RegistrationHandler{

    PreparedStatement prepStatement;
    Connection myConn = DatabaseConnection.getDatabaseConn();
    Statement statement = null;
    ResultSet resultSet;

    {
        try {
            statement = myConn.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public String registration(String firstname, String lastname, String username, String email, String password, String type) {

        boolean existUsername = checkExist("username",username);
        boolean existEmail = checkExist("email",email);

        if(!existEmail && !existUsername) {

            String sql = "INSERT INTO user (first_name, last_name, username, password, email, type)\n" +
                    "values (?, ?, ?, ?, ?,?)";// insert insert user query here
            try {
                prepStatement = myConn.prepareStatement(sql);
                prepStatement.setString(1, firstname);
                prepStatement.setString(2, lastname);
                prepStatement.setString(3, username);
                prepStatement.setString(4, password);
                prepStatement.setString(5, email);
                prepStatement.setString(6, type);
                prepStatement.execute();
            } catch (SQLException e) {
                e.printStackTrace();
            }

            return "Registration Successful.";
        }

        if(existUsername){
            return "Username already exists.";
        }

        else{
            return "Email already in use.";
        }

    }

    private boolean checkExist(String column, String check){
        int count = 0;

        String sql = "SELECT COUNT("+ column +")\n" +
                "  FROM songhub.user\n" +
                " WHERE "+ column +" = '"+ check +"' \n" +
                " LIMIT 0, 1"; // verify query
        try {
            resultSet = statement.executeQuery(sql);
            while(resultSet.next()){
                count = Integer.parseInt(resultSet.getString("COUNT(" + column + ")"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(count == 0){
            return false;
        }

        else
            return true;

    }

    public void test() throws SQLException {
        System.out.println("registration test");
        String sql = "INSERT INTO user (iduser, username, password, userType)\n" +
                "values (?, ?, ?, ?)";

        statement.executeQuery(sql);
    }

}
