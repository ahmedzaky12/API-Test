package responses;

import io.restassured.response.Response;

public class PetResponse {
    private long id;
    private Category category;
    private String name;
    private String[] photoUrls;
    private Tag[] tags;
    private String status;

    public PetResponse() {
    }

    public PetResponse(long id, Category category, String name, String[] photoUrls, Tag[] tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

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

    public String[] getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(String[] photoUrls) {
        this.photoUrls = photoUrls;
    }

    public Tag[] getTags() {
        return tags;
    }

    public void setTags(Tag[] tags) {
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

    public  Response getPetResponse(Response response) {
        this.id = response.jsonPath().getLong("id");
        this.category = response.jsonPath().getObject("category", Category.class);
        this.name = response.jsonPath().getString("name");
        this.photoUrls = response.jsonPath().getObject("photoUrls", String[].class);
        this.tags = response.jsonPath().getObject("tags", Tag[].class);
        this.status = response.jsonPath().getString("status");

        return response;
    }
}
