package DAO;

import models.Question;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAO {
    private static QuestionDAO questionDAO;
    private Connection connection;

    public static QuestionDAO getQuestionDAO() {
        if (questionDAO == null) {
            questionDAO = new QuestionDAO();
        }
        return questionDAO;
    }

    public QuestionDAO() {
        connection = SetConnection.createConnection();
    }


    private RowMapper<Question> questionRowMapper = row -> {
        Integer id = row.getObject("id", Integer.class);
        String questionText = row.getString("questiontext");
        String questionImage = row.getString("questionimage");
        String answerA = row.getString("answera");
        String answerB = row.getString("answerb");
        String answerC = row.getString("answerc");
        String answerD = row.getString("answerd");
        String correctAnswer = row.getString("correctanswer");
        Boolean isImageQuestion = row.getBoolean("isimagequestion");
        Integer idTheme = row.getObject("idtheme", Integer.class);
        return new Question(id, questionText, questionImage, answerA, answerB, answerC, answerD, correctAnswer, isImageQuestion, idTheme);
    };

    public List<Question> getQuestionList(int idTheme) {
        List<Question> questionList = new ArrayList<>();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from questions where idtheme= ?");
            statement.setInt(1, idTheme);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Question question = questionRowMapper.mapRow(resultSet);
                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return questionList;
    }

    public Question getQuestion(int id) {
        Question question = new Question();
        try {
            PreparedStatement statement = connection
                    .prepareStatement("select * from questions where id= ?");
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                question = questionRowMapper.mapRow(resultSet);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return question;
    }


}
