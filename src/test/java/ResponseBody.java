import dtos.RateLimit;

import dtos.Users;
import org.apache.http.client.methods.HttpGet;
import org.testng.annotations.Test;

import java.io.IOException;

import static org.testng.Assert.assertEquals;


public class ResponseBody extends BaseTest {

    @Test
    public void returnsCorrectLogin() throws IOException {
        HttpGet get = new HttpGet( BASE_URL + "/users/" + TEST_USER);

        response = client.execute(get);
        Users user = ResponseUtilities.unmarshall(response, Users.class);

        assertEquals(user.getLogin(), "kmlynski");
    }

    @Test
    public void returnsCorrectId() throws IOException {
        HttpGet get = new HttpGet( BASE_URL + "/users/" + TEST_USER);

        response = client.execute(get);
        Users user = ResponseUtilities.unmarshall(response, Users.class);

        assertEquals(user.getId(),(63342918));
    }

    @Test
    public void correctCoreAttributesAreSet() throws IOException{
        HttpGet get = new HttpGet( BASE_URL + "/rate_limit");

        response = client.execute(get);
        RateLimit rateLimit = ResponseUtilities.unmarshall(response, RateLimit.class);

        assertEquals(rateLimit.getCoreLimit(),60);

    }

    @Test
    public void correctSearchAttributesAreSet() throws IOException {
        HttpGet get = new HttpGet( BASE_URL + "/rate_limit");

        response = client.execute(get);
        RateLimit rateLimit = ResponseUtilities.unmarshall(response, RateLimit.class);

        assertEquals(rateLimit.getSearchLimit(), 10 );
        assertEquals(rateLimit.getSearchRemaining(), 10);

    }

    @Test
    public void correctGraphqlAttributesAreSet() throws IOException {
        HttpGet get = new HttpGet( BASE_URL + "/rate_limit");

        response = client.execute(get);
        RateLimit rateLimit = ResponseUtilities.unmarshall(response, RateLimit.class);

        assertEquals(rateLimit.getGraphqlLimit(), 0 );
        assertEquals(rateLimit.getGraphqlRemaining(), 0);
    }
}
