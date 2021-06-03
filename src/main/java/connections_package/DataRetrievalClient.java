package connections_package;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class DataRetrievalClient {
    public DataRetrievalClient() {}

    /**
     * Sends a GET request to the given URL
     * @param url the URL the request is being sent to
     * @throws URISyntaxException
     */
    public HttpRequest createGetRequest(String url) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .GET()
                .build();
        return request;
    }

    public HttpRequest sendPostRequest(String url, String data) throws URISyntaxException {
        HttpRequest request = HttpRequest.newBuilder(new URI(url))
                .header("Content-Type", "text/plain; charset=UTF-8")
                .POST(HttpRequest.BodyPublishers.ofString(data))
                .build();
        return request;
    }

    public String getJSONFromPokeAPI(HttpRequest request) throws IOException, InterruptedException {
        HttpResponse<String> response = HttpClient.newBuilder()
                .build()
                .send(request, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
        return response.body();
    }
}
