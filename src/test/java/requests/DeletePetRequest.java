package requests;

import apiConfig.HeaderConfg;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import static base.Data.PET;

public class DeletePetRequest {
    HeaderConfg header = new HeaderConfg();
    Response response;

    public Response delete(String id) {
        response = RestAssured.given().log().uri()
                .headers(header.defaultHeaders())
                .when().delete(PET + "/" + id);
        
        return response;
    }
}
