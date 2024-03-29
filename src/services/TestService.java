package services;

import DAO.TestDAO;
import models.Test;

import java.util.List;

public class TestService {
    private TestDAO testDAO;

    public TestService() {
        testDAO = TestDAO.getTestDAO();
    }

    public List<Test> listTest() {
        return testDAO.listTest();
    }

    public Test getTestbyID(int id) {
        return testDAO.getTestbyID(id);
    }

    public List<String> listTestsString() {
        return testDAO.listTestsString();
    }

    public List<Test> getTestsByThemeId(Long themeId) {
        return testDAO.listTest(themeId);
    }
    public List<String> listCorrectAnswer() {
        return testDAO.listCorrectAnswer();
    }
}