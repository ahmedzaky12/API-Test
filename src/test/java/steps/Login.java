package steps;

import base.Hooks;
import responses.LoginResponse;
import requests.UserLoginRequest;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;


import static base.Data.*;
import static org.testng.AssertJUnit.assertTrue;

public class Login {


    UserLoginRequest loginRequest = new UserLoginRequest();

    @Before
    public void BaseURI () {
        RestAssured.baseURI = BASEURL ;
    }



    @Given("I navigate to the Pet Store")
    public void iNavigateToThePetStore() {
        loginRequest.navigateToBaseURL();

    }

    @When("I login using valid credentials {string} and {string}")
    public void iLoginUsingValidCredentialsAnd(String arg0, String arg1) {
        loginRequest.Login(arg0,arg1);
    }



    @Then("I should get a correct response {string} and {string}")
    public void iShouldGetACorrectResponseAnd(String arg0, String arg1) {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.getLoginResponse(loginRequest.Login(arg0,arg1));

        System.out.println("Response Status Code: " + loginResponse.getCode());
        System.out.println("Response Type: " + loginResponse.getType());
        Assert.assertEquals(loginResponse.getCode(), 200);
        Assert.assertTrue(loginResponse.getType()!=null);


    }


}
