import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.entity.ContentType;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;

public class ResponseHeaders extends BaseTest {

    @Test
    public void contentTypeInJson() throws IOException{

        HttpGet get = new HttpGet(BASE_URL );

        response = client.execute(get);

        Header contentType = response.getEntity().getContentType();

        ContentType ct = ContentType.getOrDefault(response.getEntity());
        assertEquals(ct.getMimeType(), "application/json");
    }

    @Test
    public void serverIsGitHub() throws IOException{

        HttpGet get = new HttpGet(BASE_URL );

        response = client.execute(get);

        String header = ResponseUtilities.getHeader(response, "Server");

        assertEquals(header, "GitHub.com");
    }
}
