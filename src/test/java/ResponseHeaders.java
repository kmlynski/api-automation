import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ResponseHeaders extends BaseTest {

    @Test
    public void isContentTypeInJsonTest() throws IOException{

        HttpGet get = new HttpGet( BASE_URL );

        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();

        ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void isServerGitHubTest() throws IOException{

        HttpGet get = new HttpGet( BASE_URL );

        response = client.execute(get);

        String header = ResponseUtilities.getHeader(response, "Server");

        assertEquals(header, "GitHub.com");
    }

    @Test
    public void isXRateLimitSixtyTest() throws IOException {
        HttpGet get = new HttpGet( BASE_URL );

        response = client.execute(get);
        String xratevalue = ResponseUtilities.getHeader(response,"X-RateLimit-Limit");

        assertEquals(xratevalue, "60");
    }

    @Test
    public void isETagPresent() throws IOException {
        HttpGet get = new HttpGet( BASE_URL );

        response = client.execute(get);
        boolean isETagPresentInResponse = ResponseUtilities.isHeaderPresent(response, "etag");

        assertTrue(isETagPresentInResponse);

    }
}
