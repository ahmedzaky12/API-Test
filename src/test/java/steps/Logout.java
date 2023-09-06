package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.testng.Assert;
import requests.UserLogoutRequest;
import responses.LogoutResponse;

import static base.Data.BASEURL;

public class Logout {
    @Before
    public void BaseURI () {
        RestAssured.baseURI = BASEURL ;
    }
    UserLogoutRequest logoutrequest = new UserLogoutRequest();
    @Given("I logged out")
    public void iLoggedOut() {
        logoutrequest.logout();
    }

    @Then("I should got valid status code")
    public void iShouldGotValidStatusCode() {
        LogoutResponse logoutresponse = new LogoutResponse();
        logoutresponse.getLogoutResponse(logoutrequest.logout());

        System.out.println("Response Status Code: " + logoutresponse.getCode());
        System.out.println("Response Type: " + logoutresponse.getType());
        Assert.assertEquals(logoutresponse.getCode(), 200);
        Assert.assertTrue(logoutresponse.getType()!=null);
    }

    @Given("uyergyg")
    public void uyergyg() {
        System.out.println("fhhfbehrf");
    }
}
