package api.tests;

import api.base.ApiBaseTest;
import api.utils.logging.Log;
import api.utils.builders.RequestBuilder;
import api.utils.po.ExamplePO;
import api.utils.responseDto.ExampleResponseDto;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ExampleApiTest extends ApiBaseTest {
    RequestBuilder requestBuilder;
    ExamplePO examplePO;

    @BeforeMethod
    public void before() {
        requestBuilder = new RequestBuilder();
        examplePO = new ExamplePO();
    }

    @Test
    public void exampleTest() throws Exception {
        String endpoint = "/posts/1";
        Log.info("Sending GET request to " + endpoint);

        ExampleResponseDto response = examplePO.getPost(endpoint);


        Assert.assertEquals(response.getUserId(), 1);
        Assert.assertEquals(response.getId(), 1);
        Assert.assertEquals(response.getTitle(), "sunt aut facere repellat provident occaecati excepturi optio reprehenderit");
        Assert.assertEquals(response.getBody(), "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto");
    }
}
