package api.utils.po;

import api.utils.builders.RequestBuilder;
import api.utils.responseDto.ExampleResponseDto;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ExamplePO {
    private RequestBuilder requestBuilder;

    public ExamplePO() {
        requestBuilder = new RequestBuilder();
    }

    public ExampleResponseDto getPost(String endpoint) {
        Response response = requestBuilder.get(endpoint, null, ContentType.JSON, null, null);
        return response.as(ExampleResponseDto.class);
    }
}
