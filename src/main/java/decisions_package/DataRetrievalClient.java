package decisions_package;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class DataRetrievalClient {

    /**
     * HttpClient, necessary for sending messages
     */

    public DataRetrievalClient() {

    }

    /**
     * Code taken from https://zetcode.com/java/getpostrequest/
     * Sends a GET request to the given URL
     * @param url the URL the request is being sent to
     * @throws URISyntaxException
     */
    public String createAndSendGetRequest(String url) throws IOException {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpGet request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {

                builder.append(line);
                builder.append(System.lineSeparator());
            }

            return builder.toString();
        }
    }

    /**
     * Similar to the above, except for sending a POST request
     * This is used to log into the Pokemon Showdown account
     * @param url
     * @param data
     * @return
     * @throws URISyntaxException
     */

    public String createAndSendPostRequest(String url, String data) throws IOException {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            HttpPost request = new HttpPost(url);
            request.setEntity(new StringEntity(data));
            request.setHeader("User-Agent", "Java client");
            request.setHeader("Content-Type", "application/x-www-form-urlencoded; encoding=UTF-8");

            CloseableHttpResponse response = client.execute(request);

            BufferedReader bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            StringBuilder builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {

                builder.append(line);
                builder.append(System.lineSeparator());
            }

            return builder.toString();
        }
    }
}
