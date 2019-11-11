package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidationUtil {
    public static boolean validateEmail(String email) {
        String emailp = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
        Pattern p = Pattern.compile(emailp);
        Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean validateString(String string) {
        return string.matches("[a-zA-Z]");
    }

    public static boolean validatePassword(String password) {
        return password.matches("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})");
    }

    public static boolean validateUsernamePassword(String string) {
        Pattern p = Pattern.compile("(^[a-zA-Z0-9]+)");
        Matcher m = p.matcher(string);
        return m.matches();

    }

}
