package DAO;

import helpers.RowMapper;
import helpers.SetConnection;
import models.Result;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultsDAO {
    private Connection connection;
    private static ResultsDAO resultsDAO;

    public static ResultsDAO getResultsDAO() {
        if (resultsDAO == null) {
            resultsDAO = new ResultsDAO();
        }
        return resultsDAO;
    }

    public ResultsDAO() {
        connection = SetConnection.createConnection();
    }


    private RowMapper<Result> resultRowMapper = row -> {
        Integer id = row.getObject("id", Integer.class);
        Integer correctAnswer = row.getObject("correctanswer", Integer.class);
        Integer wrongAnswer = row.getObject("wronganswer", Integer.class);
        Integer countCorrect = row.getObject("countcorrect", Integer.class);
        Integer idQuestion = row.getObject("idquestion", Integer.class);
        Integer idUser = row.getObject("iduser", Integer.class);
        return new Result(id, correctAnswer, wrongAnswer, countCorrect, idQuestion, idUser);
    };

    public Result getResultbyID(int id) {
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from resuts where id=?");
            statement.setInt(1, id);

            ResultSet resultSet = statement.executeQuery();
            if (!resultSet.next()) {
                return null;
            } else {
                Result result = resultRowMapper.mapRow(resultSet);
                return result;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Result> getResultList() {
        List<Result> resultList = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from resuts");
            while (resultSet.next()) {
                Result result = resultRowMapper.mapRow(resultSet);
                resultList.add(result);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return resultList;
    }

}
