import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class StreamsKTest {
    @Test
    public void All_British_customers_get_invoiced() {
        StreamsK s = new StreamsK(
            new StreamsK.Customer("Furtles", "Earl Grey tea"),
            new StreamsK.Customer("Hogswash", "Black coffee"),
            new StreamsK.Customer("Junipers", "Orange squash"),
            new StreamsK.Customer("AmberCore", "White Lightning")
        );

        assertThat(
            s.britishCustomers(),
            equalTo(Arrays.asList("Furtles", "Junipers"))
        );
    }
}
