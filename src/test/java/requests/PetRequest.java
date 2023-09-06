package requests;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import java.util.ArrayList;
import java.util.List;

import static base.Data.PET;

public class PetRequest {
    private long id;
    private Category category;
    private String name;
    private List<String> photoUrls;
    private List<Tag> tags;
    private String status;

    public PetRequest() {
        // Create a default Category instance
        this.category = new Category(0, "string");
    }

    public Response sendCreateRequest(long id, String name, String photoUrl, int tagId, String tagName, String status) {
        this.id = id;
        this.name = name;
        this.photoUrls = new ArrayList<>();
        this.photoUrls.add(photoUrl);
        this.tags = new ArrayList<>();
        this.tags.add(new Tag(tagId, tagName));
        this.status = status;

        // Send a POST request using RestAssured
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(this)
                .post(PET);
        

        // Print the response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        return response;
    }

    // Category and Tag classes remain the same

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public static class Category {
        private long id;
        private String name;

        public Category() {
        }

        public Category(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Tag {
        private long id;
        private String name;

        public Tag() {
        }

        public Tag(long id, String name) {
            this.id = id;
            this.name = name;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
    public Response sendUpdateRequest(long id, String name, String photoUrl, int tagId, String tagName, String status) {
        this.id = id;
        this.name = name;
        this.photoUrls = new ArrayList<>();
        this.photoUrls.add(photoUrl);
        this.tags = new ArrayList<>();
        this.tags.add(new Tag(tagId, tagName));
        this.status = status;

        // Send a POST request using RestAssured
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(this)
                .put(PET);
        

        // Print the response
        System.out.println("Response Status Code: " + response.getStatusCode());
        System.out.println("Response Body: " + response.getBody().asString());
        return response;
    }
}
