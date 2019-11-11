package DAO;

import helpers.RowMapper;
import helpers.SetConnection;
import models.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDAO {
    private static TestDAO testDAO;
    private Connection connection;

    public static TestDAO getTestDAO() {
        if (testDAO == null) {
            testDAO = new TestDAO();
        }
        return testDAO;
    }

    public TestDAO() {
        connection = SetConnection.createConnection();
    }


    private RowMapper<Test> testRowMapper = row -> {
        Integer id = row.getObject("id", Integer.class);
        String questionText = row.getString("questiontext");
        String answerA = row.getString("answera");
        String answerB = row.getString("answerb");
        String answerC = row.getString("answerc");
        String answerD = row.getString("answerd");
        String correctAnswer = row.getString("correctanswer");
        Integer idTheme = row.getObject("idtheme", Integer.class);
        return new Test(id, questionText, answerA, answerB, answerC, answerD, correctAnswer, idTheme);
    };

    public List<Test> listTest(Long themeId) {
        connection = SetConnection.createConnection();
        List<Test> testList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions where idTheme = " + themeId);
            while (resultSet.next()) {
                Test test = testRowMapper.mapRow(resultSet);
                testList.add(test);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testList;
    }

    public List<Test> listTest() {
        connection = SetConnection.createConnection();
        List<Test> testList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from questions");
            while (resultSet.next()) {
                Test test = testRowMapper.mapRow(resultSet);
                testList.add(test);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return testList;
    }


    public Test getTestbyID(int id) {
        connection = SetConnection.createConnection();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from questions where id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                Test test = testRowMapper.mapRow(resultSet);
                return test;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<String> listTestsString() {
        try {
            connection = SetConnection.createConnection();
            PreparedStatement statement = connection.prepareStatement(
                    "select * from questions"
            );
            ResultSet rs = statement.executeQuery();
            List<String> test = new ArrayList<>();
            while (rs.next()) {
                test.add(rs.getString(2));
                test.add(rs.getString(3));
                test.add(rs.getString(4));
                test.add(rs.getString(5));

            }
            return test;
        } catch (SQLException e) {
            e.printStackTrace();

        }
        return null;
    }


}
