import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

class ResponseUtilities {

    static String getHeader(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream()
                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                .findFirst().orElseThrow(() -> new RuntimeException("Didn't finde the header"));
        return matchedHeader.getValue();
    }

    static boolean isHeaderPresent(CloseableHttpResponse response, final String headerName) {
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);

        return httpHeaders.stream()
                .anyMatch(header -> header.getName().equalsIgnoreCase(headerName));
    }

    static <T> T unmarshall(CloseableHttpResponse response, Class<T> _class) throws IOException {

        String jsonBody = EntityUtils.toString(response.getEntity());
        return new ObjectMapper()
                .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                .readValue(jsonBody, _class);

    }
}
