package ru.prokhor.lab_5;

public class ValidationException extends RuntimeException {

    private String errorId;
    private String errorMsg;

    public ValidationException(String errorId, String errorMsg) {
        this.errorId = errorId;
        this.errorMsg = errorMsg;
    }

    public String getErrorId() {
        return this.errorId;
    }

    public String getErrorMsg() {
        return this.errorMsg;
    }
}