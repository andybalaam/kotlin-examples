import org.junit.Test

import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.CoreMatchers.nullValue
import org.hamcrest.MatcherAssert.assertThat

class RetryClassKTest {
    @Test
    fun Code_815_is_never_retried() {
        assertThat(
            whenToRetry(1000L, FatalError(815), 1),
            nullValue()
        )
        assertThat(
            whenToRetry(1000L, FatalError(815), 2),
            nullValue()
        )
    }

    @Test
    fun Code_711_is_always_retried_in_one_min() {
        assertThat(
            whenToRetry(1000L, FastError(711), 1),
            equalTo(1000L + 60 * 1000)
        )
        assertThat(
            whenToRetry(1000L, FastError(711), 2),
            equalTo(1000L + 60 * 1000)
        )
    }

    @Test
    fun Initially_451_is_retried_in_one_hour() {
        assertThat(
            whenToRetry(1000L, SlowError(451), 1),
            equalTo(1000L + 60 * 60 * 1000)
        )
    }

    @Test
    fun Next_451_is_retried_in_two_hours() {
        assertThat(
            whenToRetry(1000L, SlowError(451), 2),
            equalTo(1000L + 2 * 60 * 60 * 1000)
        )
    }
}
