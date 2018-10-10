class Requester {
    private final String scheme;
    private final String host;
    private final HttpClient client;

    public Requester(
        String user, String pass, String host, boolean useSsl) {
        this(useSsl, host, new SimpleClient(user, pass));
    }

    Requester(boolean useSsl, String host, HttpClient client) {
        this(useSsl ? "https" : "http", host, client);
    }

    Requester(String scheme, String host, HttpClient client) {
        this.scheme = scheme;
        this.host = host;
        this.client = client;
    }

    interface HttpClient {
        String get(String path);
    }

    private static class SimpleClient implements HttpClient {
        private final String user;
        private final String pass;

        public SimpleClient(String user, String pass) {
            this.user = user;
            this.pass =  pass;
        }

        @Override
        public String get(String path) {
            return "demo" + user + pass;
        }
    }
}
