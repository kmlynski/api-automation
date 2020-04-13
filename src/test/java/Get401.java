import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get401 extends BaseTest {

    @DataProvider
    private Object[][] securedEndpoints(){
        return new Object[][]{
                {"/user"},
                {"/user/followers"},
                {"/notifications"}
        };
    }

    @Test(dataProvider = "securedEndpoints")
    public void verifyThatSecuredEndpointsReturns401(String endpoint) throws IOException {

        HttpGet get = new HttpGet(BASE_URL + endpoint );

        client.execute(get);
        response = client.execute(get);

        int responseCode = response.getStatusLine().getStatusCode();

        assertEquals(responseCode, 401);
    }
}


