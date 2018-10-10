import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class RetryTest {
    @Test
    public void Code_815_is_never_retried() {
        assertThat(
            Retry.whenToRetry(1000L, 815, 1),
            equalTo(Retry.NEVER)
        );
        assertThat(
            Retry.whenToRetry(1000L, 815, 2),
            equalTo(Retry.NEVER)
        );
    }

    @Test
    public void Code_711_is_always_retried_in_one_min() {
        assertThat(
            Retry.whenToRetry(1000L, 711, 1),
            equalTo(1000L + (60*1000))
        );
        assertThat(
            Retry.whenToRetry(1000L, 711, 2),
            equalTo(1000L + (60*1000))
        );
    }

    @Test
    public void Initially_451_is_retried_in_one_hour() {
        assertThat(
            Retry.whenToRetry(1000L, 451, 1),
            equalTo(1000L + (60*60*1000))
        );
    }

    @Test
    public void Next_451_is_retried_in_two_hours() {
        assertThat(
            Retry.whenToRetry(1000L, 451, 2),
            equalTo(1000L + (2*60*60*1000))
        );
    }
}
