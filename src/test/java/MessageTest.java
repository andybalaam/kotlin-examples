import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class MessageTest {
    @Test
    public void All_info_filled_in() {
        Message m = new Message("123", "Acme", "012", "acme", "hello there");
        assertThat(m.id, equalTo("123"));
        assertThat(m.customer, equalTo("Acme"));
        assertThat(m.to, equalTo("012"));
        assertThat(m.from, equalTo("acme"));
        assertThat(m.body, equalTo("hello there"));
    }

    @Test
    public void Just_to_address() {
        Message m = new Message("234").withTo("012");
        assertThat(m.to, equalTo("012"));
    }
}
