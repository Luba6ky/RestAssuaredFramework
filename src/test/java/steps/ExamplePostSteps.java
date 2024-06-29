package steps;

import api.utils.po.ExamplePO;
import api.utils.requestDto.ExampleRequestDto;
import api.utils.responseDto.ExampleResponseDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import org.testng.Assert;

import java.util.List;
import java.util.Map;

public class ExamplePostSteps {

    private String endpoint;
    private ExampleRequestDto postData;
    private Response response;
    private ExamplePO examplePO = new ExamplePO();

    @Given("I have the POST endpoint {string}")
    public void i_have_the_post_endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @Given("I have the following post data")
    public void i_have_the_following_post_data(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> postDataMap = data.get(0);
        postData = new ExampleRequestDto();
        postData.setTitle(postDataMap.get("title"));
        postData.setBody(postDataMap.get("body"));
        postData.setUserId(Integer.parseInt(postDataMap.get("userId")));
    }

    @When("I send a POST request to the endpoint with the post data")
    public void i_send_a_post_request_to_the_endpoint_with_the_post_data() {
        response = examplePO.createPostAndGetResponse(endpoint, postData);
    }

    @Then("the response status code should be {int}")
    public void the_response_status_code_should_be(int statusCode) {
        Assert.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the response should contain the post data")
    public void the_response_should_contain_the_post_data() {
        ExampleResponseDto responseData = response.as(ExampleResponseDto.class);
        Assert.assertEquals(responseData.getTitle(), postData.getTitle());
        Assert.assertEquals(responseData.getBody(), postData.getBody());
        Assert.assertEquals(responseData.getUserId(), postData.getUserId());
    }
}
