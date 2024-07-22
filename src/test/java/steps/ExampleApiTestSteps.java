package steps;

import api.base.ApiBaseTest;
import api.utils.po.ExamplePO;
import api.utils.responseDto.exampleGetResponseDto;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(AllureJunit5.class)
public class ExampleApiTestSteps extends ApiBaseTest {

    private String endpoint;
    private ExamplePO examplePO = new ExamplePO();
    private exampleGetResponseDto response;


//    @Given("I have the endpoint {string}")
//    @Step("Set endpoint to {endpoint}")
//    @Description("Setting the endpoint for the GET request")
//    public void i_have_the_endpoint(String endpoint){
//        //Test DB connection
//        Properties properties = new PropertyReader().getProperties();
//
//        DBConnection dbConnection = new DBConnection(properties);
//
//        ExampleModel exampleModel = new ExampleModel();
//
//        try {
//            exampleModel.verifyUser(1,"testName2","testName@mail.com","12343456");
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//
//        this.endpoint = endpoint;
//        System.out.println("endpoint: "+ endpoint);
//    }

//    @Given("I have the endpoint {string}")
//    @Step("Set endpoint to {endpoint}")
//    @Description("Setting the endpoint for the GET request")
//    public void i_have_the_endpoint(String endpoint){
//         // Test JSON parse
//        JsonParser.getInstance().loadJsonData("src/test/resources/drivers/TestData.json");
//
//        this.endpoint = JsonParser.getInstance().getValue("givenStringUrlTest");
//        System.out.println("endpoint: "+ endpoint);
//    }

    @Given("I have the endpoint {string}")
    @Step("Set endpoint to {endpoint}")
    @Description("Setting the endpoint for the GET request")
    public void i_have_the_endpoint(String endpoint) {
        this.endpoint = endpoint;
        System.out.println("Set endpoint to: " + endpoint); // Логиране на стойността на endpoint
    }

//    @Given("I have the endpoint {string}")
//    @Step("Set endpoint to {endpoint}")
//    @Description("Setting the endpoint for the GET request")
//    public void i_have_the_endpoint(String endpoint) {
//        this.endpoint = endpoint;
//    }

    @When("I send a GET request to the endpoint")
    @Step("Send GET request to endpoint")
    @Description("Sending a GET request to the endpoint")
    public void i_send_a_get_request_to_the_endpoint() {
        response = examplePO.getPost(endpoint);
        System.out.println("Sent GET request to endpoint: " + endpoint); // Логиране на изпращането на заявка
    }

    @Then("the response userId should be {int}")
    @Step("Verify response userId")
    @Description("Verifying that the response userId matches the expected value")
    public void the_response_userId_should_be(int userId) {
        System.out.println("Verifying response userId: expected=" + userId + ", actual=" + response.getUserId()); // Логиране на проверката
        Assertions.assertEquals(response.getUserId(), userId);
    }

    @Then("the response id should be {int}")
    @Step("Verify response id")
    @Description("Verifying that the response id matches the expected value")
    public void the_response_id_should_be(int id) {
        System.out.println("Verifying response id: expected=" + id + ", actual=" + response.getId()); // Логиране на проверката
        Assertions.assertEquals(response.getId(), id);
    }

    @Then("the response title should be {string}")
    @Step("Verify response title")
    @Description("Verifying that the response title matches the expected value")
    public void the_response_title_should_be(String title) {
        System.out.println("Verifying response title: expected=" + title + ", actual=" + response.getTitle()); // Логиране на проверката
        Assertions.assertEquals(response.getTitle(), title);
    }

    @Then("the response body should be {string}")
    @Step("Verify response body")
    @Description("Verifying that the response body matches the expected value")
    public void the_response_body_should_be(String body) {
        System.out.println("Verifying response body: expected=" + body + ", actual=" + response.getBody()); // Логиране на проверката
        Assertions.assertEquals(response.getBody(), body);
    }
}
