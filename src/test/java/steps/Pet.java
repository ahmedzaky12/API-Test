package steps;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import requests.DeletePetRequest;
import requests.PetRequest;
import responses.DeletePeteResponse;
import responses.LoginResponse;
import responses.LogoutResponse;
import responses.PetResponse;

import static base.Data.BASEURL;

public class Pet {

    PetRequest request = new PetRequest();
    DeletePetRequest delete = new DeletePetRequest();
    @Before
    public void BaseURI () {
        RestAssured.baseURI = BASEURL ;}

    @Then("i sohould validate correct response {string}")
    public void iSohouldValidateCorrectResponse(String arg0) {
        PetResponse petresponse = new PetResponse();
        petresponse.getPetResponse(request.sendCreateRequest(11111,arg0,"test",123,"available","tef"));
        System.out.println("Response Status Code: " + petresponse.getStatus());
        System.out.println("Response Type: " + petresponse.getName());
        Assert.assertTrue(petresponse.getName().equalsIgnoreCase(arg0));
    }

    @And("i update pet name to {string}")
    public void iUpdatePetNameTo(String arg0) {
        request.sendUpdateRequest(11111,arg0,"test",123,"available","tef");

    }

    @Then("i should validate new name {string}")
    public void iShouldValidateNewName(String arg0) {
        PetResponse petresponse = new PetResponse();
        petresponse.getPetResponse(request.sendUpdateRequest(11111,arg0,"test",123,"available","tef"));
        System.out.println("Response Status Code: " + petresponse.getStatus());
        System.out.println("Response Type: " + petresponse.getName());
        Assert.assertTrue(petresponse.getName().equalsIgnoreCase(arg0));
    }



    @Given("i create pet with name {string} and {string}")
    public void iCreatePetWithNameAnd(String arg0, String arg1) {
        request.sendCreateRequest(Integer.parseInt(arg1),arg0,"test",123,"available","tef");

    }

    @And("i delete this pet {string}")
    public void iDeleteThisPet(String arg0) {
        delete.delete(arg0);
    }

    @Then("i should be deleted successfully {string}")
    public void iShouldBeDeletedSuccessfully(String arg0) {
        DeletePeteResponse response = new DeletePeteResponse();
        response.deleteResponse(delete.delete(arg0));

        try {
            Assert.assertEquals(response.getCode(), 200);
        }catch (Exception e){
            System.out.println("wrong status code======> "  + response.getCode());
        }

    }
}


