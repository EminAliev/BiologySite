package helpers;

public class Errors {
    private String error;
    private String error_message;

    public Errors(String error, String error_message) {
        this.error = error;
        this.error_message = error_message;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getError_message() {
        return error_message;
    }

    public void setError_message(String error_message) {
        this.error_message = error_message;
    }
}
