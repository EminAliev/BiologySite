package DAO;

import java.sql.Connection;

public class ResultsDAO {
    private Connection connection;
    private ResultsDAO resultsDAO;

    public ResultsDAO(ResultsDAO resultsDAO) {
        this.resultsDAO = resultsDAO;
    }
}
