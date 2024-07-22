package steps;

import api.base.ApiBaseTest;
import api.utils.po.ExamplePO;
import api.utils.requestDto.ExampleRequestDto;
import api.utils.responseDto.ExampleResponseDto;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import io.restassured.response.Response;

import java.util.List;
import java.util.Map;

@ExtendWith(AllureJunit5.class)
public class ExamplePostSteps extends ApiBaseTest {

    private String endpoint;
    private ExampleRequestDto postData;
    private Response response;
    private ExamplePO examplePO = new ExamplePO();

    @Given("I have the POST endpoint {string}")
    @Step("Set POST endpoint to {endpoint}")
    @Description("Setting the POST endpoint")
    public void i_have_the_post_endpoint(String endpoint) {
        this.endpoint = endpoint;
    }


    @Given("I have the following post data")
    @Step("Set post data")
    @Description("Setting the post data")
    public void i_have_the_following_post_data(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        Map<String, String> postDataMap = data.get(0);
        postData = new ExampleRequestDto();
        postData.setTitle(postDataMap.get("title"));
        postData.setBody(postDataMap.get("body"));
        postData.setUserId(Integer.parseInt(postDataMap.get("userId")));
    }

    @When("I send a POST request to the endpoint with the post data")
    @Step("Send POST request to endpoint with post data")
    @Description("Sending a POST request to the endpoint with the post data")
    public void i_send_a_post_request_to_the_endpoint_with_the_post_data() {
        response = examplePO.createPostAndGetResponse(endpoint, postData);
    }

    @Then("the response status code should be {int}")
    @Step("Verify response status code")
    @Description("Verifying that the response status code matches the expected value")
    public void the_response_status_code_should_be(int statusCode) {
        Assertions.assertEquals(response.getStatusCode(), statusCode);
    }

    @Then("the response should contain the post data")
    @Step("Verify response contains post data")
    @Description("Verifying that the response contains the post data")
    public void the_response_should_contain_the_post_data() {
        ExampleResponseDto responseData = response.as(ExampleResponseDto.class);
        Assertions.assertEquals(responseData.getTitle(), postData.getTitle());
        Assertions.assertEquals(responseData.getBody(), postData.getBody());
        Assertions.assertEquals(responseData.getUserId(), postData.getUserId());
    }
}
