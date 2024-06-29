package api.utils.po;

import api.utils.builders.RequestBuilder;
import api.utils.requestDto.ExampleRequestDto;
import api.utils.responseDto.exampleGetResponseDto;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import api.utils.logging.Log;

public class ExamplePO {
    private RequestBuilder requestBuilder;

    public ExamplePO() {
        requestBuilder = new RequestBuilder();
    }


    public exampleGetResponseDto getPost(String endpoint) {
        Response response = RestAssured.get(endpoint);
        return response.as(exampleGetResponseDto.class);
    }

    public Response createPostAndGetResponse(String endpoint, ExampleRequestDto postData) {
        Log.info("Preparing POST request to: " + endpoint);
        Response response = requestBuilder.post(endpoint, postData, null, null, null, ContentType.JSON);
        Log.info("Response status code: " + response.getStatusCode());
        Log.info("Response body: " + response.getBody().asString());
        return response;
    }

    public Response updatePost(String endpoint, ExampleRequestDto updatedPostData) {
        return RestAssured.given()
                .contentType(ContentType.JSON)
                .body(updatedPostData)
                .put(endpoint);
    }

    public Response deletePost(String endpoint) {
        return RestAssured.delete(endpoint);
    }
}
