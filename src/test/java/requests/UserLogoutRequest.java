package requests;

import apiConfig.HeaderConfg;
import apiConfig.ParamsConfig;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static base.Data.*;

public class UserLogoutRequest {
    HeaderConfg header = new HeaderConfg();
    Response response;

    public Response logout() {
        response = RestAssured.given()
                .headers(header.defaultHeaders())
                .when().get(LOGOUT);
        return response;
    }
}
