package base;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

import static base.Data.BASEURL;


public class Hooks {
    RequestSpecification getRequest ;
    public void getBaseURL() {
        getRequest = RestAssured.given();
        System.out.println("1-here is the base url  =====> " + BASEURL);
    }
}
