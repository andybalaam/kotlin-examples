import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamsTest {
    @Test
    public void All_Hot_customers_get_noticed() {
        Streams s = new Streams(
            new Streams.Customer("Furtles", "Earl Grey tea"),
            new Streams.Customer("Junipers", "Orange squash"),
            new Streams.Customer("Hogswash", "Black coffee"),
            new Streams.Customer("AmberCore", "White Lightning")
        );

        assertThat(
            s.hotCustomers(),
            equalTo(Arrays.asList("Furtles", "Hogswash"))
        );
    }
}
