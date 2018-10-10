import org.junit.Test;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class RequesterKTest {
    @Test
    public void Create_Requester_3_ways() {
        RequesterK r1 = new RequesterK("a", "b", "example.com", true);
        RequesterK r2 = new RequesterK(false, "example.com", new TestHttpClient());
        RequesterK r3 = new RequesterK("http", "example.com", new TestHttpClient());
        assertThat(r1, not(nullValue()));
        assertThat(r2, not(nullValue()));
        assertThat(r3, not(nullValue()));
    }

    private class TestHttpClient implements RequesterK.HttpClient {
        @Override
        public String get(String path) {
            return null;
        }
    }
}
