package responses;

import io.restassured.response.Response;

public class DeletePeteResponse {
    public Response deleteResponse(Response response) {
        this.code = response.getStatusCode();
        return response;
    }

    private int code;
    private String type;
    private String message;

    // Getter and setter for code
    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    // Getter and setter for type
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Getter and setter for message
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
