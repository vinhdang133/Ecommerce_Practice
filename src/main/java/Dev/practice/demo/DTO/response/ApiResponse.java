package Dev.practice.demo.DTO.dtoRequest;


import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
//khai báo những field nào null thì ko kèm vào json
public class ApiResponse <T>{
    private int code = 1000;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    private String message;
    private T result;
}
