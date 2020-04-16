import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.FileReader;
import java.io.IOException;

public class BaseTest {
    CloseableHttpClient client;
    CloseableHttpResponse response;
    static String TEST_USER;
    static String BASE_URL;

    @BeforeSuite
    @SuppressWarnings("checked")
    public void setUp() throws Exception {
        JSONParser parser = new JSONParser();
        JSONObject config = (JSONObject) parser.parse(new FileReader("src/test/resources/conf/config.conf.json"));

        TEST_USER = System.getenv("TEST_USER");
        if (TEST_USER == null) {
            TEST_USER = (String) config.get("testusername");
        }

        String server = System.getenv("SERVER");
        if(server == null){
            BASE_URL = (String) config.get("server");
        }
    }

    @BeforeMethod
    public void SetUp(){
        client = HttpClientBuilder.create().build();
    }

    @AfterMethod
    public void closeResources() throws IOException {
        client.close();
        response.close();
    }

}
