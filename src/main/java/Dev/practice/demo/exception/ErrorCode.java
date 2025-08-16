package Dev.practice.demo.exception;

public enum ErrorCode {

    USER_EXISTED(1002, "User already exists"),
    UNCATEGORIZED_EXCEPTION(9999,"UNCATEGORIZED EXCEPTION"),
    USERNAME_INVALID(1003, "USERNAME INVALID"),
    PASSWORD_INVALID(1004, "PASSWORD INVALID"),
    INVALID_KEY(1001, "INVALID KEY"),
    ;
    private int code;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }


}
