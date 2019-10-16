package services;

import DAO.TokenDAO;

import java.security.SecureRandom;

public class TokenService {

    private TokenDAO tokenDAO;

    public TokenService() {
        tokenDAO = TokenDAO.getTokenDAO();
    }

    public static String getToken() {
        SecureRandom secureRandom = new SecureRandom();
        byte b[] = new byte[20];
        secureRandom.nextBytes(b);
        String token = b.toString();
        return token;
    }

    public void add(int id, String token) {
        tokenDAO.add(id, token);
    }

    public void update(int id, String token) {
        tokenDAO.update(id, token);
    }

    public void delete(String token) {
        tokenDAO.delete(token);
    }

    public String findToken(String token) {
        return tokenDAO.find(token);
        // возвращает id user`а
    }

}
