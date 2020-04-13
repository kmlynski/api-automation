import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get200 extends BaseTest {

    @DataProvider
    private Object[][] publicEndpoints(){
        return new Object[][]{
                {""},
                {"/rate_limit"},
                {"/search/repositories?q=java"}
        };
    }

    @Test(dataProvider = "publicEndpoints")
    public void verifyThatPublicEndpointsReturns200(String endpoint) throws IOException {

         HttpGet get = new HttpGet(BASE_URL + endpoint);

         client.execute(get);
         response = client.execute(get);

         int responseCode = response.getStatusLine().getStatusCode();

         assertEquals(responseCode, 200);
    }
}
