package services;

import DAO.QuestionDAO;
import models.Question;

import java.util.List;

public class QuestionService {
    private QuestionDAO questionDAO;

    public QuestionService() {
        questionDAO = QuestionDAO.getQuestionDAO();
    }

    public List<Question> getQuestionList(int idTheme) {
        return questionDAO.getQuestionList(idTheme);
    }

    public Question getQuestion(int id) {
        return questionDAO.getQuestion(id);
    }
}
