import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;
import java.io.IOException;

import static org.testng.Assert.assertEquals;

public class Get404 extends BaseTest{
        @Test
        public void nonExistingUrlReturns404() throws IOException {

            HttpGet get = new HttpGet(BASE_URL + "/xyz");

            client.execute(get);
            response = client.execute(get);
            int responseCode = response.getStatusLine().getStatusCode();
            assertEquals(responseCode, 404);
        }
    }


