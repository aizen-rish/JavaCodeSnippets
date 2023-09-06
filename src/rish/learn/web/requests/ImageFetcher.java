package rish.learn.web.requests;

import java.awt.PageAttributes.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.fluent.Request;
import org.apache.hc.client5.http.fluent.Response;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.net.URIBuilder;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class ImageFetcher {

    private static final String APOD_URL = "https://api.nasa.gov/planetary/apod";

    private String apiKey;

    public void fetchImage() throws Exception {

        fetchLegacy();
        fetchLatest();

        fetchExtra();
        fetchUsingOkHttp();
        fetchUSingSpring();
    }

    private void fetchLegacy() throws IOException {

        URL url = new URL(APOD_URL + "?api_key=DEMO_KEY");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestMethod("GET");
        conn.setRequestProperty("accept", "application/json");

        InputStream iStream = conn.getInputStream();

        ObjectMapper mapper = new ObjectMapper();
        APOD apod = mapper.readValue(iStream, APOD.class);

        System.out.println(apod.url);
    }

    private void fetchLatest() throws IOException, InterruptedException {

        var client = HttpClient.newHttpClient();

        URI uri = URI.create(APOD_URL + "?api_key=DEMO_KEY");

        var request = HttpRequest.newBuilder(uri).header("accept", "application/json").build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

        System.out.println(response.body());
    }

    private void fetchExtra() throws IOException, URISyntaxException {

        System.out.println(apiKey);

        try (CloseableHttpClient client = HttpClients.createDefault()) {

            URI uri = new URIBuilder(APOD_URL).addParameter("api_key", "DEMO_KEY").build();
            var request = new HttpGet(uri);

            ObjectMapper mapper = new ObjectMapper();
            var response = client.execute(request,
                    hResponse -> mapper.readValue(hResponse.getEntity().getContent(), APOD.class));

            System.out.println(response.url);
        }
    }

    private void fetchUsingOkHttp() throws IOException {

        ObjectMapper mapper = new ObjectMapper();
        OkHttpClient client = new OkHttpClient();

        Request request = new Request.Builder().url(APOD_URL + "?api_key=DEMO_KEY").build();

        Response response = client.newCall(request).execute();

        APOD apod = mapper.readValue(response.body().byteStream(), APOD.class);

        System.out.println(apod.url);
    }

    private void fetchUsingSpring() {

        RestTemplate temp = new RestTemplate();
        APOD obj = temp.getForObject(APOD_URL + "?api_key=DEMO_KEY", APOD.class);

        System.out.println(obj.date);

        WebClient client = WebClient.create(APOD_URL + "?api_key=DEMO_KEY");
        Mono<String> body = client.get().accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(String.class);

        String output = body.block();
        System.out.println(output);
    }

    public static void main(String[] args) {

        ImageFetcher f = new ImageFetcher();

        try {
            f.fetchImage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
