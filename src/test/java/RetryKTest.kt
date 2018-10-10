import org.junit.Test

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat

class RetryKTest {
    @Test
    fun Code_815_is_never_retried() {
        assertThat(
            whenToRetry(1000L, 815, 1),
            equalTo(Retry.NEVER)
        )
        assertThat(
            whenToRetry(1000L, 815, 2),
            equalTo(Retry.NEVER)
        )
    }

    @Test
    fun Code_711_is_always_retried_in_one_min() {
        assertThat(
            whenToRetry(1000L, 711, 1),
            equalTo(1000L + 60 * 1000)
        )
        assertThat(
            whenToRetry(1000L, 711, 2),
            equalTo(1000L + 60 * 1000)
        )
    }

    @Test
    fun Initially_451_is_retried_in_one_hour() {
        assertThat(
            whenToRetry(1000L, 451, 1),
            equalTo(1000L + 60 * 60 * 1000)
        )
    }

    @Test
    fun Next_451_is_retried_in_two_hours() {
        assertThat(
            whenToRetry(1000L, 451, 2),
            equalTo(1000L + 2 * 60 * 60 * 1000)
        )
    }
}
