package services;

import DAO.ResultsDAO;
import models.Result;

import java.util.List;

public class ResultService {

    private ResultsDAO resultsDAO;

    public ResultService() {
        resultsDAO = ResultsDAO.getResultsDAO();
    }

    public Result getResultbyID(int id) {
        return resultsDAO.getResultbyID(id);
    }

    public List<Result> getResultList() {
        return resultsDAO.getResultList();
    }
}
