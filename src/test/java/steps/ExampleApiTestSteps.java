package steps;

import api.utils.po.ExamplePO;
import api.utils.responseDto.exampleGetResponseDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.testng.Assert;

public class ExampleApiTestSteps {

    private String endpoint;
    private ExamplePO examplePO = new ExamplePO();
    private exampleGetResponseDto response;

    @Given("I have the endpoint {string}")
    public void i_have_the_endpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    @When("I send a GET request to the endpoint")
    public void i_send_a_get_request_to_the_endpoint() {
        response = examplePO.getPost(endpoint);
    }

    @Then("the response userId should be {int}")
    public void the_response_userId_should_be(int userId) {
        Assert.assertEquals(response.getUserId(), userId);
    }

    @Then("the response id should be {int}")
    public void the_response_id_should_be(int id) {
        Assert.assertEquals(response.getId(), id);
    }

    @Then("the response title should be {string}")
    public void the_response_title_should_be(String title) {
        Assert.assertEquals(response.getTitle(), title);
    }

    @Then("the response body should be {string}")
    public void the_response_body_should_be(String body) {
        Assert.assertEquals(response.getBody(), body);
    }
}
