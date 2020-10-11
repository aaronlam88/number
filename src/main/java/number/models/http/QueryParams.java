package number.models.http;

import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.client.utils.URIBuilder;

public class QueryParams {
    private List<Pair<String, String>> params = new LinkedList<>();

    public QueryParams() {
    }

    public QueryParams(List<Pair<String, String>> queryParams) {
        this.params.addAll(queryParams);
    }

    public QueryParams addParam(String key, String value) {
        this.params.add(Pair.of(key, value));
        return this;
    }

    public QueryParams addParams(String k1, String v1, String k2, String v2) {
        return this.addParam(k1, v1).addParam(k2, v2);
    }

    public QueryParams addParams(String k1, String v1, String k2, String v2, String k3, String v3) {
        return this.addParam(k1, v1).addParam(k2, v2).addParam(k3, v3);
    }

    public URIBuilder buildURI(URIBuilder uriBuilder) {
        params.stream()
                .forEach(param -> uriBuilder.addParameter(param.getKey(), param.getValue()));
        return uriBuilder;
    }
}
