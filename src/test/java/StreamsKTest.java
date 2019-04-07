import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamsKTest {
    @Test
    public void All_Hot_customers_get_noticed() {
        StreamsK s = new StreamsK(
            new StreamsK.Customer("Furtles", "Earl Grey tea"),
            new StreamsK.Customer("Junipers", "Orange squash"),
            new StreamsK.Customer("Hogswash", "Black coffee"),
            new StreamsK.Customer("AmberCore", "White Lightning")
        );

        assertThat(
            s.hotCustomers(),
            equalTo(Arrays.asList("Furtles", "Hogswash"))
        );
    }
}
