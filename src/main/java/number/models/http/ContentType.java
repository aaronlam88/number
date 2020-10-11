package number.models.http;

import org.apache.commons.lang3.tuple.Pair;

import okhttp3.MediaType;

public enum ContentType {
    JSON {
        @Override
        public MediaType getMediaType() {
            return MediaType.get("application/json");
        }

        @Override
        public Pair<String, String> getHeader() {
            return Pair.of(Constants.CONTENT_TYPE, "application/json");
        }
    },
    FORM {
        @Override
        public MediaType getMediaType() {
            return MediaType.parse(Constants.TEXT);
        }

        @Override
        public Pair<String, String> getHeader() {
            return null;
        }
    },
    FORM_URLENCODED {
        @Override
        public MediaType getMediaType() {
            return MediaType.parse("application/x-www-form-urlencoded");
        }

        @Override
        public Pair<String, String> getHeader() {
            return Pair.of(Constants.CONTENT_TYPE, "application/x-www-form-urlencoded");
        }
    },
    TEXT {
        @Override
        public MediaType getMediaType() {
            return MediaType.parse(Constants.TEXT);
        }

        @Override
        public Pair<String, String> getHeader() {
            return Pair.of(Constants.CONTENT_TYPE, Constants.TEXT);
        }
    };

    public abstract MediaType getMediaType();

    public abstract Pair<String, String> getHeader();

    private static class Constants {
        public static final String CONTENT_TYPE = "Content-Type";
        public static final String TEXT = "text/plain";
    }
}
