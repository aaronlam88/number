package number.utils.http;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.concurrent.TimeUnit;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import org.apache.http.client.utils.URIBuilder;

import lombok.extern.apachecommons.CommonsLog;
import number.models.http.ContentType;
import number.models.http.Headers;
import number.models.http.Method;
import number.models.http.QueryParams;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@CommonsLog
public class HttpAdapter {
    private HttpAdapter() {
        throw new IllegalStateException("Utility class");
    }

    private static Gson gson = new Gson();
    private static Response response;
    public static Response getResponse() {
        return response;
    }
    

    /**
     * make http request to url, with method, and optional content type and request
     * body
     * 
     * @param url:
     * @param method
     * @param headers
     * @param contentType
     * @param requestBody
     * @return Response
     * @throws IOException
     */
    public static Response httpRequest(String url, Method method, Headers headers, ContentType contentType,
            RequestBody requestBody) throws IOException {
        OkHttpClient client = new OkHttpClient().newBuilder().connectTimeout(10, TimeUnit.MINUTES).build();
        Request.Builder requestBuilder = new Request.Builder().url(url).method(method.name(), requestBody);
        // build header
        if (headers == null) {
            headers = new Headers();
        }
        if (contentType != null) {
            headers.add(contentType);
        }
        Request request = headers.buildRequest(requestBuilder).build();
        log.debug(request.toString());
        return client.newCall(request).execute();
    }

    public static Response get(String url, QueryParams queryParams, Headers headers)
            throws URISyntaxException, IOException {
        URIBuilder uriBuilder = new URIBuilder(url);
        if (queryParams != null) {
            queryParams.buildURI(uriBuilder);
        }
        return httpRequest(uriBuilder.toString(), Method.GET, headers, null, null);
    }

    public static Response send(String url, Method method, Headers headers, ContentType contentType,
            RequestBody requestBody) throws IOException {
        return httpRequest(url, method, headers, contentType, requestBody);
    }

    public static Response send(String url, Method method, Headers headers, ContentType contentType,
            String requestBodyString) throws IOException {
        RequestBody requestBody = RequestBody.create(requestBodyString, contentType.getMediaType());
        return httpRequest(url, method, headers, contentType, requestBody);
    }

    public static JsonElement toJsonElement(Response response) {
        return gson.fromJson(new InputStreamReader(response.body().byteStream()), JsonElement.class);
    }
}
