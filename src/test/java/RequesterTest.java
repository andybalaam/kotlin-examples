import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequesterTest {
    @Test
    public void Create_Requester_3_ways() {
        Requester r1 = new Requester("a", "b", "example.com", true);
        Requester r2 = new Requester(false, "example.com", new TestHttpClient());
        Requester r3 = new Requester("http", "example.com", new TestHttpClient());
        assertThat(r1, not(nullValue()));
        assertThat(r2, not(nullValue()));
        assertThat(r3, not(nullValue()));
    }

    private class TestHttpClient implements Requester.HttpClient {
        @Override
        public String get(String path) {
            return null;
        }
    }
}
