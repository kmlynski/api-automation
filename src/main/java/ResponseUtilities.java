import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;

import java.util.Arrays;
import java.util.List;

public class ResponseUtilities {

    public static String getHeader(CloseableHttpResponse response, String headerName) {
        List<Header> httpHeaders = Arrays.asList(response.getAllHeaders());

        Header matchedHeader = httpHeaders.stream()
                                .filter(header -> headerName.equalsIgnoreCase(header.getName()))
                                .findFirst().orElseThrow(() -> new RuntimeException("Didn't finde the header"));
        return matchedHeader.getValue();
    }

    public static boolean isHeaderPresent(CloseableHttpResponse response, final String headerName){
        Header[] headers = response.getAllHeaders();
        List<Header> httpHeaders = Arrays.asList(headers);

        return httpHeaders.stream()
                .anyMatch(header  -> header.getName().equalsIgnoreCase(headerName));
    }
}
