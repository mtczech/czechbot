package connections_package;

import org.apache.http.Consts;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataRetrievalClient {
    /**
     * HttpClient, necessary for sending messages
     */

    HttpClient client;

    public DataRetrievalClient() {
        client = HttpClient.newHttpClient();
    }

    /**
     * Code taken from https://zetcode.com/java/getpostrequest/
     * Sends a GET request to the given URL
     * @param url the URL the request is being sent to
     * @throws URISyntaxException
     */
    public String createAndSendGetRequest(String url) throws IOException {
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {

            var request = new HttpGet(url);
            CloseableHttpResponse response = client.execute(request);

            var bufReader = new BufferedReader(new InputStreamReader(
                    response.getEntity().getContent()));

            var builder = new StringBuilder();

            String line;

            while ((line = bufReader.readLine()) != null) {

                builder.append(line);
                builder.append(System.lineSeparator());
            }

            System.out.println(builder);
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
            System.out.println(request.getEntity().getContent().transferTo(System.out));
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

            System.out.println(builder);
            return builder.toString();
        }
    }

    public String sendHTTPRequest(HttpRequest request) throws InterruptedException, IOException {
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println("The message was sent");
        return response.body();
    }
}
