package requests;

import apiConfig.HeaderConfg;
import apiConfig.ParamsConfig;
import groovy.lang.GString;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static base.Data.BASEURL;
import static base.Data.LOGIN;


public class UserLoginRequest {

    private String username;
    HeaderConfg header = new HeaderConfg();
    private String password;
    RequestSpecification getRequest ;
    Response response;
    ParamsConfig param = new ParamsConfig();




    public void navigateToBaseURL() {
        getRequest = RestAssured.given();
        System.out.println("1-here is the base url  =====> " + BASEURL);

    }
    public Response Login(String username , String password) {
        response = getRequest
                .params(param.loginParams(username,password))
                .headers(header.defaultHeaders())
                .when().get(LOGIN);

        System.out.println("2-and here is the base url/endPoint =====> " + BASEURL + LOGIN);
        return response;
    }

    // Getter and setter for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and setter for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
