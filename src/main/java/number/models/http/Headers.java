package number.models.http;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;

import okhttp3.Request;

public class Headers {
    private List<Pair<String, String>> queryParams = new LinkedList<>();

    public Headers() {
    }

    public Headers(List<Pair<String, String>> queryParams) {
        this.queryParams.addAll(queryParams);
    }

    public Headers add(String key, String value) {
        this.queryParams.add(Pair.of(key, value));
        return this;
    }

    public Headers add(String k1, String v1, String k2, String v2) {
        return this.add(k1, v1).add(k2, v2);
    }

    public Headers add(String k1, String v1, String k2, String v2, String k3, String v3) {
        return this.add(k1, v1).add(k2, v2).add(k3, v3);
    }

    public Headers add(ContentType contentType) {
        if (contentType != null && contentType.getHeader() != null) {
            this.queryParams.add(contentType.getHeader());
        }
        return this;
    }

    public Request.Builder buildRequest(Request.Builder requestBuilder) {
        queryParams.stream().forEach(param -> requestBuilder.addHeader(param.getKey(), param.getValue()));
        return requestBuilder;
    }
}
