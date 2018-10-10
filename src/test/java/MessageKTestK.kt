import org.junit.Test

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class MessageKTestK {
    @Test
    fun All_info_filled_in() {
        val m = MessageK("123", "Acme", "012", "acme", "hello there")
        assertThat(m.id, equalTo("123"))
        assertThat(m.customer, equalTo("Acme"))
        assertThat(m.to, equalTo("012"))
        assertThat(m.from, equalTo("acme"))
        assertThat(m.body, equalTo("hello there"))
    }

    @Test
    fun Just_to_address() {
        val m = MessageK("234", to="012")
        assertThat(m.to, equalTo("012"))
    }
}
